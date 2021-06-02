package com.example.janvi.ratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RatingBar rb;
    EditText review;
    Button b1;
    TextView tv,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb=(RatingBar) findViewById(R.id.rb);
        b1=(Button)findViewById(R.id.b1);
        review=(EditText)findViewById(R.id.review);
        tv=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView2);


       rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, final float rating, boolean fromUser) {
                tv.setText("rating:"+rating);


            }
        });
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tv2.setText(review.getText().toString());
           }
       });
    }
}
