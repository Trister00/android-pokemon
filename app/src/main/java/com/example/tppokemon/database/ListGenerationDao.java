package com.example.tppokemon.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.tppokemon.model.ListGeneration;


import java.util.List;

@Dao
public interface ListGenerationDao {


    @Query("SELECT * FROM ListGeneration")
    List<ListGeneration> getAll();

    @Insert
    void insertAll(ListGeneration... listGenerations);

    @Delete
    void delete(ListGeneration listGeneration);
}
