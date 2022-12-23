package com.example.u6_ae1_oliverbaidezpatrick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Film> films;
    RecyclerView recyclerFilms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent para cambiar la activity cuando pulsamos en un elemento
        //Nos lleva a una activity con toda la información de la película
        //Esta nueva activity se genera a partir de los datos de la peli que le pasamos
        Intent intent = new Intent(this, DetailScreen.class);

        //Otras variables que vamos a necesitar en la ejecución del programa
        films = new ArrayList<>(); //Array de pelis para rellenar el recycler view

        //Variables para capturar el recycler del layout
        recyclerFilms = findViewById(R.id.rRecycler);
        //Le asignamos un layout linear
        recyclerFilms.setLayoutManager(new LinearLayoutManager(this));

        //Función para insertar las películas en el array de películas
        fillFilms();

        //Creamos un adaptador propio (clase AdapterFilms) al que le pasamos el
        //Array de películas que hemos creado
        AdapterFilms adapter = new AdapterFilms(films);

        //Seteamos el adaptador en el recycler view para que introduzca los objetos en el recycler
        recyclerFilms.setAdapter(adapter);


        // Añadimos un onclicklistener a cada elemento del adaptador
        // Este evento OnClick se ha creado dentro de la clase propia AdapterFilms
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //metodo on click del adaptador
                //Lanzamos un toast de corta duración que indica el título de la peli seleccionada
                Toast.makeText(getApplicationContext(), films.get(recyclerFilms.getChildAdapterPosition(view)).getTitle(), Toast.LENGTH_SHORT).show();

                //Le pasamos un elemento serializable (film) como variable al intent que vamos a lanzar
                // Este elemento es el mismo en el que hemos pulsado
                // Para ello, debemos haber implementado la interfaz Serializable a la clase Film
                intent.putExtra("film", (Serializable) films.get(recyclerFilms.getChildAdapterPosition(view)));

                //iniciamos la nueva actividad
                startActivity(intent);
            }
        });


    }



    //Función que genera las pelis y las inserta en el arraylist de pelis
    private void fillFilms() {

        //Usamos el constructor de películas, le pasamos los parámetros:
        // Nombre de la peli, guardado en un xml
        // Desciopción de la peli, guardada en otro xml
        // imagen, contenida en la carpeta drawable
        // Año (esto está hardcodeado, pero se podría hacer por array de xml)
        films.add(new Film(getResources().getStringArray(R.array.pelis)[0],
                getResources().getStringArray(R.array.descript)[0],
                  R.drawable.bros, 2022));

        films.add(new Film(getResources().getStringArray(R.array.pelis)[1],
                getResources().getStringArray(R.array.descript)[1],
                R.drawable.dwd, 2022));


        films.add(new Film(getResources().getStringArray(R.array.pelis)[2],
                getResources().getStringArray(R.array.descript)[2],
                R.drawable.ba, 2022));

        films.add(new Film(getResources().getStringArray(R.array.pelis)[3],
                getResources().getStringArray(R.array.descript)[3],
                R.drawable.dotn, 2022));

        films.add(new Film(getResources().getStringArray(R.array.pelis)[4],
                getResources().getStringArray(R.array.descript)[4],
                R.drawable.bp, 2022));

        films.add(new Film(getResources().getStringArray(R.array.pelis)[5],
                getResources().getStringArray(R.array.descript)[5],
                R.drawable.pitch, 2012));

        films.add(new Film(getResources().getStringArray(R.array.pelis)[6],
                getResources().getStringArray(R.array.descript)[6],
                R.drawable.nope, 2022));

        films.add(new Film(getResources().getStringArray(R.array.pelis)[7],
                getResources().getStringArray(R.array.descript)[7],
                R.drawable.horror, 1975));

        films.add(new Film(getResources().getStringArray(R.array.pelis)[8],
                getResources().getStringArray(R.array.descript)[8],
                R.drawable.every, 2022));

        films.add(new Film(getResources().getStringArray(R.array.pelis)[9],
                getResources().getStringArray(R.array.descript)[9],
                R.drawable.parasite, 2019));

    }
}