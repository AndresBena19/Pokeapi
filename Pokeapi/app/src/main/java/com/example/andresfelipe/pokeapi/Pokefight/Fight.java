package com.example.andresfelipe.pokeapi.Pokefight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.andresfelipe.pokeapi.Factory.Pokemon;
import com.example.andresfelipe.pokeapi.R;

import org.json.JSONObject;
public class Fight extends AppCompatActivity {


    String name1, name2, imagen1, imagen2, Vida, Vida2;
    int experiencia1, experiencia2;

    ImageView poke1,poke2;
    TextView pokename1, pokename2, pokevida1, pokevida2, golpe, poketurno;

    Button Selection;

    int vida1 ;
    int vida2;

    boolean turno=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        Bundle bundle = getIntent().getExtras();

        // Extraemos valor del anterior activity
        name1 = bundle.getString("name1");
        name2 = bundle.getString("name2");
        imagen1 = bundle.getString("url1");
        imagen2 = bundle.getString("url2");
        vida1=bundle.getInt("vida1");
        vida2=bundle.getInt("vida2");


        //Encontramos los botoes y textos
        poke1=(ImageView)findViewById(R.id.poke1);
        poke2=(ImageView)findViewById(R.id.poke2);
        pokename1=(TextView)findViewById(R.id.textView5);
        pokename2=(TextView)findViewById(R.id.textView7);
        pokevida1=(TextView)findViewById(R.id.vida1);
        pokevida2=(TextView)findViewById(R.id.vida2);

        Selection = (Button) findViewById(R.id.pelea);

        golpe= (TextView)findViewById(R.id.textView8);

        poketurno= (TextView)findViewById(R.id.textView10);




        //Mostramos imagen de pokemon en pantalla
        Glide.with(getApplicationContext()).load(imagen1).into(poke1);
        Glide.with(getApplicationContext()).load(imagen2).into(poke2);

        pokename1.setText(name1);
        pokename2.setText(name2);

        //Convertimos a cadena los valores de vida
         Vida =String.valueOf(vida1);
        Vida2= String.valueOf(vida2);

        ///Se muestra por pantalla la vida
        pokevida1.setText(Vida);
        pokevida2.setText(Vida2);


        //El turno siempre sera del pokemon numero 1
        if(turno==true){
            poketurno.setText(name1);
        }




        Selection.setOnClickListener (new View.OnClickListener(){


            public void onClick(View view) {

                //Generando random de ataque
                int numero = (int) (Math.random() * 50) + 1;


                //Gracias a una variales booleanda, podemos turnar los ataques de cada poquemon
                if(turno==false){

                    //Se muestra  el daño generado
                    String n;
                    n= String.valueOf(numero);
                    golpe.setText(n);

                    //Se reduce la vida del pokemon
                    vida1 = vida1-numero;
                    turno=true;
                }else{

                    //Se muestra el daño generado
                    String n;
                    n= String.valueOf(numero);
                    golpe.setText(n);

                    vida2=vida2-numero;

                    turno=false;
                }

                //Se hace cambio de nombre en el textview de turno
                if(turno==false){
                    poketurno.setText(name2);
                }else{
                    poketurno.setText(name1);
                }

                //Se muestran los nuevos valoresen al vida de los pokemon
                String newlife, newlife1;

                newlife=String.valueOf(vida1);
                newlife1=String.valueOf(vida2);
                pokevida1.setText(newlife);
                pokevida2.setText(newlife1);


                //En caso de que alguno de los pokemon tenga una vida menor o igual que cero,
                //se envian su datos de el otro pokemon, el cual se presentara como ganador
                if(vida1<=0){

                    Intent intent = new Intent(Fight.this, Winner.class);
                    intent.putExtra("url", imagen2);
                    intent.putExtra("name", name2);
                    startActivity(intent);
                }


                if(vida2<=0){

                    Intent intent = new Intent(Fight.this, Winner.class);
                    intent.putExtra("url", imagen1);
                    intent.putExtra("name", name1);
                    startActivity(intent);
                }

            }});










    }
}
