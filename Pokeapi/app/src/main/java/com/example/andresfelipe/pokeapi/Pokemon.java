package com.example.andresfelipe.pokeapi;

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
    public  int  id;
    public int peso;
    public int vida;






    public void Setname(JSONObject info) throws JSONException {
        this.name=info.getString("name");
    }


    public String Getname(){

        return name;
    }

    public void Settipo(JSONArray info) throws JSONException {
        JSONArray Types2= null;
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










}
