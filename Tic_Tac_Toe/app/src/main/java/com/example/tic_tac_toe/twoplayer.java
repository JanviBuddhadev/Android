package com.example.tic_tac_toe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class twoplayer extends AppCompatActivity {
    //o for o, 1 for X (here we can also use boolean but if we want to extend the game infuture
    //for more players then it will be relatively easy for us to extend)
    //initially the whole grid will be empty
    //2 represents empty

    int activeplayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winingpositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    Boolean gameActive=true;
    Button restart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twoplayer);
        restart=(Button)findViewById(R.id.button9);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(twoplayer.this,MainActivity.class);
                startActivity(k);
            }
        });
    }

    public void dropin(View view)
    {
        ImageView counter=(ImageView)view;
        counter.setTranslationY(-1500);

        int tappedcounter=Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedcounter]==2 && gameActive==true)
        {
            gameState[tappedcounter] = activeplayer;
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.o);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.x);
                activeplayer = 0;
            }

            counter.animate().translationYBy(1500).rotation(180).setDuration(300);

            for (int[] wp : winingpositions) {
                if (gameState[wp[0]] == gameState[wp[1]] && gameState[wp[1]] == gameState[wp[2]]
                        && gameState[wp[0]] != 2) {
                    gameActive=false;
                    String winner = "";
                    if (activeplayer == 1) {
                        winner = "Congretulations! Blue has won the game";
                        /*AlertDialog.Builder builder = new AlertDialog.Builder(twoplayer.this);
                        builder.setMessage(winner).setPositiveButton("Replay",new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                GridLayout gl = (GridLayout) findViewById(R.id.gridLayout);
                                int j;
                                for (j = 0; j < gl.getChildCount(); j++)
                                {
                                    ImageView im=(ImageView)gl.getChildAt(j);
                                    im.setImageDrawable(null);
                                }
                                Intent k=new Intent(twoplayer.this,MainActivity.class);
                                startActivity(k);
                            }
                        }).setNegativeButton("Restart",null);
                        AlertDialog alert=builder.create();
                        alert.show();*/
                    } else {
                        winner = "Congretulations! Red has won the game";
                    }
                    Button replaybutton=(Button) findViewById(R.id.replay);
                    TextView winnerannounce=(TextView)findViewById(R.id.win);
                    winnerannounce.setText(winner);
                    replaybutton.setVisibility(View.VISIBLE);
                    winnerannounce.setVisibility(View.VISIBLE);
                }
            }
        }
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