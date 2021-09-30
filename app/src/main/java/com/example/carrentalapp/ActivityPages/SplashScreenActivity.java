package com.example.carrentalapp.ActivityPages;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.carrentalapp.R;

public class SplashScreenActivity extends AppCompatActivity {


    Animation topAnim, bottomAnim;
    ImageView splashimg;
    TextView splashtext;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);





        lottie = findViewById(R.id.bt_up2);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this,
                        LoginActivity.class);

                startActivity(intent);

                finish();
            }
        }, 4000);


    }
}