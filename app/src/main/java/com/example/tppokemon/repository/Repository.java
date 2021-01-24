package com.example.tppokemon.repository;

import com.example.tppokemon.http.IPokemonEvolutionsService;
import com.example.tppokemon.http.IPokemonService;
import com.example.tppokemon.model.ListPokemon;
import com.example.tppokemon.model.PokemonDetails;
import com.example.tppokemon.model.PokemonEvolution;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.rxjava3.core.Observable;


public class Repository {

    private IPokemonService pokemonService;
    private IPokemonEvolutionsService pokemonEvolutionsService;

    @Inject
    public Repository(@Named("pokemon") IPokemonService pokemonService, @Named("evolution") IPokemonEvolutionsService pokemonEvolutionsService) {
        this.pokemonService = pokemonService;
        this.pokemonEvolutionsService = pokemonEvolutionsService;
    }

    public Observable<ListPokemon> getPokemons(){
        return pokemonService.getPokemons();
    }

    public Observable<PokemonDetails> getPokemonDetails(String pokemonId) {
        return pokemonService.getPokemonDetails(pokemonId);
    }

    public Observable<List<PokemonEvolution>> getPokemonEvolutions(String pokemonId){
        return pokemonEvolutionsService.getPokemonEvolutions(pokemonId);
    }
}
