package com.example.tppokemon.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tppokemon.model.Family;
import com.example.tppokemon.model.Pokemon;
import com.example.tppokemon.model.PokemonDetails;
import com.example.tppokemon.model.PokemonEvolution;
import com.example.tppokemon.model.PokemonType;
import com.example.tppokemon.model.Type;


@Database(entities = {Pokemon.class}, version = 6, exportSchema = false)
public abstract class PokemonDatabase extends RoomDatabase {
    private static PokemonDatabase database;
    private static String DATABASE_NAME = "PokemonDB";

    public synchronized static PokemonDatabase getInstance(Context context) {
        if (database == null) {

            // when database is null
            // Initialize database
            database = Room.databaseBuilder(context.getApplicationContext(),
                    PokemonDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        // Return database
        return database;
    }


    public abstract PokemonDao pokemonDao();
    }
