package com.example.tppokemon.model;

import java.util.ArrayList;

public class ListPokemon {
    private int count;
    private String previous;
    private String next;
    private ArrayList<Pokemon> listPokemons;

    public ListPokemon(int count, String previous, String next, ArrayList<Pokemon> listPokemons) {
        this.count = count;
        this.previous = previous;
        this.next = next;
        this.listPokemons = listPokemons;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public ArrayList<Pokemon> getListPokemons() {
        return listPokemons;
    }

    public void setListPokemons(ArrayList<Pokemon> listPokemons) {
        this.listPokemons = listPokemons;
    }
}
