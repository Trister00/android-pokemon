package com.example.tppokemon.model;

public class GenerationBall {

    public int id;
    public  String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {

            switch(this.nom){
                case "generation-i": this.nom = "Gen 1"; break;
                case "generation-ii" : this.nom = "Gen 2"; break;
                case "generation-iii" : this.nom = "Gen 3"; break;
                case "generation-iv" : this.nom = "Gen 4"; break;
                case "generation-v" : this.nom = "Gen 5"; break;
                case "generation-vi" : this.nom = "Gen 6"; break;
                case "generation-vii" : this.nom = "Gen 7"; break;
                case "generation-viii" : this.nom = "Gen 8"; break;
                default: this.nom="Gen 1";
            }
            return this.nom;

    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
