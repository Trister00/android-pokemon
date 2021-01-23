package com.example.tppokemon.http;

import com.example.tppokemon.model.PokemonEvolution;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IPokemonEvolutionsService {

    @GET("{pokemonId}")
    Observable<List<PokemonEvolution>> getPokemonEvolutions(@Path("pokemonId") String pokemonId);
}
