package com.companyname.apistuff;

/**
 * Created by David on 5/20/2016.
 */
public class PokemonColor {

    private int id;
    private String name;
    private Name aName;
    private PokemonSpecies pokemonSpecies;

    public PokemonColor(int id, String name, Name aName, PokemonSpecies pokemonSpecies) {
        this.id = id;
        this.name = name;
        this.aName = aName;
        this.pokemonSpecies = pokemonSpecies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Name getaName() {
        return aName;
    }

    public void setaName(Name aName) {
        this.aName = aName;
    }

    public PokemonSpecies getPokemonSpecies() {
        return pokemonSpecies;
    }

    public void setPokemonSpecies(PokemonSpecies pokemonSpecies) {
        this.pokemonSpecies = pokemonSpecies;
    }

    @Override
    public String toString() {
        return "Testing";
    }
}
