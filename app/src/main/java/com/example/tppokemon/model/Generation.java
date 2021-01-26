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
            case "generation-i": this.name = "Gen 1"; break;
            case "generation-ii" : this.name = "Gen 2"; break;
            case "generation-iii" : this.name = "Gen 3"; break;
            case "generation-iv" : this.name = "Gen 4"; break;
            case "generation-v" : this.name = "Gen 5"; break;
            case "generation-vi" : this.name = "Gen 6"; break;
            case "generation-vii" : this.name = "Gen 7"; break;
            case "generation-viii" : this.name = "Gen 8"; break;
            default: this.name="Gen 1";
        }
        return this.name;

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
