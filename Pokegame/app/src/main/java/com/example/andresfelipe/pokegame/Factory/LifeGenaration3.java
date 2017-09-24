package com.example.andresfelipe.pokegame.Factory;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by andres felipe on 24/09/2017.
 */

public class LifeGenaration3 extends Pokemon {

    public void Setvida(JSONObject info) throws JSONException {

        vida =info.getInt("base_experience");

    }

}
