package com.example.examenpatrickoliverbaidez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnPiedra, btnPapel, btnTijera;
    TextView tvEleccion, tvMaquina, tvGanadasMaquina, tvGanadasPersona;
    private String mensajeEleccion = "Has elegido ", mensajeMaquina = "La máquina ha elegido ";
    private String[] maquina = {"Piedra", "Papel", "Tijera"};
    private int eleccionMaq, ganaMaq, ganaPers, evaluacionGana;


    //Lanzar toast
    public void lanzarToast(int valor){


        Context context = getApplicationContext();
        CharSequence text = "";
        int duration = Toast.LENGTH_SHORT;

        switch (valor){
            case 0:
                text = "EMPATE"; break;

            case 1:
                text = "GANAS"; break;

            case 2:
                text = "PIERDES"; break;



        }

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    //  Método para devolver un valor aleatorio escojido por la máquina
    public String eleccionMaquina(){

        eleccionMaq =  (int) (Math.random() * 3); //Generamos un número aleatorio entre el 0 y el 2
        return maquina[eleccionMaq]; //El número generado se usa como índice del Array maquina y devuelve un valor
    }

    //Método para evaluar quien gana= 0 es empate, 1 es persona, 2 es máquina. -1 es un error.
    public int evalGanador(String Pers, String Mac){

        int ganador = -1;

        if(Pers.equals(Mac)){//Casos de empate
            ganador = 0;
            return ganador;

        }else{
            switch (Pers){
                case "Piedra":
                    if (Mac.equals("Tijera")){
                        ganador = 1;
                        return ganador;

                    } //piedra gana a tijera. Jugador gana. Devolvemos 1
                    ganador = 2;
                    return ganador; // piedra pierde contra papel, gana máquina, devuelve 2.



                case "Papel":
                    if (Mac.equals("Piedra")){
                        ganador = 1;
                        return ganador;
                    } //papel gana a piedra. Jugador gana. Devolvemos 1
                    ganador = 2;
                    return ganador; // papel pierde contra tijera, gana máquina, devuelve 2.

                case "Tijera":
                    if (Mac.equals("Papel")){
                        ganador = 1;
                        return ganador;

                    }  //Tijera gana a Papel. Jugador gana. Devolvemos 1
                    ganador = 2;
                    return ganador; // Tijera pierde contra Piedra, gana máquina, devuelve 2.


            }



        }



        return -1;

    }

    //Método para actualizar el contador

    public void contador(int gana){

        switch (gana){
            case 0:
                break;

            case 1:
                ganaPers++; break;
            case 2:
                ganaMaq++; break;

        }



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPiedra = findViewById(R.id.btnPiedra);
        btnPapel = findViewById(R.id.btnPapel);
        btnTijera = findViewById(R.id.btnTijera);

        tvEleccion = findViewById(R.id.tvEleccion);
        tvMaquina = findViewById(R.id.tvMaquina);
        tvGanadasMaquina = findViewById(R.id.tvGanadasMaquina);
        tvGanadasPersona = findViewById(R.id.tvGanadasPersona);

        Intent intentGana = new Intent(this, YouWin.class);
        Intent intentLose = new Intent(this, YouLose.class);


        btnPiedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvEleccion.setText(mensajeEleccion + btnPiedra.getText().toString());
                tvMaquina.setText(mensajeMaquina + eleccionMaquina());

                evaluacionGana = evalGanador(btnPiedra.getText().toString(), eleccionMaquina());

                contador(evaluacionGana);

                lanzarToast(evaluacionGana);

                //Actualizamos el contador
                tvGanadasMaquina.setText(ganaMaq+"");
                tvGanadasPersona.setText(ganaPers+"");

                if (ganaMaq == 3){
                    startActivity(intentLose);
                }

                if(ganaPers == 3){
                    startActivity(intentGana);
                }


            }
        });

        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvEleccion.setText(mensajeEleccion + btnPapel.getText().toString());
                tvMaquina.setText(mensajeMaquina + eleccionMaquina());

                evaluacionGana = evalGanador(btnPapel.getText().toString(), eleccionMaquina());
                contador(evaluacionGana);

                lanzarToast(evaluacionGana);

                //Actualizamos el contador
                tvGanadasMaquina.setText(ganaMaq+"");
                tvGanadasPersona.setText(ganaPers+"");

                if (ganaMaq == 3){
                    startActivity(intentLose);
                }

                if(ganaPers == 3){
                    startActivity(intentGana);
                }



            }
        });

        btnTijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvEleccion.setText(mensajeEleccion + btnTijera.getText().toString());
                tvMaquina.setText(mensajeMaquina + eleccionMaquina());

                evaluacionGana = evalGanador(btnTijera.getText().toString(), eleccionMaquina());
                contador(evaluacionGana);

                lanzarToast(evaluacionGana);

                //Actualizamos el contador
                tvGanadasMaquina.setText(ganaMaq+"");
                tvGanadasPersona.setText(ganaPers+"");

                if (ganaMaq == 3){
                    startActivity(intentLose);
                }

                if(ganaPers == 3){
                    startActivity(intentGana);
                }
            }
        });




    }
}