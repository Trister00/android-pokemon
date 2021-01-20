package com.example.tppokemon.model;

import java.util.ArrayList;

public class ListGeneration {
    private int count;
    private String previous;
    private String next;
    private ArrayList<Generation> results;

    public  ListGeneration (int count, String previous, String next, ArrayList<Generation> results) {
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

    public ArrayList<Generation> getResults() {
        return results;
    }

    public void setResults(ArrayList<Generation> listGenerations) { this.results = listGenerations; }
}
