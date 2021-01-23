package com.example.tppokemon.di;

import com.example.tppokemon.http.IPokemonEvolutionsService;
import com.example.tppokemon.http.IPokemonService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class RetrofitModule {

    @Provides
    @Singleton
    @Named("pokemon")
    public static IPokemonService providePokemonService(){
        return new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(IPokemonService.class);
    }

    @Provides
    @Singleton
    @Named("evolution")
    public static IPokemonEvolutionsService providePokemonEvolutionsService(){
        return new Retrofit.Builder()
                .baseUrl("https://pokeapi.glitch.me/v1/pokemon/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(IPokemonEvolutionsService .class);
    }
}
