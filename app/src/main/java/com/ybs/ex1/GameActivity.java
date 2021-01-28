package com.ybs.ex1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.ybs.ex1.R.raw.clap;
import static java.lang.String.*;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txvXScore;
    private TextView txvDraws;
    private TextView txvOScore;
    private TextView txvTurn;
    private String numWinX,numWinO,numDraws;
    private Button btn00;
    private Button btn01;
    private Button btn02;
    private Button btn10;
    private Button btn11;
    private Button btn12;
    private Button btn20;
    private Button btn21;
    private Button btn22;
    private MediaPlayer mp;
    private Button btnPlayAgain;
    private GameBoard gameBoard;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mp = MediaPlayer.create(this,R.raw.clap1);
        setContentView(R.layout.activity_game);
        txvXScore=findViewById(R.id.txvXScoreID);
        txvDraws=findViewById(R.id.txvDrawsID);
        txvOScore=findViewById(R.id.txvOScoreID);
        txvTurn=findViewById(R.id.txvTurnID);

        btn00=findViewById(R.id.btn00ID);
        btn01=findViewById(R.id.btn01ID);
        btn02=findViewById(R.id.btn02ID);
        btn10=findViewById(R.id.btn10ID);
        btn11=findViewById(R.id.btn11ID);
        btn12=findViewById(R.id.btn12ID);
        btn20=findViewById(R.id.btn20ID);
        btn21=findViewById(R.id.btn21ID);
        btn22=findViewById(R.id.btn22ID);
        btnPlayAgain=findViewById(R.id.btnPlayAgainID);
        btn00.setOnClickListener(this);
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
        btnPlayAgain.setOnClickListener(this);
        txvTurn.setText("X Turn");
        gameBoard=new GameBoard();
        SharedPreferences sp=getSharedPreferences("file", Context.MODE_PRIVATE);
        numWinX = sp.getString("winX","0");
        numWinO = sp.getString("winO","0");
        numDraws = sp.getString("draws","0");
        txvXScore.setText(numWinX);
        txvOScore.setText(numWinO);
        txvDraws.setText(numDraws);
        btnPlayAgain.setEnabled(false);
    }

    @Override
    public void onClick(View view) {
        String player;
        int numWin;
        btnPlayAgain.setEnabled(false);
        String s;
        switch(view.getId()){
            case R.id.btn00ID:
                btn00.setText(valueOf(gameBoard.setBoard(0,0)));
                btn00.setEnabled(false);
                break;
            case R.id.btn01ID:
                btn01.setText(valueOf(gameBoard.setBoard(0,1)));
                btn01.setEnabled(false);
                break;
            case R.id.btn02ID:
                btn02.setText(valueOf(gameBoard.setBoard(0,2)));
                btn02.setEnabled(false);
                break;
            case R.id.btn10ID:
                btn10.setText(valueOf(gameBoard.setBoard(1,0)));
                btn10.setEnabled(false);
                break;
            case R.id.btn11ID:
                btn11.setText(valueOf(gameBoard.setBoard(1,1)));
                btn11.setEnabled(false);
                break;
            case R.id.btn12ID:
                btn12.setText(valueOf(gameBoard.setBoard(1,2)));
                btn12.setEnabled(false);
                break;
            case R.id.btn20ID:
                btn20.setText(valueOf(gameBoard.setBoard(2,0)));
                btn20.setEnabled(false);
                break;
            case R.id.btn21ID:
                btn21.setText(valueOf(gameBoard.setBoard(2,1)));
                btn21.setEnabled(false);
                break;
            case R.id.btn22ID:
                btn22.setText(valueOf(gameBoard.setBoard(2,2)));
                btn22.setEnabled(false);
                break;
            case R.id.btnPlayAgainID:
                txvTurn.setText("X Turn");
                mp.stop();
                gameBoard.newGame();
                btn00.setText(" ");
                btn00.setEnabled(true);
                btn01.setText(" ");
                btn01.setEnabled(true);
                btn02.setText(" ");
                btn02.setEnabled(true);
                btn10.setText(" ");
                btn10.setEnabled(true);
                btn11.setText(" ");
                btn11.setEnabled(true);
                btn12.setText(" ");
                btn12.setEnabled(true);
                btn20.setText(" ");
                btn20.setEnabled(true);
                btn21.setText(" ");
                btn21.setEnabled(true);
                btn22.setText(" ");
                btn22.setEnabled(true);
                btn00.setTextColor(Color.BLACK);
                btn01.setTextColor(Color.BLACK);
                btn02.setTextColor(Color.BLACK);
                btn10.setTextColor(Color.BLACK);
                btn11.setTextColor(Color.BLACK);
                btn12.setTextColor(Color.BLACK);
                btn20.setTextColor(Color.BLACK);
                btn21.setTextColor(Color.BLACK);
                btn22.setTextColor(Color.BLACK);
                break;
        }

        if(view.getId()!=R.id.btnPlayAgainID) {
            player = gameBoard.end();
            if (player.charAt(0) == 'X') {
                s = txvXScore.getText().toString();
                numWin = 1 + Integer.parseInt(s);
                txvXScore.setText(String.valueOf(numWin));
                txvTurn.setText("X Won!");
            } else if (player.charAt(0) == 'O') {
                s = txvOScore.getText().toString();
                numWin = 1 + Integer.parseInt(s);
                txvOScore.setText(String.valueOf(numWin));
                txvTurn.setText("O Won!");
            } else if (player.charAt(0) == 'D') {
                s = txvDraws.getText().toString();
                numWin = 1 + Integer.parseInt(s);
                txvDraws.setText(String.valueOf(numWin));
                txvTurn.setText("Draw - No Winner!");
            } else if (txvTurn.getText().toString() == "X Turn") {
                txvTurn.setText("O Turn");
            } else {
                txvTurn.setText("X Turn");
            }
            if (player.charAt(0) != ' ') {//in case that the game is over D or O or X
                Toast.makeText(GameActivity.this, "Game over", Toast.LENGTH_LONG).show();
                btnPlayAgain.setEnabled(true);
                if (player.charAt(0) == 'O' || player.charAt(0) == 'X') {//there is a winner
                    mp = MediaPlayer.create(this, R.raw.clap1);
                    mp.start();
                    colorButtons(player);
                    disableButtons();
                }
            }
        }
    }
    //when there is win disble all the button
    public void disableButtons(){
        btn00.setEnabled(false);
        btn01.setEnabled(false);
        btn02.setEnabled(false);
        btn10.setEnabled(false);
        btn11.setEnabled(false);
        btn12.setEnabled(false);
        btn20.setEnabled(false);
        btn21.setEnabled(false);
        btn22.setEnabled(false);
    }
    //color the win-the keyboard is:  1 2 3
    // i send when there is a winner  4 5 6
    // the indexes and color them     7 8 9
    public void colorButtons(String player){
        switch (player.charAt(1)){
            case '1':btn00.setTextColor(Color.BLUE);break;
            case '2':btn01.setTextColor(Color.BLUE);break;
            case '3':btn02.setTextColor(Color.BLUE);break;
            case '4':btn10.setTextColor(Color.BLUE);break;
            case '5':btn11.setTextColor(Color.BLUE);break;
            case '6':btn12.setTextColor(Color.BLUE);break;
            case '7':btn20.setTextColor(Color.BLUE);break;
            case '8':btn21.setTextColor(Color.BLUE);break;
            case '9':btn22.setTextColor(Color.BLUE);break;
        }
        switch (player.charAt(2)){
            case '1':btn00.setTextColor(Color.BLUE);break;
            case '2':btn01.setTextColor(Color.BLUE);break;
            case '3':btn02.setTextColor(Color.BLUE);break;
            case '4':btn10.setTextColor(Color.BLUE);break;
            case '5':btn11.setTextColor(Color.BLUE);break;
            case '6':btn12.setTextColor(Color.BLUE);break;
            case '7':btn20.setTextColor(Color.BLUE);break;
            case '8':btn21.setTextColor(Color.BLUE);break;
            case '9':btn22.setTextColor(Color.BLUE);break;
        }
        switch (player.charAt(3)){
            case '1':btn00.setTextColor(Color.BLUE);break;
            case '2':btn01.setTextColor(Color.BLUE);break;
            case '3':btn02.setTextColor(Color.BLUE);break;
            case '4':btn10.setTextColor(Color.BLUE);break;
            case '5':btn11.setTextColor(Color.BLUE);break;
            case '6':btn12.setTextColor(Color.BLUE);break;
            case '7':btn20.setTextColor(Color.BLUE);break;
            case '8':btn21.setTextColor(Color.BLUE);break;
            case '9':btn22.setTextColor(Color.BLUE);break;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("debug", "MainActivity onStop()");
        SharedPreferences sp = getSharedPreferences("file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        numWinX=txvXScore.getText().toString();
        numWinO=txvOScore.getText().toString();
        numDraws=txvDraws.getText().toString();
        editor.putString("winX", numWinX);
        editor.putString("winO",numWinO);
        editor.putString("draws",numDraws);
        editor.commit();
        String s=sp.getString("winX", null);
        txvXScore.setText(s);
        mp.stop();



    }

}