package com.example.basic_phrases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void play(View view) {
        Button b1= (Button) view;
        Log.i("info",b1.getTag().toString());
        MediaPlayer mPlayer = MediaPlayer.create(this, getResources().getIdentifier(b1.getTag().toString(), "raw", getPackageName()));
        mPlayer.start();
    }
}
