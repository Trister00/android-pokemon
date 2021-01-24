package com.example.tppokemon.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tppokemon.model.Family;
import com.example.tppokemon.model.PokemonEvolution;

import java.util.List;

@Dao
public interface PokemonEvolutionDao {


        @Query("SELECT * FROM PokemonEvolution")
        List<PokemonEvolution> getAll();

        @Insert
        void insertAll(PokemonEvolution... pokemonEvolutions);

        @Delete
        void delete(PokemonEvolution pokemonEvolution);

}
