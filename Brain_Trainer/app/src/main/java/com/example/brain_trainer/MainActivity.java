package com.example.brain_trainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    ImageView iv;
    TextView tv;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb=findViewById(R.id.progressBar);
        iv=findViewById(R.id.imageView);
        tv=findViewById(R.id.textView);
        iv.animate().alpha(0).setDuration(100);
        pb.getProgressDrawable().setColorFilter(
                Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<60)
                {
                    i++;

                    pb.setProgress(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(i==20){
                        iv.animate().alpha(1).setDuration(100);
                    }
                    if(i==60)
                    {
                        Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                        startActivity(i);
                    }
                }
            }
        }).start();
    }
}
