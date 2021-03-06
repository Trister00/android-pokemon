package com.example.tppokemon.viewmodel;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tppokemon.model.ListPokemon;
import com.example.tppokemon.model.Pokemon;
import com.example.tppokemon.model.PokemonDetails;
import com.example.tppokemon.model.PokemonEvolution;
import com.example.tppokemon.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PokemonViewModel extends ViewModel {
    private Repository repository;

    MutableLiveData<ArrayList<Pokemon>> pokemonList = new MutableLiveData<>();

    MutableLiveData<PokemonDetails> pokemonDetails = new MutableLiveData<>();

    MutableLiveData<List<PokemonEvolution>> pokemonEvolutions = new MutableLiveData<>();

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

    public @NonNull Observable<ArrayList<Pokemon>> getPokemonsByGeneration(int offset, int limit){
        return repository.getPokemonsByGeneration(offset, limit).subscribeOn(Schedulers.io())
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
                .observeOn(AndroidSchedulers.mainThread());
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

    public void getPokemonEvolutions(String pokemonId){
        repository.getPokemonEvolutions(pokemonId).subscribeOn(Schedulers.io())
                .map(new Function<List<PokemonEvolution>, List<PokemonEvolution>>() {
                    @Override
                    public List<PokemonEvolution> apply(List<PokemonEvolution> pokemonEvolutions) throws Throwable {
                        return pokemonEvolutions;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> pokemonEvolutions.setValue(res),
                        err -> Log.e("ViewModel",err.getMessage()));
    }

    public MutableLiveData<List<PokemonEvolution>> getPokemonEvolutions() {
        return pokemonEvolutions;
    }


    public @NonNull Observable<PokemonDetails> getPokemonDetailsId(String pokemonId){
        return repository.getPokemonDetails(pokemonId).subscribeOn(Schedulers.io())
                .map(new Function<PokemonDetails, PokemonDetails>() {
                         @Override
                         public PokemonDetails apply(PokemonDetails pokemonDetails) throws Throwable {
                             return pokemonDetails;
                         }
                     }

                )
                .observeOn(AndroidSchedulers.mainThread());
    }
}
