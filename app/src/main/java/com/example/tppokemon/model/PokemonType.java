package com.example.tppokemon.model;


import androidx.room.ColumnInfo;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;




public class PokemonType {


    private int id;

    private int slot;

    private Type type;





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


}
