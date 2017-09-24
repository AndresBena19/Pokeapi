package com.example.andresfelipe.pokegame.Factory;

/**
 * Created by andres felipe on 24/09/2017.
 */


public class PokemonFactory {



    public static Pokemon GetPokemon (int tipo){

        if (tipo > 0 && tipo <=300) {

            return new LifeGeneration1();

        }else if (tipo>301 && tipo <= 600) {
            return  new LifeGeneration2();

        }else if (tipo > 601 && tipo <=1600) {
            return  new LifeGenaration3();
        }else{
            if (tipo > 1601 && tipo <=5000) {
                return  new LifeGeneration4();
            }

        }
        return null;
    }
}