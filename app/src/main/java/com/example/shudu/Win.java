package com.example.shudu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.time.Instant;
import java.util.HashMap;

import static java.security.AccessController.getContext;

public class Win extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }
        final PlayMusic music=new PlayMusic();
        music.Play(this,3);
        Button Bout=findViewById(R.id.b_finish);
        Bout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                music.Stop();
                finish();
            }
        });
        Button Bnext=findViewById(R.id.nextlevel);
        Bnext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                music.Stop();
                finish();
                if(Level.LevelNow<6) {
                    MainActivity.isNew=1;
                    Level.odd=!Level.odd;
                    Level.string=Level.GetStr(++Level.LevelNow);
                    Intent intent1 = new Intent(Win.this, Game.class);
                    startActivity(intent1);
                }
                else
                {
                    Toast.makeText(Win.this,"已经是最后一关",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}
