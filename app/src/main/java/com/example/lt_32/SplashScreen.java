package com.example.lt_32;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent myintent =  new Intent(SplashScreen.this,
                MainActivity.class);
                startActivity(myintent);
                finish();
            }

        },  5000);

    }}
