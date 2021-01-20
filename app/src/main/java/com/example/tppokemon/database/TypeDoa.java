package com.example.tppokemon.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tppokemon.model.Type;

import java.util.List;

@Dao
public interface TypeDoa {
    @Query("SELECT * FROM Type")
    List<Type> getAll();

    @Insert
    void insertAll(Type... types);

    @Delete
    void delete(Type type);
}
