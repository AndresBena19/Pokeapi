package com.example.andresfelipe.pokeapi.Pokefight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.andresfelipe.pokeapi.R;

public class Winner extends AppCompatActivity {


    String name1, url;

    ImageView imagen;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        //Se capturan los datos del pokemon ganador
        Bundle bundle = getIntent().getExtras();

        name1 = bundle.getString("name");
        url= bundle.getString("url");

        //Se indentifican los botones y texto
        name= (TextView)findViewById(R.id.textView3);
        imagen=(ImageView)findViewById(R.id.imageView);


        //Se muestra imagen y nombre del pokemon ganador
        name.setText(name1);
        Glide.with(getApplicationContext()).load(url).into(imagen);



    }
}
