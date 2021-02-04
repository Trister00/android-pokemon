package com.example.tppokemon;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.tppokemon.model.PokemonDetails;
import com.example.tppokemon.viewmodel.PokemonViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PokemonDetailsActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private PokemonViewModel viewModel;
    private Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        TextView pokemonNameView = findViewById(R.id.pokemon_name);
        ImageView pokemonImage = findViewById(R.id.pokemon_image);

        String pokemonName = getIntent().getExtras().getString("pokemon_name");
        String pokemonImageUrl = getIntent().getExtras().getString("pokemon_image");

        Glide.with(this).load(pokemonImageUrl).into(pokemonImage);

        viewModel = new ViewModelProvider(this).get(PokemonViewModel.class);

        viewModel.getPokemonDetails(pokemonName);
        viewModel.getPokemonDetails().observe(this, new Observer<PokemonDetails>() {
            @Override
            public void onChanged(PokemonDetails pokemonDetails) {
                pokemonNameView.setText(pokemonDetails.getName());

                bundle.putString("pokemon_name",pokemonName);
                bundle.putInt("height",pokemonDetails.getHeight());
                bundle.putInt("weight",pokemonDetails.getWeight());
                bundle.putString("type_one",pokemonDetails.getTypes().get(0).getType().getName());
                bundle.putString("type_two",pokemonDetails.getTypes().size() ==2 ? pokemonDetails.getTypes().get(1).getType().getName() : "");

                loadFragment(new PokemonInfos());
            }
        });





        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.details:
                fragment = new PokemonInfos();
                break;

            case R.id.evolutions:
                fragment = new PokemonEvolutions();
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            fragment.setArguments(this.bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
