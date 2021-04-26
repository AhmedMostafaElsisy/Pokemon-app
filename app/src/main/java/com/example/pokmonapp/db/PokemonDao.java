package com.example.pokmonapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pokmonapp.model.Pokemon;

import java.util.List;

@Dao
public interface PokemonDao {

    @Insert
    void addPokemon(Pokemon pokemon);

    @Query("delete From fav_table where name = :pokemonName")
    void deletePokemon(String pokemonName);

    @Query("select * from fav_table")
    public LiveData<List<Pokemon>> getPokemon();
}
