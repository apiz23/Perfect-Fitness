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

public class challenges extends AppCompatActivity {

    Button btnSixPack,btnArm,btnButt,btnBack;
    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.challenges);

        btnSixPack = findViewById(R.id.btn_six_pack);
        btnArm = findViewById(R.id.btn_arm);
        btnButt = findViewById(R.id.btn_butt);
        btnBack = findViewById(R.id.btnBack);

        nav = findViewById(R.id.nav);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Intent intent1,intent2;

                switch (item.getItemId()) {
                    case R.id.home:
                        intent1 = new Intent(challenges.this, MainMenu.class);
                        startActivity(intent1);
                        break;
                    case R.id.info:
                        intent2 = new Intent(challenges.this, info.class);
                        startActivity(intent2);
                        break;
                }
                return true;
            }
        });

        btnSixPack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(challenges.this,insane_six_pack.class);
                startActivity(intent);
            }
        });

        btnArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(challenges.this, arm.class);
                startActivity(intent);
            }
        });

        btnButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(challenges.this, butt.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(challenges.this,workout.class);
                startActivity(intent);
            }
        });
    }
}