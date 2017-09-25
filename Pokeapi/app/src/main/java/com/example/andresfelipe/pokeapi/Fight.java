package com.example.andresfelipe.pokeapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.andresfelipe.pokeapi.Pokefight.Winner;

public class Fight extends AppCompatActivity {

    String name1, name2, imagen1, imagen2;
    int vida1, vida2;

    ImageView poke1,poke2;

    Button Selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        Bundle bundle = getIntent().getExtras();

        name1 = bundle.getString("name");
        name2 = bundle.getString("name2");
        imagen1 = bundle.getString("url1");
        imagen2 = bundle.getString("url2");
        vida1 = bundle.getInt("vida1");
        vida2 = bundle.getInt("vida2");


        poke1=(ImageView)findViewById(R.id.poke1);
        poke2=(ImageView)findViewById(R.id.poke2);



        Glide.with(getApplicationContext()).load(imagen1).into(poke1);
        Glide.with(getApplicationContext()).load(imagen2).into(poke2);
        Selection.setOnClickListener (new View.OnClickListener(){

            public void onClick(View view) {

                boolean turno=true;


                int numero = (int) (Math.random() * 50) + 1;

                if(turno==true){
                    vida1 = vida1-numero;
                    turno=false;
                }else{

                    vida2=vida2-numero;
                }




                if(vida1<=0){

                    Intent intent = new Intent(Fight.this, Winner.class);
                    intent.putExtra("url", imagen2);
                    intent.putExtra("name", name2);

                }


                if(vida2<=0){

                    Intent intent = new Intent(Fight.this, Winner.class);
                    intent.putExtra("url", imagen1);
                    intent.putExtra("name", name1);

                }


            }});






    }
}
