package com.example.andresfelipe.pokeapi.Factory;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by andres felipe on 23/09/2017.
 */

public class LifeGeneration1 extends Pokemon {

    public void Setvida(JSONObject info) throws JSONException {

        vida =info.getInt("base_experience");

    }


}
