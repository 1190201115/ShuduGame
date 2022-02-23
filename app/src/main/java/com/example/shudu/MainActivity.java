package com.example.shudu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int isNew=1,startBefore=0;
    public static int silent=0,backSilent=0,otherSilent=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }//remove the bangs

        Button Bstart=findViewById(R.id.b_newGame);
        Bstart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                isNew=1;
                Intent intent1=new Intent(MainActivity.this,Level.class);
                startActivity(intent1);
            }
        });

        //The button used to continue game
        Button Bcontinue=findViewById(R.id.continueGame);
        Bcontinue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                isNew=0;
               if(startBefore==1) {
                   Intent intent2 = new Intent(MainActivity.this, Game.class);
                   startActivity(intent2);
               }
               else
               {
                   Toast.makeText(MainActivity.this,"没有正在进行的关卡",Toast.LENGTH_SHORT).show();
               }
            }
        });

        //The button used to leave the game
        Button Bend=findViewById(R.id.endGame);
        Bend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

        Button Bread=findViewById(R.id.readMe);
        Bread.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3=new Intent(MainActivity.this,Read_me.class);
                startActivity(intent3);
            }
        });

        Button Bblue=findViewById(R.id.friendsMode);
        Bblue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent4=new Intent(MainActivity.this,BlueTooth.class);
                startActivity(intent4);
            }
        });

    }
}
