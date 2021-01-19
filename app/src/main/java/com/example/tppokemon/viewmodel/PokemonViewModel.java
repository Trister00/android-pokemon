package com.example.tppokemon.viewmodel;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tppokemon.model.ListPokemon;
import com.example.tppokemon.model.Pokemon;
import com.example.tppokemon.model.PokemonDetails;
import com.example.tppokemon.repository.Repository;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PokemonViewModel extends ViewModel {
    private Repository repository;

    MutableLiveData<ArrayList<Pokemon>> pokemonList = new MutableLiveData<>();

    MutableLiveData<PokemonDetails> pokemonDetails = new MutableLiveData<>();

    @ViewModelInject
    public PokemonViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<ArrayList<Pokemon>> getPokemonList() {
        return pokemonList;
    }

    @SuppressLint("CheckResult")
    public void getPokemons(){
        repository.getPokemons().subscribeOn(Schedulers.io())
                .map(new Function<ListPokemon, ArrayList<Pokemon>>() {
                    @Override
                    public ArrayList<Pokemon> apply(ListPokemon listPokemon) throws Throwable {
                            ArrayList<Pokemon> list = listPokemon.getResults();
                            for(Pokemon pokemon : list){
                                String url = pokemon.getUrl();
                                String[] pokemonIndex = url.split("/");
                                pokemon.setUrl("https://pokeres.bastionbot.org/images/pokemon/"+
                                        pokemonIndex[pokemonIndex.length -1] + ".png");
                            }

                            return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> pokemonList.setValue(res),
                        err -> Log.e("ViewModel",err.getMessage()));
    }

    public void getPokemonDetails(String pokemonId){
        repository.getPokemonDetails(pokemonId).subscribeOn(Schedulers.io())
                .map(new Function<PokemonDetails, PokemonDetails>() {
                         @Override
                         public PokemonDetails apply(PokemonDetails pokemonDetails) throws Throwable {
                             return pokemonDetails;
                         }
                     }

                )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> pokemonDetails.setValue(res),
                        err -> Log.e("ViewModel",err.getMessage()));
    }

    public MutableLiveData<PokemonDetails> getPokemonDetails() {
        return pokemonDetails;
    }
}
