package com.example.shudu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import static com.example.shudu.DrawBackGround.findError;
import static com.example.shudu.DrawBackGround.game;

public class Game extends AppCompatActivity {
public static Context gameContext;
final  PlayMusic bgmusic = new PlayMusic();
public static boolean bgm_is_on=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameContext=getApplicationContext();
        if(!bgm_is_on&&MainActivity.backSilent==0) {
            bgmusic.Play(Game.this, 0);
            bgm_is_on=true;
        }
        if(bgm_is_on&&MainActivity.backSilent==1)
        {
            bgmusic.Stop();
            bgm_is_on=false;
        }
        final View view=findViewById(R.id.BackgroundView);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }
        Button BError=findViewById(R.id.b_FindError);
        BError.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!game.winGame())
                {
                    DrawBackGround.errorX = game.ri % 9;
                    DrawBackGround.errorY = game.ri/9;
                    findError=true;
                    view.invalidate();
                }
            }
        });
        Button Bcheck=findViewById(R.id.b_Check);
        Bcheck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(game.winGame())
                {
                    if(bgm_is_on) {
                        bgmusic.Stop();
                        bgm_is_on = false;
                    }
                   finish();
                    Intent Iwin=new Intent(Game.this,Win.class);
                    startActivity(Iwin);
                }
                else
                {
                    final PlayMusic error_music=new PlayMusic();
                    error_music.Play(Game.this,2);
                    Toast.makeText(Game.this,"存在错误",Toast.LENGTH_SHORT).show();
                }

                }
        });
        Button Bclear=findViewById(R.id.b_Clear);
        Bclear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                game.sudoAll=game.fillPuzzle(game.str);
                for (int i = 0; i < 81; ++i) {
                    game.sudoFill[i] = 0;
                }
                view.invalidate();
            }
        });
        Button Bquit=findViewById(R.id.b_Quit);
        Bquit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(bgm_is_on) {
                    bgmusic.Stop();
                    bgm_is_on = false;
                }
                finish();
            }
        });
    }
    @Override
    public void onBackPressed()
 {
     if(bgm_is_on) {
         bgmusic.Stop();
         bgm_is_on = false;
     }
     finish();
 }
}
