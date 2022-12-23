package com.example.u4_aev1_miniaplicacion_oliverbaidezpatrick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    //Constante que define el tiempo que tarda la SplashScreen
    //En dar paso a la siguiente activity
    private final int SPLASH_TIEMPO = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Recogemos el elemento tvContador
        TextView tvContador = findViewById(R.id.tvContador);

        //Recogemos el intent MainActivity
        Intent intent = new Intent(this, MainActivity.class);

        //Esta función nos permite pasar a un nuevo intent tras
        //Un tiempo determinado -SPLASH_TIEMPO-
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(intent);
            }
        }, SPLASH_TIEMPO);

        // Esta función es un contador de tiempo que, además nos permite definir
        // cambiar el contenido del tvContador cada tick de reloj
        new CountDownTimer(SPLASH_TIEMPO, 1000) {

            public void onTick(long millisUntilFinished) {
                tvContador.setText(millisUntilFinished / 1000 + "");
            }

            //Al finalizar el tiempo atrás, tvContador no tiene texto
            public void onFinish() {
                tvContador.setText("");
            }
        }.start();




    }
}