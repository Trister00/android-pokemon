package com.example.tppokemon.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tppokemon.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PokemonDao {


    @Query("SELECT * FROM Pokemon")
    List<Pokemon> getAll();

    @Insert
    void insert( Pokemon pokemon);

    @Delete
    void delete(Pokemon pokemon);
}
