package com.example.tppokemon.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;



public class Generation {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "url")
    private String url;



    public Generation(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        switch(this.name){
            case "generation-i": return "Gen 1";
            case "generation-ii" : return "Gen 2";
            case "generation-iii" : return "Gen 3";
            case "generation-iv" : return"Gen 4";
            case "generation-v" : return "Gen 5";
            case "generation-vi" : return "Gen 6";
            case "generation-vii" : return "Gen 7";
            case "generation-viii" : return "Gen 8";
            default:  return "Gen 1";
        }

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

    @Override
    public String toString() {
        return "Generation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
