package com.example.schooll;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Set the launcher icon image and its initial visibility
        ImageView splashIcon = findViewById(R.id.splash_icon);

        // Create the fade-in animation
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Set a delay of 4 seconds before applying the animation
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Apply fade-in animation for 5 seconds
                splashIcon.startAnimation(fadeIn);

                // Transition to MainActivity after the animation
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();  // Close the SplashActivity
                    }
                }, 5000); // Wait for 5 seconds to complete animation
            }
        }, 4000); // Wait for 4 seconds before starting the animation
    }
}
