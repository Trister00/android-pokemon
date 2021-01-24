package com.example.tppokemon.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "Type",
        foreignKeys = @ForeignKey(entity = PokemonType.class, parentColumns = "id", childColumns = "List_Type_fk"),
        indices = {@Index(value = {"id"}, unique = true),@Index(value = {"List_Type_fk"})})
public class Type {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    private String name;


    private String url;
    @ColumnInfo(name = "List_Type_fk")
    private int listtypefk ;

    public Type(String name, String url) {
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

    public int getListtypefk() { return listtypefk; }

    public void setListtypefk(int listtypefk) { this.listtypefk = listtypefk; }
}

