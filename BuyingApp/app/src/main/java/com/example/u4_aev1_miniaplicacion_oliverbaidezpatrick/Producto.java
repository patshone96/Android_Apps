package com.example.u4_aev1_miniaplicacion_oliverbaidezpatrick;

public class Producto {
    private String nombre;
    private int cantidad;
    private float precio;

    public Producto(String nombre, int cantidad, float precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
                String nom = "";

                if(nombre.length() > 10){
                     nom = nombre.substring(0,10);
                }else{
                     nom = nombre;
                }

        return nom + ": "
                + cantidad + " unidades " +
                " precio: " + precio +"\n";
    }
}
