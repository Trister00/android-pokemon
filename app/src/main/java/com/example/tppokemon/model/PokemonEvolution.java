package com.example.tppokemon.model;

public class PokemonEvolution {
    private String number;
    private String name;
    private Family family;

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
}
