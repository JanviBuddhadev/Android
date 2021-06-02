package com.example.janvi.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox cb;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb= (CheckBox) findViewById(R.id.checkBox);
        tv= (TextView) findViewById(R.id.textView);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb.isChecked()) {
                    tv.setText(cb.getText());
                }
                else
                {
                    tv.setText("you have selected nothing yet");
                }
            }
        });

    }
}
