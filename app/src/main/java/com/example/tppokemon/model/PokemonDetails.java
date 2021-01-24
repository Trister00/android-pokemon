package com.example.tppokemon.model;


import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "PokemonDetails")
public class PokemonDetails {


    @PrimaryKey(autoGenerate = true)
    private int ID;
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "height")
    private int height;

    @ColumnInfo(name = "weight")
    private int weight;


    @Ignore
    @ColumnInfo(name = "types")
    private ArrayList<PokemonType> types ;


    public PokemonDetails(String name, int height, int weight, ArrayList<PokemonType> types) {}
    public PokemonDetails(int id, String name, int height, int weight, List<PokemonType> types) {

        this.name = name;
        this.height = height;
        this.weight = weight;
        this.types = (ArrayList<PokemonType>) types;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArrayList<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<PokemonType> types) {
        this.types = types;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
}
