package com.example.tppokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tppokemon.adapter.PokemonAdapter;
import com.example.tppokemon.model.Pokemon;
import com.example.tppokemon.viewmodel.PokemonViewModel;

import java.util.ArrayList;

import dagger.hilt.EntryPoint;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private PokemonViewModel viewModel;
    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;
    private PokemonAdapter.RecyclerViewClickListner listner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.pokemon_recyclerView);


        listner = new PokemonAdapter.RecyclerViewClickListner() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),PokemonDetailsActivity.class);
                intent.putExtra("pokemon",pokemonAdapter.getPokemonAt(position).getName());
                startActivity(intent);
            }
        };


        pokemonAdapter = new PokemonAdapter(this,listner);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        recyclerView.setAdapter(pokemonAdapter);

        viewModel = new ViewModelProvider(this).get(PokemonViewModel.class);

        viewModel.getPokemons();
        viewModel.getPokemonList().observe(this, new Observer<ArrayList<Pokemon>>() {
            @Override
            public void onChanged(ArrayList<Pokemon> pokemons) {
                pokemonAdapter.setList(pokemons);
            }
        });
    }
}