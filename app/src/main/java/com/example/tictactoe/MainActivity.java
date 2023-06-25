package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;

    int activeplayer = 0;
    int winpositions[][] = {{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,5,8},{2,5,6}};
    int pos[] = {2,2,2,2,2,2,2,2,2};
    public void playerTap(View view){
        if(!gameActive){
            reset(view);
        }
        ImageView img = (ImageView) view;
        int tappedimg = Integer.parseInt(img.getTag().toString());

        if(pos[tappedimg] == 2 && gameActive){
            pos[tappedimg] = activeplayer;
            img.setTranslationY(-1000f);
            if(activeplayer == 0){
                img.setImageResource(R.drawable.img_1);
                activeplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("Player O's turn:Tap to play");
            }
            else{
                img.setImageResource(R.drawable.img);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("Player X's turn:Tap to play");
            }

            img.animate().translationYBy(1000f).setDuration(300);

        }else{
            gameActive=false;
        }

        for(int[] win : winpositions){
            if(pos[win[0]] == pos[win[1]] && pos[win[1]] == pos[win[2]] && pos[win[0]] != 2){
                String winner;
                gameActive = false;
                if(pos[win[0]] == 0){
                    winner = "Congrats,X has won";
                }else{
                    winner = "Congrats,0 has won";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winner);
            }
        }


    }
    public void reset(View view){
        gameActive = true;
        activeplayer = 0;
        Arrays.fill(pos, 2);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("Player X's turn:Tap to play");



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}