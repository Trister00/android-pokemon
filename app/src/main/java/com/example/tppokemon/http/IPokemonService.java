package com.example.tppokemon.http;

import com.example.tppokemon.model.ListPokemon;
import com.example.tppokemon.model.PokemonDetails;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IPokemonService {

    @GET("pokemon?limit=151")
    Observable<ListPokemon> getPokemons();

    @GET("pokemon/{pokemonId}")
    Observable<PokemonDetails> getPokemonDetails(@Path("pokemonId") String pokemonId);
}
