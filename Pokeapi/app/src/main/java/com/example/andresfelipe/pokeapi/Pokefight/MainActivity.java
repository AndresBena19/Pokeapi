package com.example.andresfelipe.pokeapi.Pokefight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.*;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import android.widget.ImageView;

import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.example.andresfelipe.pokeapi.Factory.Pokemon;
import com.example.andresfelipe.pokeapi.Factory.PokemonFactory;
import com.example.andresfelipe.pokeapi.R;
import com.example.andresfelipe.pokeapi.Singleton.MySingleton;

import java.lang.*;

import org.json.JSONException;
import org.json.JSONObject;





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





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Identificando botones y textos
        Selection = (Button) findViewById(R.id.button);
        fight =(Button)findViewById(R.id.button2) ;
        vs = (ImageView)findViewById(R.id.vs) ;

        //Posicionando imagen de vs en pantalla
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



                    String n,m;//valores aletoreos

                    numero = (int) (Math.random() * 721) + 1;
                    numero2 = (int) (Math.random() * 721) + 1;
                    String url="http://pokeapi.co/api/v2/pokemon/"+ numero;
                    String url2="http://pokeapi.co/api/v2/pokemon/"+ numero2;
                    //Envio de peticiones

                    sendjsonrequest2(url2);
                    sendjsonrequest(url);


                    //Ids de valores aletorios obtenidos
                    n=String.valueOf(numero);
                    m=String.valueOf(numero2);
                    pokeid1.setText("id:"+m);
                    pokeid2.setText("id:"+n);



            }});


        fight.setOnClickListener (new View.OnClickListener(){

            public void onClick(View view){
                Intent intent = new Intent (MainActivity.this, Fight.class);

                startActivity(intent);

            }});



    }


    public void sendjsonrequest(String url) {


        JsonObjectRequest jsonObjRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                try {
                    //Parsing de Json
                    int Bexperience;
                    String name;
                    String[] tipos = new String[2];

                    Bexperience =response.getInt("base_experience");

                    //Instanciamos un objeto de tipo Pokemon
                    Pokemon pokeone = PokemonFactory.GetPokemon(Bexperience);

                    //Extraemos la informacion
                    pokeone.Setname(response);
                    pokeone.Setpeso(response);
                    pokeone.Setimagen(response);
                    pokeone.Settipo(response);
                    tipos =pokeone.Gettipo();

                    //Se miestra la informacion por pantalla
                    pokename1.setText(pokeone.Getname());
                    Glide.with(getApplicationContext()).load(pokeone.Getimagen()).into(pokeimage2);
                    pokewight2.setText("Peso:" + pokeone.Getpeso());
                    pokexp2.setText("Experiencia:" + pokeone.Getvida());
                    poketype2.setText("Tipos:"+tipos[0]+","+tipos[1]);







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




    public void sendjsonrequest2(String url) {


        JsonObjectRequest jsonObjRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                try {
                    //Parsing de Json
                    int Bexperience=0;
                    String[] tipos = new String[2];
                    //Instanciamos un objeto de tipo Pokemon
                    Bexperience =response.getInt("base_experience");
                    Pokemon poketwo =PokemonFactory.GetPokemon(Bexperience=0);


                    //Extraemos la informacion
                    poketwo.Setname(response);
                    poketwo.Setpeso(response);
                    poketwo.Setimagen(response);
                    poketwo.Settipo(response);
                    tipos =poketwo.Gettipo();

                    //Se miestra la informacion por pantalla
                    pokename2.setText(poketwo.Getname());
                    Glide.with(getApplicationContext()).load(poketwo.Getimagen()).into(pokeimage1);
                    pokewight1.setText("Peso:" + poketwo.Getpeso());
                    pokexp1.setText("Experiencia:" + poketwo.Getvida());
                    poketype1.setText("Tipos:"+tipos[0]+","+tipos[1]);


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


}