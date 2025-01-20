package com.desafio_tecnico.pokeapi.dto;

public class PokemonResponse {

    private String name;
    private String highlight;

    public PokemonResponse(String name, String highlight) {
        this.name = name;
        this.highlight = highlight;
    }

    public String getName() {
        return name;
    }

    public String getHighlight() {
        return highlight;
    }
}
