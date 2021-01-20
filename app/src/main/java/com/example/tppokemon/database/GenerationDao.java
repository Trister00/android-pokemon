package com.example.tppokemon.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tppokemon.model.Generation;


import java.util.List;

@Dao
public interface GenerationDao {


    @Query("SELECT * FROM Generation")
    List<Generation> getAll();

    @Insert
    void insertAll(Generation... generations);

    @Delete
    void delete(Generation generation);
}
