package com.example.tppokemon.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tppokemon.model.CountGeneration;


import java.util.List;

@Dao
public interface CountGenerationDao {
    @Query("SELECT * FROM CountGeneration")
    List<CountGeneration> getAll();

    @Insert
    void insertAll(CountGeneration... countGeneration);


}
