package com.example.shudu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Read_me extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_me);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }//remove the bangs
        Switch s_music=findViewById(R.id.s_music);
        if(MainActivity.silent==0)
        s_music.setChecked(true);
        else
            s_music.setChecked(false);
        s_music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!buttonView.isPressed())return;
                if (isChecked){
                    MainActivity.silent=0;
                }else {
                   MainActivity.silent=1;
                }
            }
        });
        Switch s_other_music=findViewById(R.id.s_otherMusic);
        if(MainActivity.otherSilent==0)
            s_other_music.setChecked(true);
        else
            s_other_music.setChecked(false);
        s_other_music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!buttonView.isPressed())return;
                if (isChecked){
                    MainActivity.otherSilent=0;
                }else {
                    MainActivity.otherSilent=1;
                }
            }
        });
        Switch s_backMusic=findViewById(R.id.s_backMusic);
        if(MainActivity.backSilent==0)
            s_backMusic.setChecked(true);
        else
            s_backMusic.setChecked(false);
        s_backMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!buttonView.isPressed()) return;
                if (isChecked){
                    MainActivity.backSilent=0;
                }else {
                    MainActivity.backSilent=1;
                }
            }
        });

        Button Bback=findViewById(R.id.b_back);
        Bback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
               // Intent intent=new Intent(Read_me.this,MainActivity.class);
                //startActivity(intent);
            }
        });
    }


}
