package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        // find view by id
        Button bt_bounce = findViewById(R.id.anim_bounce);
        Button bt_rotate = findViewById(R.id.anim_rotate);
        Button bt_sequential = findViewById(R.id.anim_sequential);
        Button bt_together = findViewById(R.id.anim_together);
        ImageView img = findViewById(R.id.anim_image);
        // bounce animation
        bt_bounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(AnimationTask.this, R.anim.bounce_animation);
                img.startAnimation(animation);
            }
        });
        // rotate animation
        bt_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(AnimationTask.this, R.anim.rotate_animation);
                img.startAnimation(animation);
            }
        });
        // sequential animation
        bt_sequential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(AnimationTask.this, R.anim.sequential_animation);
                img.startAnimation(animation);
            }
        });
        // together animation
        bt_together.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(AnimationTask.this, R.anim.together_animation);
                img.startAnimation(animation);
            }
        });
    }
    // create menu on action bar for switching between bakery activity and animation activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.switch_to_bakery, menu);
        return true;
    }
    // select item to switch activity
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case(R.id.bakery_app):
                Intent intent = new Intent(AnimationTask.this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}