package com.example.shudu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class PlayMusic {
    private MediaPlayer music;

    public void Play(Context context,int MusicId) {
            switch (MusicId) {
                case 0:
                    if(MainActivity.backSilent==0) {
                        music = MediaPlayer.create(context, R.raw.bgm_anj);
                        music.setLooping(true);
                        music.start();
                    }
                    break;
                    case 1:
                        if(MainActivity.silent==0) {
                            music = MediaPlayer.create(context, R.raw.click);
                            music.start();
                        }
                        break;
                case 2:
                    if(MainActivity.otherSilent==0) {
                        music = MediaPlayer.create(context, R.raw.error);
                        music.start();
                    }
                    break;
                case 3:
                    if(MainActivity.otherSilent==0) {
                        music = MediaPlayer.create(context, R.raw.win);
                        music.start();
                    }
                    break;
            }
    }
    public void Stop()
    {
        if(music!=null&&music.isPlaying())
            music.stop();
    }
    public void Pause()
    {
        if(music!=null&&music.isPlaying())
        music.pause();
    }
}