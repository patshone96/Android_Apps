package com.example.u5_ap1_form_oliverbaidezpatrick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private String nombre, apellidos, telefono, mail, cont, pais, radio;
    private float bar;
    private String info ="";

    EditText etNombre, etApellidos, etTelefono, etMail, etCont;
    Spinner spnPais;
    RadioGroup rgConocido;
    RatingBar rbRating;
    Switch swNotificaciones;
    RadioButton rb1, rb2, rb3, rb4;
    CheckBox cbAcepto;
    Button btnEnviar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(getApplicationContext(), Validar.class);



        //Edit Text
         etNombre = findViewById(R.id.etNombre);
         etApellidos = findViewById(R.id.etApellidos);
         etTelefono = findViewById(R.id.etTelefono);
         etMail = findViewById(R.id.etMail);
         etCont = findViewById(R.id.etCont);

         // Spinner
        spnPais = findViewById(R.id.spnPais);

        // RadioGroup y RadioButtons
        rgConocido = findViewById(R.id.rgConocido);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);

        //Checkbox
        cbAcepto = findViewById(R.id.cbAcepto);

        //Rating bar
        rbRating = findViewById(R.id.rbRating);

        //Switch
        swNotificaciones = findViewById(R.id.swNotificaciones);

        //Buttons
        btnCancelar = findViewById(R.id.btnCancelar);
        btnEnviar = findViewById(R.id.btnEnviar);



        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = etNombre.getText().toString();
                apellidos = etApellidos.getText().toString();
                telefono = etTelefono.getText().toString();
                mail = etMail.getText().toString();
                cont = etCont.getText().toString();
                pais = spnPais.getSelectedItem().toString();

                //Obtenermos el valor del radio seleccionado
                try{
                    int check = rgConocido.getCheckedRadioButtonId();
                    RadioButton rb = findViewById(check);
                    radio = rb.getText().toString();

                }catch (Exception e){
                    radio = "No seleccionado";
                }


                bar = rbRating.getRating();


                if(nombre.length()<1 ||
                        apellidos.length() < 1 ||
                        telefono.length() < 1 ||
                        mail.length() < 1 ||
                        cont.length()<1||
                        pais.isEmpty()



                ){

                    CharSequence text = "No puede haber de texto campos vacíos";
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast t =  Toast.makeText(context, text, duration);
                    t.show();



                }else{
                    if (!cbAcepto.isChecked()){
                        CharSequence text = "Debes aceptar los terminos y condiciones";
                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;
                        Toast t =  Toast.makeText(context, text, duration);
                        t.show();
                    }else{

                        if(swNotificaciones.isSelected()){
                            CharSequence text = "Has aceptado recibir notificaciones!";
                            Context context = getApplicationContext();
                            int duration = Toast.LENGTH_SHORT;
                            Toast t =  Toast.makeText(context, text, duration);
                            t.show();

                        }




                        info += nombre+";"+
                                apellidos+";"+
                                telefono+";"+
                                mail+";"+
                                pais +";"+
                                radio + ";"+
                                "rating: " + bar;


                        intent.putExtra("datos", info);
                        startActivity(intent);

                    }



                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });


    }}

