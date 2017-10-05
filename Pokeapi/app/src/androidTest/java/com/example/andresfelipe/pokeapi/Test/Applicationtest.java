package com.example.andresfelipe.pokeapi.Test;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.andresfelipe.pokeapi.Factory.Pokemon;
import com.example.andresfelipe.pokeapi.Factory.PokemonFactory;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by andres felipe on 03/10/2017.
 */

public class Applicationtest extends ApplicationTestCase<Application> {


    public Applicationtest(){super(Application.class);}


    int x=0;

   Pokemon pokeone = PokemonFactory.GetPokemon(x);

    public void ThisAlwaysHappend(){

        assertTrue(5>1);
    }


    public void ExpectedName() throws JSONException {

      String name= "";

        assertEquals(name, pokeone.Getname());

    }


    public void ExpectedTipo() throws JSONException {

       String[] tipos = new String[2];

        assertEquals(tipos, pokeone.Gettipo());

    }


    public void ExpectedVida() throws JSONException {

        int vida=0;

        assertEquals(vida, pokeone.Getvida());

    }

    public void ExpectedPeso() throws JSONException {

        int Peso=0;

        assertEquals(Peso, pokeone.Getpeso());

    }


    public void ExpectedImagen() throws JSONException {

        String Imagen="";

        assertEquals(Imagen, pokeone.Getimagen());

    }



}
