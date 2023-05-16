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

public class workout extends AppCompatActivity {

    Button btnStrength,btnCardio,btnBack;
    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.workout);

        btnStrength = findViewById(R.id.btnStrength);
        btnCardio = findViewById(R.id.btnCardio);
        btnBack = findViewById(R.id.btnBack);

        nav = findViewById(R.id.nav);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Intent intent1,intent2;

                switch (item.getItemId()) {
                    case R.id.home:
                        intent1 = new Intent(workout.this, MainMenu.class);
                        startActivity(intent1);
                        break;

                    case R.id.info:
                        intent2 = new Intent(workout.this,info.class);
                        startActivity(intent2);
                        break;
                }
                return true;
            }
        });

        btnStrength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workout.this, challenges.class);
                startActivity(intent);
            }
        });

        btnCardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workout.this,cardio.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workout.this,MainMenu.class);
                startActivity(intent);
            }
        });
    }
}