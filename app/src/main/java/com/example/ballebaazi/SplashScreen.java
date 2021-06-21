package com.example.ballebaazi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to hide the top title bar//
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_splash_screen);

        ImageView  backgroundImage= findViewById(R.id.SplashScreenImage);
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide);
        backgroundImage.startAnimation(slideAnimation);


        Intent end = new Intent(SplashScreen.this, MainActivity.class);
        final Handler handler = new Handler();

        handler.postDelayed(() -> {
            // Do something after 2s = 2000ms
            startActivity(end);
        }, 3000);


    }


}



