package com.example.football_winner_counter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score=0; int scoreb=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView scoretv=(TextView)findViewById(R.id.tv2);
        Button bta3=(Button)findViewById(R.id.bt3);
        Button bta2=(Button)findViewById(R.id.bt2);
        Button bta1=(Button)findViewById(R.id.bt1);

        TextView scoretvb=(TextView) findViewById(R.id.tvb2);
        Button btb3=(Button)findViewById(R.id.btb3);
        Button btb2=(Button)findViewById(R.id.btb2);
        Button btb1=(Button)findViewById(R.id.btb1);
        Button reb=(Button)findViewById(R.id.rebutton);

        bta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score+=3;
                scoretv.setText(String.valueOf(score));
            }
        });

        bta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score+=2;
                scoretv.setText(String.valueOf(score));
            }
        });

        bta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score+=1;
                scoretv.setText(String.valueOf(score));
            }
        });

        // Team B
        btb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreb+=3;
                scoretvb.setText(String.valueOf(scoreb));
            }
        });

        btb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreb+=2;
                scoretvb.setText(String.valueOf(scoreb));
            }
        });

        btb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreb+=1;
                scoretvb.setText(String.valueOf(scoreb));
            }
        });

        reb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=0;
                scoreb=0;
                scoretv.setText(String.valueOf(score));
                scoretvb.setText(String.valueOf(scoreb));
            }
        });
    }
}