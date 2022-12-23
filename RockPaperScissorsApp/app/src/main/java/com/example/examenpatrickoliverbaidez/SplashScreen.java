package com.example.examenpatrickoliverbaidez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private final static int SPLASH_TIEMPO = 4000;
    TextView tvCountDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        tvCountDown = findViewById(R.id.tvCountDown);


        Intent intent = new Intent(this, MainActivity.class);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(intent);
            }
        }, SPLASH_TIEMPO);

        new CountDownTimer(SPLASH_TIEMPO, 1000) {

            public void onTick(long millisUntilFinished) {
                tvCountDown.setText((millisUntilFinished / 1000)+"");
            }

            public void onFinish() {
                tvCountDown.setText("Inicio");
            }
        }.start();
    }
}