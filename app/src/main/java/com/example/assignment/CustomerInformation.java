package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CustomerInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_information);

        // find view by id
        Button btn_order = findViewById(R.id.btn_order);
        EditText customer_name = findViewById(R.id.customer_name);
        EditText customer_email = findViewById(R.id.customer_email);
        EditText customer_phoneNo = findViewById(R.id.customer_phoneNumber);
        EditText customer_address = findViewById(R.id.customer_deliveryAddress);

        // set listener for order button
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerInformation.this, Order.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("customer_name", customer_name.getText().toString());
                bundle.putString("customer_email", customer_email.getText().toString());
                bundle.putString("customer_phoneNo", customer_phoneNo.getText().toString());
                bundle.putString("customer_address", customer_address.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}