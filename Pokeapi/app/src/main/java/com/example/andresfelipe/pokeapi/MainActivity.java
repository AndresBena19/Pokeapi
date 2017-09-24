package com.example.andresfelipe.pokeapi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Response.ErrorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;

import java.lang.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {




    public static final String TAG = MainActivity.class.getSimpleName();

    boolean poke=true;

    private Button Selection, fight;

    TextView pokename1, pokename2,
             poketype1,poketype2,
             pokegeneration1,pokegeneration2,
             pokelife1,pokelife2,
             pokewight1,pokewight2,
             pokexp1,pokexp2,
             pokeid1, pokeid2;


    private  ImageView pokeimage1, pokeimage2, vs; JSONObject abilities;




    int numero, numero2;
    String gen1= "",gen2="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Selection = (Button) findViewById(R.id.button);
        fight =(Button)findViewById(R.id.button2) ;
        vs = (ImageView)findViewById(R.id.vs) ;
        Glide.with(getApplicationContext()).load("http://c.dx.com/collection/201704/20170426/images/vs.png").into(vs);

        pokename1=(TextView) findViewById(R.id.pokemon1);
        pokename2=(TextView) findViewById(R.id.pokemon2);

        pokeimage1= (ImageView) findViewById(R.id.image1);
        pokeimage2= (ImageView) findViewById(R.id.image2);

        poketype1=(TextView)findViewById(R.id.type1);
        poketype2=(TextView)findViewById(R.id.type2);

        pokewight1=(TextView)findViewById(R.id.weight1) ;
        pokewight2=(TextView)findViewById(R.id.weight2) ;

        pokexp1=(TextView)findViewById(R.id.exp1);
        pokexp2=(TextView)findViewById(R.id.exp2);



        pokeid1 = (TextView)findViewById(R.id.id1);
        pokeid2 = (TextView)findViewById(R.id.id2);


        Selection.setOnClickListener (new View.OnClickListener(){

            public void onClick(View view){

                    String n,m;











                    numero = (int) (Math.random() * 721) + 1;
                    numero2 = (int) (Math.random() * 721) + 1;

                    String url="http://pokeapi.co/api/v2/pokemon/"+ numero;
                    sendjsonrequest(url);
                    String url2="http://pokeapi.co/api/v2/pokemon/"+ numero2;
                    sendjsonrequest2(url2);


                    n=String.valueOf(numero);
                    m=String.valueOf(numero2);




                    pokeid1.setText("id:"+ m);



                    pokeid2.setText("id:"+n);










            }});


        fight.setOnClickListener (new View.OnClickListener(){

            public void onClick(View view){
                Intent intent = new Intent (MainActivity.this, Fight.class);
                startActivity(intent);

            }});



    }







    public String sendjsonrequest(String url) {
        final String[] Requestype2 = new String[1];

        JsonObjectRequest jsonObjRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            String name,photo;
            int weight,Bexperience;

                    @Override
                    public void onResponse(JSONObject response) {
                        try {



                                name=response.getString("name");
                                weight= response.getInt("weight");
                                Bexperience =response.getInt("base_experience");
                                abilities = response.getJSONObject("sprites");
                              //  id = response.getInt("id");

                                // String url2="http://pokeapi.co/api/v2/type/"+ numero;

                                JSONArray Types2= null;
                                JSONObject category2= null;
                                JSONObject Ptype2= null;


                                pokename1.setText(name);
                                photo = abilities.getString("front_shiny");
                                Glide.with(getApplicationContext()).load(photo).into(pokeimage2);
                                weight = response.getInt("weight");
                                pokewight2.setText("Peso:" + weight);
                                pokexp2.setText("Experiencia:" + Bexperience);
                                ///pokeid2.setText(id);
                               // Gettype(response, poke);

                                Types2 = response.getJSONArray("types");

                                String[] tipos = new String[2];

                                for (int j=0; j<2;j++) {
                                    category2 = Types2.getJSONObject(j);
                                    Ptype2 = category2.getJSONObject("type");
                                    tipos[j]=Ptype2.getString("name");


                                }


                                poketype2.setText("Tipos:"+tipos[0]+","+tipos[1]);


                                //intent.putExtra("poke", poke);
                               // intent.putExtra("name2",name);

                                //PokemonFiles(url2);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });


        MySingleton.getInstance(this).addToRequestQueue(jsonObjRequest);
        return Requestype2[0];
    }





    public void sendjsonrequest2(String url) {


        JsonObjectRequest jsonObjRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                try {
                    String name,photo;
                    int weight,Bexperience;






                        name=response.getString("name");
                        weight= response.getInt("weight");
                        Bexperience =response.getInt("base_experience");
                        abilities = response.getJSONObject("sprites");
                     //   id=response.getInt("id");
                        // String url2="http://pokeapi.co/api/v2/type/"+ numero;

                        JSONArray Types2= null;
                        JSONObject category2= null;
                        JSONObject Ptype2= null;
                        String Requestype2= " ";

                        pokename2.setText(name);
                        photo = abilities.getString("front_shiny");
                        Glide.with(getApplicationContext()).load(photo).into(pokeimage1);
                        weight = response.getInt("weight");
                        pokewight1.setText("Peso:" + weight);
                        pokexp1.setText("Experiencia:" + Bexperience);
                      //  pokeid2.setText(id);

                        // Gettype(response, poke);

                        Types2 = response.getJSONArray("types");

                        String[] tipos2 = new String[2];

                        for (int j=0; j<2;j++) {
                            category2 = Types2.getJSONObject(j);
                            Ptype2 = category2.getJSONObject("type");
                            tipos2[j]=Ptype2.getString("name");



                        }


                        poketype1.setText("Tipos:"+tipos2[0]+","+tipos2[1]);

                        //intent.putExtra("poke", poke);
                        // intent.putExtra("name2",name);

                        //PokemonFiles(url2);
                        poke=true;



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });


        MySingleton.getInstance(this).addToRequestQueue(jsonObjRequest);
    }
/*

    public void Gettype(JSONObject response, boolean poke,) throws JSONException {



        String  Requestype="";
        Types = response.getJSONArray("types");

        String[] tipos = new String[2];

        for (int j=0; j<2;j++) {
            category = Types.getJSONObject(j);
            Ptype = category.getJSONObject("type");
            tipos[j]=Ptype.getString("name");

            if(Ptype.getString("slot").equals("1")) {
                Requestype= Ptype.getString("url");
            }

        }

        if(poke==true) {
            poketype1.setText("Tipos:"+tipos[0]+","+tipos[1]);
        }else {
            poketype2.setText("Tipos:"+tipos[0]+","+tipos[1]);
        }


        //sendjsonrequest2(Requestype);





    }

    public void sendGeneration(String url) {

        JsonObjectRequest jsonObjRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                try {



                    JSONObject Generation;
                    String Gen;

                    Generation=response.getJSONObject("generation");

                    Gen=Generation.getString("name");


                    pokegeneration1.setText(Gen);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });


        MySingleton.getInstance(this).addToRequestQueue(jsonObjRequest);
    }


*/



}