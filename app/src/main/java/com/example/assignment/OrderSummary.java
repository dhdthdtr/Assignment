package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class OrderSummary extends AppCompatActivity {
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    double shippingCost = 10.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        // get datas from bundle
        Bundle bundle = getIntent().getExtras();
        int ID = bundle.getInt("ID");
        String name = bundle.getString("name");
        String quantity = bundle.getString("quantity");
        String flavor = bundle.getString("flavor");
        String icing = bundle.getString("icing");
        String size = bundle.getString("size");
        double cost = bundle.getDouble("cost") * Integer.parseInt(quantity);
        String customer_name = bundle.getString("customer_name");
        String customer_email = bundle.getString("customer_email");
        String customer_phoneNo = bundle.getString("customer_phoneNo");
        String customer_address = bundle.getString("customer_address");
        String order_date = bundle.getString("order_date");
        String order_time = bundle.getString("order_time");
        String order_type = bundle.getString("order_type");
        String event_type = bundle.getString("event_type");
        String order_paymentMethod = bundle.getString("order_paymentMethod");

        TextView summary_productName = findViewById(R.id.summary_productName);
        TextView summary_quantity = findViewById(R.id.summary_quantity);
        TextView summary_productFlavor = findViewById(R.id.summary_flavor);
        TextView summary_icing = findViewById(R.id.summary_icing);
        TextView summary_size = findViewById(R.id.summary_size);
        TextView summary_shippingCost = findViewById(R.id.summary_shippingCost);
        TextView summary_productCost = findViewById(R.id.summary_productCost);
        TextView summary_totalCost = findViewById(R.id.summary_totalCost);
        TextView summary_customer_name = findViewById(R.id.summary_customer_name);
        TextView summary_customer_email = findViewById(R.id.summary_customer_email);
        TextView summary_customer_phoneNo = findViewById(R.id.summary_customer_phoneNo);
        TextView summary_customer_address = findViewById(R.id.summary_customer_address);
        TextView summary_orderDate = findViewById(R.id.summary_order_date);
        TextView summary_orderTime = findViewById(R.id.summary_order_time);
        TextView summary_orderType = findViewById(R.id.summary_order_type);
        TextView summary_order_paymentMethod = findViewById(R.id.summary_paymentMethod);
        TextView summary_eventType = findViewById(R.id.summary_eventType);

        // show datas on bill
        summary_customer_name.setText("Customer Name: " + customer_name);
        summary_customer_email.setText("Customer Email: " + customer_email);
        summary_customer_phoneNo.setText("Phone Number: " + customer_phoneNo);
        summary_customer_address.setText("Delivery Address: " + customer_address);

        switch(ID){
            case 0:
            case 2:
                summary_size.setVisibility(View.GONE);

                summary_productName.setText("Name: " + name);
                summary_quantity.setText("Quantity: " + quantity);
                summary_productFlavor.setText("Flavor: " + flavor);
                summary_icing.setText("Icing: " + icing);
                break;
            case 1:
            case 5:
                summary_productName.setText("Name: " + name);
                summary_quantity.setText("Quantity: " + quantity);
                summary_productFlavor.setText("Flavor: " + flavor);
                summary_icing.setText("Icing: " + icing);
                summary_size.setText("Size: " + size);
                break;
            case 3:
            case 4:
                summary_icing.setVisibility(View.GONE);
                summary_size.setVisibility(View.GONE);

                summary_productName.setText("Name: " + name);
                summary_quantity.setText("Quantity: " + quantity);
                summary_productFlavor.setText("Flavor: " + flavor);
                break;
            default:
                break;
        }
        summary_eventType.setText("Event Type: " + event_type);

        summary_orderType.setText("Type of Order: " + order_type);
        summary_orderDate.setText("Delivery Date: " + order_date);
        summary_orderTime.setText("Delivery Time: " + order_time);

        summary_order_paymentMethod.setText("Method of Payment: " + order_paymentMethod);
        summary_shippingCost.setText("Shipping Cost: " + decimalFormat.format(shippingCost));
        summary_productCost.setText("Product Cost: " + decimalFormat.format(cost));
        summary_totalCost.setText("Total Cost: " + decimalFormat.format(shippingCost + cost));

        // go back to main page
        Button btn_home = findViewById(R.id.btn_mainpage);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderSummary.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}