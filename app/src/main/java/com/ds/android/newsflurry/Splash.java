package com.ds.android.newsflurry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT =2000;
    MediaPlayer oursound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        MediaPlayer oursound=MediaPlayer.create(this,R.raw.splashsound);
        oursound.start();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent n=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(n);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        finish();


    }
}
