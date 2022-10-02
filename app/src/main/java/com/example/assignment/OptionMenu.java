package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class OptionMenu extends AppCompatActivity {
    String flavor, icing, size, quantity, name;
    double cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);

        LinearLayout layout_sweetFlavor = findViewById(R.id.layout_sweetFlavor);
        LinearLayout layout_normalFlavor = findViewById(R.id.layout_normalFlavor);
        LinearLayout layout_icing = findViewById(R.id.layout_icing);
        LinearLayout layout_size = findViewById(R.id.layout_size);
        Button bt_submit = findViewById(R.id.btn_submit);
        RadioGroup rg_normalFlavor = findViewById(R.id.rg_normalFlavor);
        RadioGroup rg_sweetFlavor = findViewById(R.id.rg_sweetFlavor);
        RadioGroup rg_icing = findViewById(R.id.rg_icing);
        RadioGroup rg_size = findViewById(R.id.rg_size);
        EditText et_quantity = findViewById(R.id.edittext_quantity);

        // set form for each bakery product
        int listViewItems = getIntent().getExtras().getInt("ID");
        switch (listViewItems){
            case 0:
            case 2:
                layout_size.setVisibility(View.GONE);
                layout_normalFlavor.setVisibility(View.GONE);

                layout_sweetFlavor.setVisibility(View.VISIBLE);
                layout_icing.setVisibility(View.VISIBLE);
                break;
            case 1:
            case 5:
                layout_normalFlavor.setVisibility(View.GONE);
                layout_sweetFlavor.setVisibility(View.VISIBLE);
                layout_icing.setVisibility(View.VISIBLE);
                layout_size.setVisibility(View.VISIBLE);
                break;
            case 3:
            case 4:
                layout_sweetFlavor.setVisibility(View.GONE);
                layout_icing.setVisibility(View.GONE);
                layout_size.setVisibility(View.GONE);
                layout_normalFlavor.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }

        // set listener for submit button when user have chosen all toppings
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionMenu.this, CustomerInformation.class);
                Bundle bundle = new Bundle();
                bundle.putInt("ID", listViewItems);
                switch (listViewItems){
                    case 0:
                    case 2:
//                        layout_sweetFlavor.setVisibility(View.VISIBLE);
//                        layout_icing.setVisibility(View.VISIBLE);
                        if(listViewItems == 0){
                            name = "Cupcake";
                            cost = 2.00;
                        } else if(listViewItems == 2){
                            name = "Donut";
                            cost = 1.00;
                        }
                        quantity = et_quantity.getText().toString();
                        flavor = ((RadioButton) findViewById(rg_sweetFlavor.getCheckedRadioButtonId())).getText().toString();
                        icing = ((RadioButton) findViewById(rg_icing.getCheckedRadioButtonId())).getText().toString();
                        bundle.putString("flavor", flavor);
                        bundle.putString("icing", icing);
                        bundle.putString("quantity", quantity);
                        bundle.putDouble("cost", cost);
                        bundle.putString("name", name);
                        intent.putExtras(bundle);

                        break;
                    case 1:
                    case 5:
//                        layout_sweetFlavor.setVisibility(View.VISIBLE);
//                        layout_icing.setVisibility(View.VISIBLE);
//                        layout_size.setVisibility(View.VISIBLE);
                        quantity = et_quantity.getText().toString();
                        flavor = ((RadioButton) findViewById(rg_sweetFlavor.getCheckedRadioButtonId())).getText().toString();
                        icing = ((RadioButton) findViewById(rg_icing.getCheckedRadioButtonId())).getText().toString();
                        size = ((RadioButton) findViewById(rg_size.getCheckedRadioButtonId())).getText().toString();
                        if(size.equals("Small") && listViewItems == 1){
                            cost = 2.00;
                        } else if (size.equals("Big") && listViewItems == 1){
                            cost = 4.00;
                        } else if (size.equals("Small") && listViewItems == 5){
                            cost = 35.00;
                        } else if (size.equals("Big") && listViewItems == 5){
                            cost = 50.00;
                        }
                        bundle.putString("name", name);
                        bundle.putString("quantity", quantity);
                        bundle.putString("flavor", flavor);
                        bundle.putString("icing", icing);
                        bundle.putString("size", size);
                        bundle.putDouble("cost", cost);
                        intent.putExtras(bundle);
                        break;
                    case 3:
                    case 4:
//                        layout_normalFlavor.setVisibility(View.VISIBLE);
                        if(listViewItems == 3){
                            cost = 1.50;
                        } else if (listViewItems == 4){
                            cost = 3.50;
                        }
                        flavor = ((RadioButton) findViewById(rg_normalFlavor.getCheckedRadioButtonId())).getText().toString();
                        bundle.putString("name", name);
                        bundle.putString("quantity", quantity);
                        bundle.putString("flavor", flavor);
                        bundle.putDouble("cost", cost);
                        intent.putExtras(bundle);
                        break;
                    default:
                        break;
                }
                startActivity(intent);
            }
        });
    }
}