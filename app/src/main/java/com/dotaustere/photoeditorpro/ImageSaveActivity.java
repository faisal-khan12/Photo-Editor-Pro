package com.dotaustere.photoeditorpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dotaustere.photoeditorpro.ui.home.HomeFragment;

public class ImageSaveActivity extends AppCompatActivity {

    private  ImageView backBn,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_save);
        getSupportActionBar().hide();
        ImageView saveImg = findViewById(R.id.saveImg);
        saveImg.setImageURI(getIntent().getData());


        backBn = findViewById(R.id.backBtn);
        backBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}