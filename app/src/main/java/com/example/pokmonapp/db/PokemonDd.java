package com.example.pokmonapp.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pokmonapp.model.Pokemon;

@Database(entities = {Pokemon.class}, version = 1)
public abstract class PokemonDd extends RoomDatabase {
    public abstract PokemonDao pokemonDao();

}
