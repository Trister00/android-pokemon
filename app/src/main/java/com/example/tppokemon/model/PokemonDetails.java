package com.example.tppokemon.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.ArrayList;



@Entity(tableName = "PokemonDetails" , indices = {@Index(value = {"id"}, unique = true)})
public class PokemonDetails {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    private String name;

    private int height;

    private int weight;

    @Ignore
    private ArrayList<PokemonType> types ;


    public PokemonDetails(String name, int height, int weight, ArrayList<PokemonType> types) {}

    public PokemonDetails(int id, String name, int height, int weight) {

        this.name = name;
        this.height = height;
        this.weight = weight;
    }
    public PokemonDetails(int id, String name, int height, int weight, ArrayList<PokemonType> types) {

        this.name = name;
        this.height = height;
        this.weight = weight;
        this.types =  types;
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
