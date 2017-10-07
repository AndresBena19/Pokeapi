package com.example.andresfelipe.pokeapi.Factory;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.andresfelipe.pokeapi.Singleton.MySingleton;

import org.json.JSONObject;

/**
 * Created by andres felipe on 23/09/2017.
 */

public class Jsonrequest extends MainActivity {




    public JSONObject info;



    public  void sendRequest(String url) {


        JsonObjectRequest jsonObjRequest= new JsonObjectRequest(com.android.volley.Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {


                info =response;

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });


        MySingleton.getInstance(this).addToRequestQueue(jsonObjRequest);



    }



    public JSONObject Getinfo(){

        return info;
    }
}
