package com.example.tppokemon;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PokemonDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_details);

        TextView textView = findViewById(R.id.textView);

        textView.setText(getIntent().getExtras().getString("pokemon"));


    }
}
