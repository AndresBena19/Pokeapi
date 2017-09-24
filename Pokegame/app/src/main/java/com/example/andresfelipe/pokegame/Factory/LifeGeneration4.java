package com.example.andresfelipe.pokegame.Factory;

import org.json.JSONException;
import org.json.JSONObject;

public class LifeGeneration4 extends Pokemon {

    public void Setvida(JSONObject info) throws JSONException {

        vida =info.getInt("base_experience");

    }

}

