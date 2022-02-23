package com.example.shudu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class Level extends AppCompatActivity {
    static String string;
    static int LevelNow;
    static boolean odd=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }//remove the bangs
        Button Blv1=findViewById(R.id.level1);
        Blv1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                string=GetStr(1);
                LevelNow=1;
                finish();
                Intent intent1=new Intent(Level.this,Game.class);
                startActivity(intent1);
                Toast.makeText(Level.this,"新手入门",Toast.LENGTH_SHORT).show();
            }
        });

        Button Blv2=findViewById(R.id.level2);
        Blv2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                string=GetStr(2);
                LevelNow=2;
                finish();
                Intent intent2=new Intent(Level.this,Game.class);
                startActivity(intent2);
                Toast.makeText(Level.this,"初出茅庐",Toast.LENGTH_SHORT).show();
            }
        });

        Button Blv3=findViewById(R.id.level3);
        Blv3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                string=GetStr(3);
                LevelNow=3;
                finish();
                Intent intent3=new Intent(Level.this,Game.class);
                startActivity(intent3);
                Toast.makeText(Level.this,"崭露头角",Toast.LENGTH_SHORT).show();
            }
        });

        Button Blv4=findViewById(R.id.level4);
        Blv4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                string=GetStr(4);
                LevelNow=4;
                finish();
                Intent intent4=new Intent(Level.this,Game.class);
                startActivity(intent4);
                Toast.makeText(Level.this,"登堂入室",Toast.LENGTH_SHORT).show();
            }
        });

        Button Blv5=findViewById(R.id.level5);
        Blv5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                string=GetStr(5);
                LevelNow=5;
                finish();
                Intent intent5=new Intent(Level.this,Game.class);
                startActivity(intent5);
                Toast.makeText(Level.this,"游刃有余",Toast.LENGTH_SHORT).show();
            }
        });

        Button Blv6=findViewById(R.id.level6);
        Blv6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                string=GetStr(6);
                LevelNow=6;
                finish();
                Intent intent6=new Intent(Level.this,Game.class);
                startActivity(intent6);
                Toast.makeText(Level.this,"大显身手（最终关）",Toast.LENGTH_SHORT).show();
            }
        });

        Button Blv7=findViewById(R.id.level7);
        Blv7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Level.this,"感谢使用^-^",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    public static String GetStr(int i) {
        MainActivity.startBefore = 1;
        Random rand = new Random();
        String str1,str2,str3,str4,str5,str6,str7,str8,str9;
        if(odd) {
            str1 = "679453182" +
                    "451298376" +
                    "328617594" +
                    "532184769" +
                    "867329451" +
                    "914765823" +
                    "293871645" +
                    "185946237" +
                    "746532918";

             str2 = "483271695" +
                    "976485321" +
                    "521396478" +
                    "294658137" +
                    "138927564" +
                    "657134982" +
                    "842563719" +
                    "319742856" +
                    "765819243";

             str3 = "258649371" +
                    "439517682" +
                    "167238549" +
                    "921854763" +
                    "346721895" +
                    "785396124" +
                    "812475936" +
                    "694183257" +
                    "573962418";

             str4 = "352674918" +
                    "487319652" +
                    "169825473" +
                    "641982735" +
                    "923157864" +
                    "578463291" +
                    "794538126" +
                    "215746389" +
                    "836291547";

            str5 = "658739124" +
                    "794128653" +
                    "123465879" +
                    "581397246" +
                    "946852731" +
                    "372614598" +
                    "839571462" +
                    "465283917" +
                    "217946385";

             str6 = "534678912" +
                    "672195348" +
                    "198342567" +
                    "859761423" +
                    "426853791" +
                    "713924856" +
                    "961537284" +
                    "287419635" +
                    "345286179";

            str7 = "469731285" +
                    "875296431" +
                    "123485769" +
                    "536149872" +
                    "281573946" +
                    "794862513" +
                    "957614328" +
                    "318927654" +
                    "642358197";

             str8 = "982547361" +
                    "465183927" +
                    "731926845" +
                    "326815479" +
                    "879364512" +
                    "514279683" +
                    "157498236" +
                    "243651798" +
                    "698732154";
            str9 = "682715943" +
                    "539426817" +
                    "417893625" +
                    "823159476" +
                    "196374258" +
                    "745268391" +
                    "258937164" +
                    "371642589" +
                    "964581732";
        }
        else
        {
             str1 = "532184769" +
                     "867329451" +
                     "914765823" +
                     "679453182" +
                    "451298376" +
                    "328617594" +
                    "293871645" +
                    "185946237" +
                    "746532918";

             str2 = "294658137" +
                     "138927564" +
                     "657134982" +
                     "483271695" +
                    "976485321" +
                    "521396478" +
                    "842563719" +
                    "319742856" +
                    "765819243";

             str3 = "921854763" +
                     "346721895" +
                     "785396124" +
                     "258649371" +
                    "439517682" +
                    "167238549" +
                    "812475936" +
                    "694183257" +
                    "573962418";

             str4 = "641982735" +
                     "923157864" +
                     "578463291" +
                     "352674918" +
                    "487319652" +
                    "169825473" +
                    "794538126" +
                    "215746389" +
                    "836291547";

            str5 = "581397246" +
                    "946852731" +
                    "372614598" +
                    "658739124" +
                    "794128653" +
                    "123465879" +
                    "839571462" +
                    "465283917" +
                    "217946385";

             str6 = "859761423" +
                     "426853791" +
                     "713924856" +
                     "534678912" +
                    "672195348" +
                    "198342567" +
                    "961537284" +
                    "287419635" +
                    "345286179";

             str7 = "536149872" +
                     "281573946" +
                     "794862513" +
                     "469731285" +
                    "875296431" +
                    "123485769" +
                    "957614328" +
                    "318927654" +
                    "642358197";

            str8 = "326815479" +
                    "879364512" +
                    "514279683" +
                    "982547361" +
                    "465183927" +
                    "731926845" +
                    "157498236" +
                    "243651798" +
                    "698732154";
             str9 = "823159476" +
                     "196374258" +
                     "745268391" +
                     "682715943" +
                    "539426817" +
                    "417893625" +
                    "258937164" +
                    "371642589" +
                    "964581732";
        }
        switch (i) {
            case 1:
                Functions.blank_num = 25;
                break;
            case 2:
                Functions.blank_num = 35;
                break;
            case 3:
                Functions.blank_num = 41;
                break;
            case 4:
                Functions.blank_num = 46;
                break;
            case 5:
                Functions.blank_num = 51;
                break;
            case 6:
                Functions.blank_num = 55;
                break;
            default:
                return "";
        }

        switch (rand.nextInt(10)) {
            case 0:
                return str1;
            case 1:
                return str2;

            case 2:
                return str3;

            case 3:
                return str4;

            case 4:
                return str5;

            case 5:
                return str6;

            case 6:
                return str7;

            case 7:
                return str8;
            case 8:
                return str9;

            default:
                return str1;
        }
    }
}
