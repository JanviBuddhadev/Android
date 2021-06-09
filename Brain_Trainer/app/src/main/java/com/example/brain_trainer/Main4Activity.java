package com.example.brain_trainer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    TextView tv7;

    private int highscore;
    private static final int REQUEST_CODE_QUIZ=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tv7=findViewById(R.id.textView7);
        loadHighscore();
    }

    public void easy(View view) {
        Intent i=new Intent(getApplicationContext(),Main5Activity.class);
        startActivityForResult(i,REQUEST_CODE_QUIZ);
         //int score=getIntent().getExtras().getInt("score");
        //tv7.setText(score);
    }

    public void hard(View view) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(Main5Activity.EXTRA_SCORE, 0);
                //Log.i("INFO", String.valueOf(score));
                //tv7.setText(String.valueOf(score));
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }
    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences("sharedpref", MODE_PRIVATE);
        highscore = prefs.getInt("keyhighscore", 0);
        tv7.setText("Highscore: " + highscore);
    }
   private void updateHighscore(int highscorenew)
    {
        highscore=highscorenew;
        tv7.setText("High Score:"+highscore);

        SharedPreferences prefs = getSharedPreferences("sharedpref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("keyhighscore", highscore);
        editor.apply();
    }
}

