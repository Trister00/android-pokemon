package com.example.tppokemon.model;

import java.util.List;

public class PokemonDetails {
    private int id;
    private String name;
    private int height;
    private int weight;
    private List<PokemonType> types;

    public PokemonDetails(int id, String name, int height, int weight, List<PokemonType> types) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.types = types;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonType> types) {
        this.types = types;
    }
}
