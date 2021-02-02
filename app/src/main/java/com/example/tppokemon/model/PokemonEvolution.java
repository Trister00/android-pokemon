package com.example.tppokemon.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;


public class PokemonEvolution {


    private int id ;
    private String number;
    private String name;
    private Family family;


    public PokemonEvolution(String number, String name) {
        this.number = number;
        this.name = name;
    }
    public PokemonEvolution(String number, String name, Family family) {
        this.number = number;
        this.name = name;
        this.family = family;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
