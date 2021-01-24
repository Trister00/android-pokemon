package com.example.tppokemon.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.tppokemon.TypeConverterString;

import java.util.List;
@Entity(tableName = "Family",
        foreignKeys = @ForeignKey(entity = PokemonEvolution.class, parentColumns = "id", childColumns = "List_Evolution_fk"),
        indices = {@Index(value = {"id"}, unique = true),@Index(value = {"List_Evolution_fk"})})
public class Family {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    private int evolutionStage;
    @TypeConverters(TypeConverterString.class)
    private List<String> evolutionLine;
    @ColumnInfo(name = "List_Evolution_fk")
    private int listevolutionfk ;

    public Family(int id, int evolutionStage, List<String> evolutionLine) {
        this.id = id;
        this.evolutionStage = evolutionStage;
        this.evolutionLine = evolutionLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvolutionStage() {
        return evolutionStage;
    }

    public void setEvolutionStage(int evolutionStage) {
        this.evolutionStage = evolutionStage;
    }

    public List<String> getEvolutionLine() {
        return evolutionLine;
    }

    public void setEvolutionLine(List<String> evolutionLine) {
        this.evolutionLine = evolutionLine;
    }

    public int getListevolutionfk() { return listevolutionfk; }

    public void setListevolutionfk(int listevolutionfk) { this.listevolutionfk = listevolutionfk; }
}
