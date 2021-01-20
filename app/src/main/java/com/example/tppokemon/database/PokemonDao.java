package com.example.tppokemon.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tppokemon.model.Pokemon;

import java.util.List;

@Dao
public interface PokemonDao {


    @Query("SELECT * FROM Pokemon")
    List<Pokemon> getAll();

    @Insert
    void insertAll(Pokemon... pokemons);

    @Delete
    void delete(Pokemon pokemon);
}
