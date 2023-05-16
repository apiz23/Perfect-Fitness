package com.example.projectlatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.VideoView;

public class glute_bridge extends AppCompatActivity {

    VideoView videoView;
    Button btnStart,btnStop,btnNext;
    Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.glute_bridge);

        videoView = findViewById(R.id.glute_bridge_video);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnNext = findViewById(R.id.nextBtn);
        timer = findViewById(R.id.timer);

        videoView.setOnPreparedListener(mediaPlayer -> mediaPlayer.setLooping(true));

        btnStart.animate().alpha(1).translationY(0).setDuration(300).start();
        btnStop.animate().alpha(0).setDuration(300).start();
        btnNext.animate().alpha(0).setDuration(300).start();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.glute_brigde;
                Uri uri = Uri.parse(videoPath);
                videoView.setVideoURI(uri);
                videoView.start();
                onResume();
                btnStop.animate().alpha(1).translationY(0).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPause();
                btnStart.animate().alpha(1).translationY(0).setDuration(300).start();
                btnStop.animate().alpha(0).setDuration(300).start();
                btnNext.animate().alpha(1).translationY(0).setDuration(300).start();
                timer.stop();
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
                Intent intent = new Intent(glute_bridge.this,wall_sit.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onResume() {
        videoView.resume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        videoView.suspend();
        super.onPause();
    }
}