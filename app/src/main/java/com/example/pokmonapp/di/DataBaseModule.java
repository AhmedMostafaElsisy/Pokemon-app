package com.example.pokmonapp.di;

import android.app.Application;

import androidx.room.Room;

import com.example.pokmonapp.db.PokemonDao;
import com.example.pokmonapp.db.PokemonDd;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn({ApplicationComponent.class})
public class DataBaseModule {
    @Provides
    @Singleton
    public static PokemonDd provideDB(Application application) {
        return Room.databaseBuilder(application, PokemonDd.class, "fav_DB")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    public static PokemonDao provideDao(PokemonDd pokemonDd) {
        return pokemonDd.pokemonDao();
    }
}
