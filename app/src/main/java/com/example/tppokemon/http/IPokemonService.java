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
import retrofit2.http.Url;

public interface IPokemonService {

    @GET("pokemon?limit=151")
    Observable<ListPokemon> getPokemons();

    @GET("api/v2/pokemon")
    Observable<Pokemon> getPokemons(
            @Query("offset") int offset,
            @Query("limit") int limit
    );


    @GET("/v1/pokemon/counts")
    Call<CountGeneration> getCountGeneration();

    @GET("pokemon/{pokemonId}")
    Observable<PokemonDetails> getPokemonDetails(@Path("pokemonId") String pokemonId);

    @GET("api/v2/generation")
    Observable<ListGeneration> getListGeneration();



}
