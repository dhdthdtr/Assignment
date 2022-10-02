package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class Order extends AppCompatActivity implements View.OnClickListener {
    EditText selectdate, selecttime;
    public int mYear, mMonth, mDay;
    public int selectedHour, selectedMinute;
    String[] paymentList;
    String paymentMethod;
    boolean is24hView = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_order);

        // set onClickListener for calendar select
        selectdate = findViewById ( R.id.edittext_date );
        selectdate.setOnClickListener ( this );

        // set onClickListener for time select
        selecttime = findViewById(R.id.edittext_time);
        selecttime.setOnClickListener(this);

        // show the paymentMethod array on spinner
        Spinner sp_paymentMethod = findViewById(R.id.spinner_paymentMethod);
        paymentList = getResources().getStringArray(R.array.paymentMethod);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paymentList);
        sp_paymentMethod.setAdapter(adapter);

        sp_paymentMethod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paymentMethod = paymentList[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        RadioGroup order_type = findViewById(R.id.rg_ordertype);
        EditText order_date = findViewById(R.id.edittext_date);
        EditText order_time = findViewById(R.id.edittext_time);
        RadioGroup event_type = findViewById(R.id.rg_eventtype);

        //----------------------------------------
        Button btn_ordernow = findViewById(R.id.button_orderNow);
        btn_ordernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order.this, OrderSummary.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("order_date", order_date.getText().toString());
                bundle.putString("order_time", order_time.getText().toString());
                bundle.putString("order_type", ((RadioButton) findViewById(order_type.getCheckedRadioButtonId())).getText().toString());
                bundle.putString("event_type", ((RadioButton) findViewById(event_type.getCheckedRadioButtonId())).getText().toString());
                bundle.putString("order_paymentMethod", paymentMethod);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    // handling onClick for calendar selection and time selection (24h type)
    @Override
    public void onClick(View v) {
        if (v == selectdate) {
            final Calendar calendar = Calendar.getInstance ();
            mYear = calendar.get ( Calendar.YEAR );
            mMonth = calendar.get ( Calendar.MONTH );
            mDay = calendar.get ( Calendar.DAY_OF_MONTH );

            //show dialog
            DatePickerDialog datePickerDialog = new DatePickerDialog ( this, new DatePickerDialog.OnDateSetListener () {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    selectdate.setText (String.format("%02d/%02d/%04d", dayOfMonth, month, year));
                }
            }, mYear, mMonth, mDay );
            datePickerDialog.show ();
        }

        if(v == selecttime){
            TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    selecttime.setText(String.format("%02d:%02d", hourOfDay, minute));
                    selectedHour = hourOfDay;
                    selectedMinute = minute;
                }
            };

            // create timepicker dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar, timeSetListener, selectedHour, selectedMinute, is24hView);
            timePickerDialog.show();
        }
    }
}