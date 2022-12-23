package com.example.u5_ap1_form_oliverbaidezpatrick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Validar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        TextView tvdatos = findViewById(R.id.tvDat);
        Button btnGuardar = findViewById(R.id.btnGuardar);
        Intent intent = getIntent();

        Bundle extras = intent.getExtras();
        String data = "";

        if(extras != null){
             data += extras.getString("datos");
        }

        tvdatos.setText(data);

        String finalData = data;
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                File path = new File("./data/data/com.example.u5_ap1_form_oliverbaidezpatrick/files/datos.csv");

                try {
                    FileWriter fw = new FileWriter(path, true);
                    fw.write(finalData);
                    fw.close();

                    CharSequence text = "Guardado correctamente";
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast t =  Toast.makeText(context, text, duration);
                    t.show();
                } catch (IOException e) {
                    CharSequence text = "No se ha podido guardar";
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast t =  Toast.makeText(context, text, duration);
                    t.show();
                    e.printStackTrace();
                }

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}