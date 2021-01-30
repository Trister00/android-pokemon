package com.example.tppokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.tppokemon.adapter.GenerationAdapter;
import com.example.tppokemon.adapter.PokemonAdapter;
import com.example.tppokemon.database.PokemonDatabase;
import com.example.tppokemon.di.RetrofitModule;
import com.example.tppokemon.http.IPokemonService;
import com.example.tppokemon.model.Generation;
import com.example.tppokemon.model.ListGeneration;
import com.example.tppokemon.model.ListPokemon;
import com.example.tppokemon.model.Pokemon;
import com.example.tppokemon.viewmodel.PokemonViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.EntryPoint;
import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements DataTransfer {

    private PokemonViewModel viewModel;
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewballs;
    private PokemonAdapter pokemonAdapter;
    private GenerationAdapter generationAdapter;
    private PokemonAdapter.RecyclerViewClickListner listner;
    private PokemonDatabase database;
    private LinearLayoutManager layoutManager;
    private ArrayList<Generation> listGeneration = new ArrayList<Generation>();
    private IPokemonService generation;
    private Call<ListGeneration> baseGenerationCall;

    private LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.pokemon_recyclerView);
        recyclerViewballs = findViewById(R.id.generationballs);
        generationAdapter = new GenerationAdapter(this, MainActivity.this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewballs.setLayoutManager(layoutManager);
        recyclerViewballs.setAdapter(generationAdapter);
        database = PokemonDatabase.getInstance(this);
        generation = RetrofitModule.providePokemonService();
        baseGenerationCall = generation.getListGeneration();

        lottieAnimationView = findViewById(R.id.pokemon_load);



        listner = new PokemonAdapter.RecyclerViewClickListner() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),PokemonDetailsActivity.class);
                intent.putExtra("pokemon_name",pokemonAdapter.getPokemonAt(position).getName());
                intent.putExtra("pokemon_image",pokemonAdapter.getPokemonAt(position).getUrl());
                startActivity(intent);
            }
        };



        baseGenerationCall.enqueue(new Callback<ListGeneration>() {
            @Override
            @EverythingIsNonNull
            public void onResponse(Call<ListGeneration> call, Response<ListGeneration> response) {
                ListGeneration listGenerationn = response.body();
                listGeneration = listGenerationn.getResults();
                generationAdapter.setGenerationballs(listGeneration);
            }

            @Override
            public void onFailure(Call<ListGeneration> call, Throwable t) {

            }

        });

        pokemonAdapter = new PokemonAdapter(this,listner);

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        recyclerView.setAdapter(pokemonAdapter);

        viewModel = new ViewModelProvider(this).get(PokemonViewModel.class);
//        lottieAnimationView.setVisibility(View.VISIBLE);
        if(!database.pokemonDao().getAll().isEmpty()){
            pokemonAdapter.setList((ArrayList)database.pokemonDao().getAll());
            lottieAnimationView.setVisibility(View.GONE);
        }
        else {
            lottieAnimationView.setVisibility(View.VISIBLE);
        viewModel.getPokemons();
        viewModel.getPokemonList().observe(this, new Observer<ArrayList<Pokemon>>() {
            @Override
            public void onChanged(ArrayList<Pokemon> pokemons) {
                pokemonAdapter.setList(pokemons);
                pokemons.stream().forEach(pokemon ->database.pokemonDao().insert(pokemon));
                lottieAnimationView.setVisibility(View.GONE);
            }
        });
    }
    }
    @Override
    public void onSetValues(int offset,int limit) {
        lottieAnimationView.setVisibility(View.VISIBLE);
        viewModel.getPokemonsByGeneration(offset,limit);
        viewModel.getPokemonList().observe(this, new Observer<ArrayList<Pokemon>>() {
            @Override
            public void onChanged(ArrayList<Pokemon> pokemons) {
                lottieAnimationView.setVisibility(View.VISIBLE);
                pokemonAdapter.setList(pokemons);
                pokemons.stream().forEach(pokemon ->database.pokemonDao().insert(pokemon));
                lottieAnimationView.setVisibility(View.GONE);
            }
        });
    }
}