package com.example.tppokemon.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "Pokemon",
        foreignKeys = @ForeignKey(entity = ListPokemon.class, parentColumns = "id", childColumns = "List_Pokemon_fk"),
        indices = {@Index(value = {"id"}, unique = true),@Index(value = {"List_Pokemon_fk"})})
public class Pokemon {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;


    private String url;


    @ColumnInfo(name = "List_Pokemon_fk")
    private int listpokemonfk ;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getListpokemonfk() { return listpokemonfk; }

    public void setListpokemonfk(int listpokemonfk) { this.listpokemonfk = listpokemonfk; }
}
