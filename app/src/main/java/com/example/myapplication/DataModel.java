package com.example.myapplication;

import android.graphics.drawable.Drawable;

public class DataModel {

    private String name;
    private String price;
    private Drawable image;

    public DataModel(String name, String price, Drawable image){
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String GetName(){
        return this.name;
    }

    public String GetPrice(){
        return this.price;
    }

    public Drawable GetImage(){
        return this.image;
    }

}
