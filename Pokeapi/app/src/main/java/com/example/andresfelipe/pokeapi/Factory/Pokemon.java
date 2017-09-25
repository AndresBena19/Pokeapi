package com.example.andresfelipe.pokeapi.Factory;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.Object;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import android.widget.ImageView;

import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.example.andresfelipe.pokeapi.Pokefight.Fight;
import com.example.andresfelipe.pokeapi.R;
import com.example.andresfelipe.pokeapi.Singleton.MySingleton;

import java.lang.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by andres felipe on 23/09/2017.
 */

public abstract class Pokemon {



    JSONObject Pokeinfo;



    public String name;
    public  String[] tipos = new String[2];
    public int peso;
    public int vida;
    public String imagen;






    public void Setname(JSONObject info) throws JSONException {
        name=info.getString("name");
    }


    public String Getname(){

        return name;
    }

    public void Settipo(JSONObject info) throws JSONException {


        JSONArray Types2;
        Types2 = info.getJSONArray("types");
        JSONObject category2= null;
        JSONObject Ptype2= null;

        for (int j=0; j<2;j++) {
            category2 = Types2.getJSONObject(j);
            Ptype2 = category2.getJSONObject("type");
            tipos[j]=Ptype2.getString("name");


        }
    }

    public String[] Gettipo(){

        return tipos;
    }


    public abstract void Setvida(JSONObject info) throws JSONException;


    public int Getvida(){
        return  vida;
    }

    public void Setpeso(JSONObject info) throws JSONException {

       peso = info.getInt("weight");
    }

    public int Getpeso(){

        return peso;
    }


    public void Setimagen(JSONObject info) throws JSONException {

        JSONObject img;
        img = info.getJSONObject("sprites");
        imagen = img.getString("front_shiny");

    }

    public String Getimagen(){
       return imagen;

    }







}
