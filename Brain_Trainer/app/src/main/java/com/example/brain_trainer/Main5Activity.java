package com.example.brain_trainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Main5Activity extends AppCompatActivity {
    public static final String EXTRA_SCORE="extrascore";
    TextView que,scoretext,time1,quecount;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3;
    Button b1;
    List<Questions> quelist;
    //this variable will store how many que we have shown
    private int quecounter;
    //total que we have in our array list
    private int quecounttotal;
    private Questions currentque;
    private int score;
    private boolean answered;
    //countdown time
    private static final long COUNTDOWN_IN_MILLIS=30000;
    private ColorStateList textcolordefaultcd;   //cd for countdown
    private CountDownTimer countDownTimer;
    private long timeleftinmillis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        que=findViewById(R.id.textView3);
        scoretext=findViewById(R.id.textView5);
        time1=findViewById(R.id.textView6);
        quecount=findViewById(R.id.textView4);
        rg=findViewById(R.id.radioGroup);
        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rb3=findViewById(R.id.radioButton3);
        //for countdown timer
        textcolordefaultcd=time1.getTextColors();
        b1=findViewById(R.id.button);
        Quizdbhelper dbhelper=new Quizdbhelper(this);
        quelist=dbhelper.getallque();
        //total que in the list
        quecounttotal=quelist.size();
        //shuffling que we want que in random order
        Collections.shuffle(quelist);
        showcase();


}
    public void buttonclick(View view) {
        if(rb1.isChecked()|rb2.isChecked()|rb3.isChecked()){

            checkans();
        }
        else{
            Toast.makeText(Main5Activity.this, "Please select an answer", Toast.LENGTH_LONG).show();
        }
    }
    private void showcase()
    {

        rg.clearCheck();
        if(quecounter<quecounttotal)
        {
            currentque=quelist.get(quecounter);
            que.setText(currentque.getQue());
            rb1.setText(currentque.getOption1());
            rb2.setText(currentque.getOption2());
            rb3.setText(currentque.getOption3());
            quecounter++;
            quecount.setText("Question: "+ quecounter +"/"+quecounttotal);
            //answered=false;
            timeleftinmillis=COUNTDOWN_IN_MILLIS;
            startcoundown();
        }
        else
        {
            finishquiz();
        }

    }
    private void startcoundown()
    {
        countDownTimer=new CountDownTimer(timeleftinmillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftinmillis=millisUntilFinished;
                updatecountdowntext();
            }

            @Override
            public void onFinish() {
                timeleftinmillis=0;
                updatecountdowntext();
                checkans();
            }
        }.start();
    }
    private void updatecountdowntext()
    {
        int minutes= (int) (timeleftinmillis/1000)/60;
        int seconds=(int) (timeleftinmillis/1000)%60;
        String timeformatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        time1.setText(timeformatted);
        if(timeleftinmillis<10000)
        {
            time1.setTextColor(Color.RED);
        }
        else{
            time1.setTextColor(textcolordefaultcd);
        }
        if(timeleftinmillis==0000)
        {
            Toast.makeText(this, "time over you have to restart!...", Toast.LENGTH_LONG).show();
            finish();
            //Intent i=new Intent(getApplicationContext(),Main4Activity.class);
            //startActivity(i);
        }
    }
    private void checkans()
    {
        countDownTimer.cancel();
        RadioButton rbSelected = findViewById(rg.getCheckedRadioButtonId());
        int answerNr = rg.indexOfChild(rbSelected) + 1;

        if (answerNr == currentque.getCorrect()) {

            score++;
            scoretext.setText("Score: " + score);
            showcase();
        }
        else if(answerNr==0){
            Toast.makeText(this, "time over you have to restart!...", Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(this, "Wrong!....", Toast.LENGTH_SHORT).show();
        }

    }
    private void finishquiz()
    {
        Intent i=new Intent();
        i.putExtra(EXTRA_SCORE,score);
        setResult(RESULT_OK,i);
        finish();
    }
    //when our activity is finished we have to stop countdown otherwise it will be running in background so i am overriding on destroy method here

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer!=null)
        {
            countDownTimer.cancel();
        }
    }
}

