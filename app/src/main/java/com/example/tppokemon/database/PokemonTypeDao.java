package com.example.tppokemon.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tppokemon.model.PokemonType;

import java.util.List;

@Dao
public interface PokemonTypeDao {
    @Query("SELECT * FROM PokemonType")
    List<PokemonType> getAll();

    @Insert
    void insertAll(PokemonType... pokemonType);

    @Delete
    void delete(PokemonType pokemontype);
}
