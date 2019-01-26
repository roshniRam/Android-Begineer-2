package com.example.dell.gif;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class SplashScreen extends AppCompatActivity {

    private GifImageView gifImageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        android.app.ActionBar actionBar= getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        gifImageView = (GifImageView) findViewById(R.id.gifImageView);
        progressBar = (ProgressBar) findViewById(R.id.progessBar);
        progressBar.setVisibility(progressBar.VISIBLE);

        //Set GifImageView resources
        try{
            InputStream inputStream = getAssets().open("giphy.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }catch (IOException e){
        }

        //wait for 2 sec and then start activity main
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashScreen.this.startActivity(new Intent(SplashScreen.this,MainActivity.class));
                SplashScreen.this.finish();
            }
        },4000);
    }
}
