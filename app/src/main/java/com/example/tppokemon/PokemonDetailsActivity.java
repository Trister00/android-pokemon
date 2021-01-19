package com.example.tppokemon;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.tppokemon.model.Pokemon;
import com.example.tppokemon.model.PokemonDetails;
import com.example.tppokemon.viewmodel.PokemonViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PokemonDetailsActivity extends AppCompatActivity {
    private PokemonViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_details);

        TextView pokemonNameView = findViewById(R.id.pokemon_name);
        ImageView pokemonImage = findViewById(R.id.pokemon_image);

        TextView pokemonHeight = findViewById(R.id.pokemon_height);
        TextView pokemonWeight = findViewById(R.id.pokemon_weight);

        TextView pokemonTypeOne = findViewById(R.id.pokemon_type_1);
        TextView pokemonTypeTwo = findViewById(R.id.pokemon_type_2);

        String pokemonName = getIntent().getExtras().getString("pokemon_name");
        String pokemonImageUrl = getIntent().getExtras().getString("pokemon_image");

        Glide.with(this).load(pokemonImageUrl).into(pokemonImage);

        viewModel = new ViewModelProvider(this).get(PokemonViewModel.class);

        viewModel.getPokemonDetails(pokemonName);
        viewModel.getPokemonDetails().observe(this, new Observer<PokemonDetails>() {
            @Override
            public void onChanged(PokemonDetails pokemonDetails) {
                pokemonNameView.setText(pokemonDetails.getName());
                pokemonHeight.setText(pokemonDetails.getHeight() + " m");
                pokemonWeight.setText(pokemonDetails.getWeight() + " kg");
                pokemonTypeOne.setText(pokemonDetails.getTypes().get(0).getType().getName());
                pokemonTypeTwo.setText(pokemonDetails.getTypes().size() ==2 ? pokemonDetails.getTypes().get(1).getType().getName() : "");
            }
        });


    }
}
