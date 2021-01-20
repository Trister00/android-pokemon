package com.example.tppokemon.model;


import androidx.room.ColumnInfo;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "PokemonType")
public class PokemonType {

    @PrimaryKey(autoGenerate = true)
    private int identifier;
    @ColumnInfo(name = "slot")
    private int slot;

    @ColumnInfo(name = "type")
    @Ignore
    private Type type;



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
    public int getIdentifier() {
        return identifier;
    }
    public void setIdentifier(int ID) {
        this.identifier = ID;
    }
}
