package com.example.andresfelipe.pokeapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

public class Fight extends AppCompatActivity {

    String name;

    TextView pokename1, pokename2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);



        Bundle bundle = getIntent().getExtras();


        pokename1 =(TextView)findViewById(R.id.name1);
        pokename2 =(TextView)findViewById(R.id.name2);

        boolean poke =bundle.getBoolean("poke");

        if(poke==true) {
             name = bundle.getString("name");
            pokename1.setText(name);
        }else{
            name = bundle.getString("name");
            pokename2.setText(name);
        }



    }
}
