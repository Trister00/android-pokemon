package com.example.tppokemon.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.tppokemon.model.ListPokemon;


import java.util.List;

@Dao
public interface ListPokemonDao {


    @Query("SELECT * FROM ListPokemon")
    List<ListPokemon> getAll();

    @Insert
    void insertAll(ListPokemon... listPokemons);

    @Delete
    void delete(ListPokemon listPokemon);
}
