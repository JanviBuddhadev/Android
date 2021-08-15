package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class oneplayer extends AppCompatActivity {
    int activeplayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winingpositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    Boolean gameActive=true;
    Button restart;
    ArrayList<String> emptysquares=new ArrayList<>();

    public void computer()
    {
        if(gameActive==true)
        {
            int select=emptysquares.size();
            int selected=new Random().nextInt(select);
            String selectedSqares=emptysquares.get(selected);
            switch (selectedSqares)
            {
                case "0":
                    ImageView iv1=findViewById(R.id.imageView1);
                    iv1.setImageResource(R.drawable.x);
                    activeplayer=0;
                    emptysquares.remove(selectedSqares);
                    gameState[Integer.parseInt(selectedSqares)]=activeplayer;
                    break;
                case "1":
                    ImageView iv2=findViewById(R.id.imageView2);
                    iv2.setImageResource(R.drawable.x);
                    activeplayer=0;
                    emptysquares.remove(selectedSqares);
                    gameState[Integer.parseInt(selectedSqares)]=activeplayer;
                    break;
                case "2":
                    ImageView iv3=findViewById(R.id.imageView3);
                    iv3.setImageResource(R.drawable.x);
                    activeplayer=0;
                    emptysquares.remove(selectedSqares);
                    gameState[Integer.parseInt(selectedSqares)]=activeplayer;
                    break;
                case "3":
                    ImageView iv4=findViewById(R.id.imageView4);
                    iv4.setImageResource(R.drawable.x);
                    activeplayer=0;
                    emptysquares.remove(selectedSqares);
                    gameState[Integer.parseInt(selectedSqares)]=activeplayer;
                    break;
                case "4":
                    ImageView iv5=findViewById(R.id.imageView5);
                    iv5.setImageResource(R.drawable.x);
                    activeplayer=0;
                    emptysquares.remove(selectedSqares);
                    gameState[Integer.parseInt(selectedSqares)]=activeplayer;
                    break;
                case "5":
                    ImageView iv6=findViewById(R.id.imageView6);
                    iv6.setImageResource(R.drawable.x);
                    activeplayer=0;
                    emptysquares.remove(selectedSqares);
                    gameState[Integer.parseInt(selectedSqares)]=activeplayer;
                    break;
                case "6":
                    ImageView iv7=findViewById(R.id.imageView7);
                    iv7.setImageResource(R.drawable.x);
                    activeplayer=0;
                    emptysquares.remove(selectedSqares);
                    gameState[Integer.parseInt(selectedSqares)]=activeplayer;
                    break;
                case "7":
                    ImageView iv8=findViewById(R.id.imageView8);
                    iv8.setImageResource(R.drawable.x);
                    activeplayer=0;
                    emptysquares.remove(selectedSqares);
                    gameState[Integer.parseInt(selectedSqares)]=activeplayer;
                    break;
                case "8":
                    ImageView iv9=findViewById(R.id.imageView9);
                    iv9.setImageResource(R.drawable.x);
                    activeplayer=0;
                    emptysquares.remove(selectedSqares);
                    gameState[Integer.parseInt(selectedSqares)]=activeplayer;
                    break;
            }
            check();
        }
    }
    public void dropin(View view)
    {
        ImageView counter=(ImageView)view;
        int tappedcounter=Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedcounter]==2 && gameActive==true && emptysquares.contains(Integer.toString(tappedcounter)))
        {
            gameState[tappedcounter] = activeplayer;
            counter.setTranslationY(-1500);
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.o);
                activeplayer = 1;
                emptysquares.remove(Integer.toString(tappedcounter));
                counter.animate().translationYBy(1500).rotation(180).setDuration(300);
                check();
                computer();
            } /*else {
                counter.setImageResource(R.drawable.x);
                activeplayer = 0;
            }*/
        }
    }
    public void check()
    {
        for (int[] wp : winingpositions) {
            if (gameState[wp[0]] == gameState[wp[1]] && gameState[wp[1]] == gameState[wp[2]]
                    && gameState[wp[0]] != 2)
            {
                gameActive = false;
                String winner = "";
                if (activeplayer == 1) {
                    winner = "Congretulations!  You won the game";
                } else {
                    winner = "Congretulations! Computer has won the game";
                }
                Button replaybutton = (Button) findViewById(R.id.replay);
                TextView winnerannounce = (TextView) findViewById(R.id.win);

                winnerannounce.setText(winner);

                replaybutton.setVisibility(View.VISIBLE);
                winnerannounce.setVisibility(View.VISIBLE);
            }
            else
            {
                Button playagain=findViewById(R.id.replay);
                playagain.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneplayer);
        restart=(Button)findViewById(R.id.button9);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(oneplayer.this,MainActivity.class);
                startActivity(k);
            }
        });

        emptysquares.add("0");
        emptysquares.add("1");
        emptysquares.add("2");
        emptysquares.add("3");
        emptysquares.add("4");
        emptysquares.add("5");
        emptysquares.add("6");
        emptysquares.add("7");
        emptysquares.add("8");
    }


    public void playagain(View view)
    {
        Button replaybutton=(Button) findViewById(R.id.replay);
        TextView winnerannounce=(TextView)findViewById(R.id.win);
        replaybutton.setVisibility(View.INVISIBLE);
        winnerannounce.setVisibility(View.INVISIBLE);
        androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);
        //GridLayout gl =  findViewById(R.id.gridLayout);
        int j;
        for (j = 0; j < gridLayout.getChildCount(); j++)
        {
            ImageView im=(ImageView)gridLayout.getChildAt(j);
            im.setImageDrawable(null);
        }
        for(int temp=0;temp<gameState.length;temp++)
        {
            gameState[temp]=2;
        }
        activeplayer=0;
        gameActive=true;
    }
}