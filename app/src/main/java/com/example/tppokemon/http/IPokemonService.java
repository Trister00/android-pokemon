package com.example.tppokemon.http;

import com.example.tppokemon.model.CountGeneration;
import com.example.tppokemon.model.Generation;
import com.example.tppokemon.model.ListGeneration;
import com.example.tppokemon.model.ListPokemon;
import com.example.tppokemon.model.Pokemon;
import com.example.tppokemon.model.PokemonDetails;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IPokemonService {

    @GET("pokemon?limit=151")
    Observable<ListPokemon> getPokemons();

    @GET("pokemon")
    Observable<ListPokemon> getPokemonsByGeneration(@Query("offset") int offset, @Query("limit") int limit);

    @GET("pokemon/{pokemonId}")
    Observable<PokemonDetails> getPokemonDetails(@Path("pokemonId") String pokemonId);

    @GET("generation")
    Call<ListGeneration> getListGeneration();
}
