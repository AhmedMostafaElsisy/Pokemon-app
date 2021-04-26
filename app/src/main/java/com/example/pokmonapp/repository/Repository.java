package com.example.pokmonapp.repository;

import androidx.lifecycle.LiveData;

import com.example.pokmonapp.db.PokemonDao;
import com.example.pokmonapp.model.Pokemon;
import com.example.pokmonapp.model.PokemonResponse;
import com.example.pokmonapp.network.PokemonApiServes;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class Repository {

    private PokemonApiServes pokemonApiServes;
    private PokemonDao pokemonDao;

    @Inject
    public Repository(PokemonApiServes pokemonApiServes, PokemonDao pokemonDao) {
        this.pokemonApiServes = pokemonApiServes;
        this.pokemonDao = pokemonDao;
    }

    public Observable<PokemonResponse> getPokemon() {
        return pokemonApiServes.gePokemons();
    }

    public void insertPokemon(Pokemon pokemon) {
        pokemonDao.addPokemon(pokemon);
    }

    public void deletePokemon(String pokemonName) {
        pokemonDao.deletePokemon(pokemonName);
    }

    public LiveData<List<Pokemon>> getFavPokemon() {
        return pokemonDao.getPokemon();
    }

}
