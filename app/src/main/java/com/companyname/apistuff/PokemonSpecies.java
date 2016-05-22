package com.companyname.apistuff;

import java.net.URL;

/**
 * Created by David on 5/20/2016.
 */
public class PokemonSpecies {

    private String pokemonName;
    private URL url;

    public PokemonSpecies(String pokemonName, URL url) {
        this.pokemonName = pokemonName;
        this.url = url;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
