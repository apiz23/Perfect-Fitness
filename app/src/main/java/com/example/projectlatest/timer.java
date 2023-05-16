package com.example.projectlatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class timer extends AppCompatActivity {

    Button btnStart,btnStop,btnBack,btnNext;
    ImageView icanchor;
    Animation roundingAlone;
    Chronometer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.timer);

        btnBack = findViewById(R.id.btnBack);
        btnStart =findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnNext = findViewById(R.id.nextBtn);
        icanchor = findViewById(R.id.IcAnchor);
        timer = findViewById(R.id.timer);

        btnStop.setAlpha(0);
        roundingAlone = AnimationUtils.loadAnimation(this,R.anim.rounding);

        btnStart.animate().alpha(1).translationY(0).setDuration(300).start();
        btnStop.animate().alpha(0).setDuration(300).start();
        btnNext.animate().alpha(0).setDuration(300).start();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icanchor.startAnimation(roundingAlone);
                btnStop.animate().alpha(1).translationY(0).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();

                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icanchor.clearAnimation();
                btnStart.animate().alpha(1).translationY(0).setDuration(300).start();
                btnStop.animate().alpha(0).setDuration(300).start();
                btnNext.animate().alpha(1).translationY(0).setDuration(300).start();

                timer.stop();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(timer.this,MainMenu.class);
                startActivity(intent);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPause();
                btnStart.animate().alpha(1).translationY(0).setDuration(300).start();
                btnStop.animate().alpha(0).setDuration(300).start();

                timer.stop();
                timer.setBase(SystemClock.elapsedRealtime());
                Intent intent = new Intent(timer.this,MainMenu.class);
                startActivity(intent);
            }
        });
    }
}