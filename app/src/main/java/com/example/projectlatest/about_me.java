package com.example.projectlatest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class about_me extends AppCompatActivity {

    private TextView age_view,weight_view,height_view;
    private final int GALLERY_REQ_CODE = 1000;
    ImageView imgGallery;
    Button btnInc_age,btnDec_age,btnInc_height,btnDec_height,btnInc_weight,btnDec_weight,btnDone;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == GALLERY_REQ_CODE){
                imgGallery.setImageURI(data.getData());
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.about_me);

        btnDone = findViewById(R.id.doneButton);

        age_view = findViewById(R.id.age_view);
        btnInc_age = findViewById(R.id.addAge);
        btnDec_age = findViewById(R.id.removeAge);

        height_view = findViewById(R.id.height_view);
        btnInc_height = findViewById(R.id.addHeight);
        btnDec_height = findViewById(R.id.removeHeight);

        weight_view = findViewById(R.id.weight_view);
        btnInc_weight = findViewById(R.id.addWeight);
        btnDec_weight = findViewById(R.id.removeWeight);

        imgGallery = findViewById(R.id.imgGallery);
        Button btnGallery = findViewById(R.id.btnOpenGallery);


        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent iGallery  = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery,GALLERY_REQ_CODE);

            }
        });



        btnInc_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValueAge = age_view.getText().toString();
                int value = Integer.parseInt(currentValueAge);
                value++;
                age_view.setText(String.valueOf(value));
            }
        });

        btnDec_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValueAge = age_view.getText().toString();
                int value = Integer.parseInt(currentValueAge);
                value--;
                age_view.setText(String.valueOf(value));
            }
        });

        btnInc_height.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValueHeight = height_view.getText().toString();
                int value = Integer.parseInt(currentValueHeight);
                value++;
                height_view.setText(String.valueOf(value));
            }
        });

        btnDec_height.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValueHeight = height_view.getText().toString();
                int value = Integer.parseInt(currentValueHeight);
                value--;
                height_view.setText(String.valueOf(value));
            }
        });

        btnInc_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValueWeight = weight_view.getText().toString();
                int value = Integer.parseInt(currentValueWeight);
                value++;
                weight_view.setText(String.valueOf(value));
            }
        });

        btnDec_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValueWeight = weight_view.getText().toString();
                int value = Integer.parseInt(currentValueWeight);
                value--;
                weight_view.setText(String.valueOf(value));
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(about_me.this,MainMenu.class);
                startActivity(intent);
            }
        });

    }
}