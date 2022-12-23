package com.example.u6_ae1_oliverbaidezpatrick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        //Recogemos la activity que ha creado esta clase
        Intent intent = getIntent();

        //Recibimos la variable "film" que ha mandado la actividad padre
        // Casteamos el elemento serializable a Film para poder acceder a sus atributos
        // Esto tabién se conoce como des-serializar
        // Serializar es la manera que tiene Java de enviar objetos completos
        Film film = (Film) intent.getSerializableExtra("film");


        //Recojemos los elementos del layout
        TextView tvTitulo = findViewById(R.id.tvTitle);
        TextView tvDesc = findViewById(R.id.tvDescDetail);
        ImageView ivImage = findViewById(R.id.ivImageDetail);

        //Hacemos que el textview sea scrolleable
        tvDesc.setMovementMethod(new ScrollingMovementMethod());

        //Setteamos los datos de los elementos del layout pasándole los datos del objeto película
        // Que recibimos de la actividad main
        // De este modo, esta página será usada como template y rellenada con los datos
        // Del objeto película que se haya pulsado en el main
        tvTitulo.setText(film.getFullTitle());
        tvDesc.setText(film.getFullDesc());
        ivImage.setImageResource(film.getImage());

    }
}