package com.example.tppokemon.http;

import com.example.tppokemon.model.ListPokemon;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IPokemonService {

    @GET("pokemon")
    Observable<ListPokemon> getPokemons();
}
