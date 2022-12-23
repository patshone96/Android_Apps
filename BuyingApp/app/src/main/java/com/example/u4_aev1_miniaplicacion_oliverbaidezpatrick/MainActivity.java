package com.example.u4_aev1_miniaplicacion_oliverbaidezpatrick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Definimos las variables que contendrán nuestras views
    Button btnSalir, btnAdd;
    TextView tvCompra, tvResultadoTotal;
    EditText ptProducto, ptPrecio, ptCantidad;

    //Definimos las variables que se van a ir ejecutando a lo largo del programa
    private float precio, total =0;
    private String producto, compra = "";
    private int cantidad;
    private ArrayList<Producto> carrito = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Capturamos los EditText
        ptProducto = findViewById(R.id.ptProducto);
        ptCantidad = findViewById(R.id.ptCantidad);
        ptPrecio = findViewById(R.id.ptPrecio);

        //Capturamos los TextView
        tvCompra = findViewById(R.id.tvCompra);
        tvResultadoTotal = findViewById(R.id.tvResultadoTotal);
        //tvCompra será Scrolleable (Se define con android:scrollbars="vertical")
        tvCompra.setMovementMethod(new ScrollingMovementMethod());

        //Capturamos los botones
        btnSalir = findViewById(R.id.btnSalir);
        btnAdd = findViewById(R.id.btnAdd);


        //Definimos la acción del botón añadir
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Reseteamos las variables
                total = 0;
                compra = "";
                //Toast Message counter
                int cont = 0;
                //Toast context and duration
                int duration = Toast.LENGTH_SHORT;
                Context context = getApplicationContext();

                try {
                    //Probamos a capturar los valores de los views de input y parsearlos
                    precio =  Float.parseFloat(ptPrecio.getText().toString());
                    cantidad =  Integer.parseInt(ptCantidad.getText().toString());
                    producto =  ptProducto.getText().toString();

                    //Creamos un producto con los datos y lo guardamos en la lista carrito
                    carrito.add(new Producto(producto, cantidad, precio));

                    //Recogemos el valor del último producto y lo guardamos en la variable text
                    CharSequence text = carrito.get(cont++).toString();

                    //Mostramos un toast con el último producto añadido
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }catch(Exception e){
                    //mostramos en un toast el error
                    CharSequence text = e.toString();
                    Toast t = Toast.makeText(context, text, duration);
                    t.show();

                }


            try{

                //Leemos los productos en el carrito y los guardamos como texto en la variable total
                // Los leemos de último a primero, para que el primer producto que aparece en el texto
                // sea el último que se ha añadido al carrito
                //Esto lo conseguimos con carrito.size()-i
                for(int i =0; i < carrito.size(); i++){

                    compra+= (carrito.size()-i) + ". " + carrito.get(carrito.size()-1).toString();
                    int cant = (int) carrito.get(carrito.size()-1).getCantidad();
                    float prec = (float) carrito.get(carrito.size()-1).getPrecio();
                    total+=(cant*prec);

            }


            }catch(Exception e1){
                //Mostramos un mensaje de error por el toast
                Toast t = Toast.makeText(context, e1.toString(), duration);
                t.show();


                }

                // Mostramos en tvCompra la lista de objetos en el carrito
                tvCompra.setText(compra);

                //mostramos el total comprado en el tvResultadoTotal
                tvResultadoTotal.setText(total+"");

            }
        });


        //Definimos la acción al pulsar el botón salir
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}