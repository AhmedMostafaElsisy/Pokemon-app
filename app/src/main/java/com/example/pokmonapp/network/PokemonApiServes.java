package com.example.pokmonapp.network;


import com.example.pokmonapp.model.PokemonResponse;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokemonApiServes {

    @GET("pokemon")
    Observable<PokemonResponse> gePokemons();
}
