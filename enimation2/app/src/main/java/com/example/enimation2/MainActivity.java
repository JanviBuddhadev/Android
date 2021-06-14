package com.example.enimation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.imageView);
        iv.animate().translationXBy(-1000);
        iv.animate().translationXBy(100).rotation(1800).setDuration(2000);
    }

    public void fade(View view) {
        //iv.animate().translationYBy(1900).setDuration(2000);
        //iv.animate().translationXBy(-1000).setDuration(2000);
        //iv.animate().rotation(1800).setDuration(5000);
        //iv.animate().rotation(1800).alpha(0).setDuration(5000);
        //iv.animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000);
    }
}
