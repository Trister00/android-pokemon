package com.example.tppokemon.model;

import java.util.ArrayList;

public class ListPokemon {
    private int count;
    private String previous;
    private String next;
    private ArrayList<Pokemon> results;

    public ListPokemon(int count, String previous, String next, ArrayList<Pokemon> results) {
        this.count = count;
        this.previous = previous;
        this.next = next;
        this.results = results;
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

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> listPokemons) {
        this.results = listPokemons;
    }
}
