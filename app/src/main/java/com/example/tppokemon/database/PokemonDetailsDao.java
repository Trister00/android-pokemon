package com.example.tppokemon.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.tppokemon.model.PokemonDetails;

import java.util.List;

@Dao
public interface PokemonDetailsDao {

    @Query("SELECT * FROM PokemonDetails")
    List<PokemonDetails> getAll();

    @Insert
    void insertAll(PokemonDetails... pokemondetails);

    @Delete
    void delete(PokemonDetails pokemondetail);
}
