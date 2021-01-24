package com.example.tppokemon.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tppokemon.model.Family;

import java.util.List;

@Dao
public interface FamilyDao {

    @Query("SELECT * FROM Family")
    List<Family> getAll();

    @Insert
    void insertAll(Family... families);

    @Delete
    void delete(Family family);
}