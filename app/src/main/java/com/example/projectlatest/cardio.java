package com.example.projectlatest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class cardio extends AppCompatActivity {

    BottomNavigationView nav;
    Button btnJumpRope,btnJumpJack,btnBurpee,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.cardio);

        nav = findViewById(R.id.nav);
        btnJumpRope = findViewById(R.id.jumping_rope);
        btnJumpJack = findViewById(R.id.jumping_jack);
        btnBurpee = findViewById(R.id.Burpee);
        btnBack = findViewById(R.id.btnBack);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(cardio.this, MainMenu.class);
                        startActivity(intent);
                }
                return true;
            }
        });

        btnJumpRope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardio.this, jump_rope.class);
                startActivity(intent);
            }
        });

        btnJumpJack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardio.this, jumping_jack.class);
                startActivity(intent);
            }
        });

        btnBurpee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardio.this, burpee.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardio.this,workout.class);
                startActivity(intent);
            }
        });
    }
}