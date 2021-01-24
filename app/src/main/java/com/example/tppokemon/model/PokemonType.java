package com.example.tppokemon.model;


import androidx.room.ColumnInfo;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;



@Entity(tableName = "PokemonType",
        foreignKeys = @ForeignKey(entity = PokemonDetails.class, parentColumns = "id", childColumns = "List_Details_fk"),
        indices = {@Index(value = {"id"}, unique = true),@Index(value = {"List_Details_fk"})})
public class PokemonType {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "slot")
    private int slot;

    @ColumnInfo(name = "type")

    @Ignore
    private Type type;



    @ColumnInfo(name = "List_Details_fk")
    private int listdetailsfk ;


    public PokemonType(int slot) {
        this.slot = slot;
    }
    public PokemonType(int slot, Type type) {
        this.slot = slot;
        this.type = type;
    }



    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getListdetailsfk() { return listdetailsfk; }

    public void setListdetailsfk(int listdetailsfk) { this.listdetailsfk = listdetailsfk; }
}
