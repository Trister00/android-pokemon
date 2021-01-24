package com.example.tppokemon.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "Generation",
        foreignKeys = @ForeignKey(entity = ListGeneration.class, parentColumns = "id", childColumns = "List_Generation_fk"),
        indices = {@Index(value = {"id"}, unique = true),@Index(value = {"List_Generation_fk"})})
public class Generation {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "url")
    private String url;

    @ColumnInfo(name = "List_Generation_fk")
    private int listgenerationfk ;

    public Generation(String name, String url) {
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

    public int getListgenerationfk() { return listgenerationfk; }

    public void setListgenerationfk(int listgenerationfk) { this.listgenerationfk = listgenerationfk; }

}
