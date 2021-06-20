package com.example.currencyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean a = true;
    ImageView iv,iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.imageView3);
        iv1 = findViewById(R.id.imageView4);
    }

    public void fade(View view) {
        if (a) {
            iv.animate().alpha(1).setDuration(2000);
            iv1.animate().alpha(0).setDuration(2000);
            a = false;
        } else {
            iv.animate().alpha(0).setDuration(2000);
            iv1.animate().alpha(1).setDuration(2000);
            a = true;
        }
    }
}