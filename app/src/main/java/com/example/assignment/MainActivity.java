package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    ArrayList<BakeryProduct> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main);

        productList = new ArrayList<>();

        // create 6 products
        BakeryProduct cupcake = new BakeryProduct("cupcake","Cupcake (RM2.00)");
        BakeryProduct cookies = new BakeryProduct("cookies","Cookies\n(Small - RM2.00, Big - RM4.00)");
        BakeryProduct donuts = new BakeryProduct("donut","Donut (RM1.00)");
        BakeryProduct rolls = new BakeryProduct("rolls","Rolls (RM1.50)");
        BakeryProduct bread = new BakeryProduct("bread","Bread (RM3.50)");
        BakeryProduct cakes = new BakeryProduct("cake","Cake\n(Small - RM35.00, Big - RM50.00)");

        // add products to product list
        productList.add(cupcake);
        productList.add(cookies);
        productList.add(donuts);
        productList.add(rolls);
        productList.add(bread);
        productList.add(cakes);

        // put products on custom list view
        final ListView listView = findViewById(R.id.list_bakeryProduct);
        listView.setAdapter(new CustomListView(this, productList));
        // when click on a listview, switch to choose topping activity (OptionMenu)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(MainActivity.this, OptionMenu.class);
                intent.putExtra("ID", position);
                startActivity(intent);
            }
        });
    }

    // create menu on action bar for switching between bakery activity and animation activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.switch_to_animation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.animation) {
            Intent intent = new Intent(MainActivity.this, AnimationTask.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}