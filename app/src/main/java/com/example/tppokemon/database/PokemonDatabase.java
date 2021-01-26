package com.example.tppokemon.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tppokemon.model.CountGeneration;
import com.example.tppokemon.model.Family;
import com.example.tppokemon.model.Generation;
import com.example.tppokemon.model.ListGeneration;
import com.example.tppokemon.model.ListPokemon;
import com.example.tppokemon.model.Pokemon;
import com.example.tppokemon.model.PokemonDetails;
import com.example.tppokemon.model.PokemonEvolution;
import com.example.tppokemon.model.PokemonType;
import com.example.tppokemon.model.Type;


@Database(entities = {Pokemon.class,Type.class,PokemonType.class,PokemonDetails.class, Family.class, PokemonEvolution.class, CountGeneration.class}, version = 4, exportSchema = false)
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

    public abstract CountGenerationDao countGenerationDao();
    public abstract FamilyDao familyDao();
    public abstract PokemonDao pokemonDao();
    public abstract PokemonDetailsDao pokemonDetailsDao();
    public abstract PokemonEvolutionDao pokemonEvolutionDao();
    public abstract PokemonTypeDao pokemonTypeDao();
    public abstract TypeDoa typeDoa();
    }
