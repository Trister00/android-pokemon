package com.example.tppokemon.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pokemon")
public class Pokemon {

    @PrimaryKey(autoGenerate = true)
    private int ID;
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "url")
    private String url;

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
