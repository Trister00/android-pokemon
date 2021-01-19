package com.example.tppokemon.repository;

import com.example.tppokemon.http.IPokemonService;
import com.example.tppokemon.model.ListPokemon;
import com.example.tppokemon.model.PokemonDetails;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class Repository {

    private IPokemonService pokemonService;

    @Inject
    public Repository(IPokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    public Observable<ListPokemon> getPokemons(){
        return pokemonService.getPokemons();
    }

    public Observable<PokemonDetails> getPokemonDetails(String pokemonId) {
        return pokemonService.getPokemonDetails(pokemonId);
    }
}
