package com.example.tppokemon.model;

import java.util.ArrayList;
import java.util.List;


import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "ListPokemon" , indices = {@Index(value = {"id"}, unique = true)})
public class ListPokemon {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    private int count;

    private String previous;

    private String next;


    @Ignore
    private ArrayList<Pokemon> results;


    public ListPokemon(int count, String previous, String next) {
        this.count = count;
        this.previous = previous;
        this.next = next;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }
}
