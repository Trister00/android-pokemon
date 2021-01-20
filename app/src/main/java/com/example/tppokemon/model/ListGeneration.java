package com.example.tppokemon.model;


import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "ListGeneration")
public class ListGeneration {

    @PrimaryKey(autoGenerate = true)
    private int ID;
    @ColumnInfo(name = "count")
    private int count;

    @ColumnInfo(name = "previous")
    private String previous;

    @ColumnInfo(name = "next")
    private String next;

    @ColumnInfo(name = "results")
    @Ignore
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
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }


}
