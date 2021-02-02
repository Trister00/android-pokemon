package com.example.tppokemon.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "Pokemon")
public class Pokemon {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;


    private String url;



    private String generation;


    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }
    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
