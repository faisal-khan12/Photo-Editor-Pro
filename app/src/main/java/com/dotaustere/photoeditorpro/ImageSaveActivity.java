package com.dotaustere.photoeditorpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dotaustere.photoeditorpro.ui.home.HomeFragment;

public class ImageSaveActivity extends AppCompatActivity {

    private  ImageView backBn,home ,shareBtn,facebookBtn,whatsAppBtn,instaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_save);
        getSupportActionBar().hide();
        ImageView saveImg = findViewById(R.id.saveImg);
      saveImg.setImageURI(getIntent().getData());


        backBn = findViewById(R.id.backBtn);
        shareBtn = findViewById(R.id.shareBtn);
        facebookBtn = findViewById(R.id.facebookBtn);
        whatsAppBtn = findViewById(R.id.whatsappBtn);
        instaBtn = findViewById(R.id.instaBtn);
        backBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        shareBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {




                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                Uri screenshotUri = Uri.parse(getIntent().getData().toString());

                sharingIntent.setType("image/jpeg");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                startActivity(Intent.createChooser(sharingIntent, "Share image using"));

            }
        });

        facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                Uri screenshotUri = Uri.parse(getIntent().getData().toString());

                sharingIntent.setType("image/jpeg");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                sharingIntent.putExtra(Intent.EXTRA_TEXT, "http://www.facebook.com");
                startActivity(Intent.createChooser(sharingIntent, "share image to Facebook"));


            }
        });

        whatsAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                Uri screenshotUri = Uri.parse(getIntent().getData().toString());

                sharingIntent.setType("image/jpeg");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                sharingIntent.putExtra(Intent.EXTRA_TEXT, "com.whatsApp");
                startActivity(Intent.createChooser(sharingIntent, "share image to WhatsApp"));




            }
        });

        instaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                Uri screenshotUri = Uri.parse(getIntent().getData().toString());

                sharingIntent.setType("image/jpeg");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                sharingIntent.putExtra(Intent.EXTRA_TEXT, "http://www.instagram.com");
                startActivity(Intent.createChooser(sharingIntent, "share image to WhatsApp"));

            }
        });



    }

}