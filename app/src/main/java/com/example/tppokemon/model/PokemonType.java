package com.example.tppokemon.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;


@Entity
public class PokemonType {

    @ColumnInfo(name = "slot")
    private int slot;

    @ColumnInfo(name = "type")
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
}
