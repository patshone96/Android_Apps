package com.example.u6_ae1_oliverbaidezpatrick;

import java.io.Serializable;

public class Film implements Serializable {

    //Clase serializable película. Contiene todos los datos necesarios para generar un elemento película
    private String title;
    private String desc;
    private int image;
    private int year;



    public Film(){

    }

    public Film(String title, String desc, int image, int year) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.year = year;
    }

    public Film(String title, int image, int year) {
        this.title = title;
        this.year = year;
        this.image = image;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {

        if(title.length()>20){
            return title.substring(0, 20);
        }
        return title;
    }

    public String getFullTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {

        if(desc.length()>40){
            return desc.substring(0,40);
        }
        return desc;

    }

    public String getFullDesc(){
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
