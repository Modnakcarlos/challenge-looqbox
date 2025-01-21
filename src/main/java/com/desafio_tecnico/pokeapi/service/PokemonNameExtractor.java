package com.desafio_tecnico.pokeapi.service;

import com.desafio_tecnico.pokeapi.dto.PokemonResult;

import java.util.List;

public interface PokemonNameExtractor {
    List<String> extractNames(List<PokemonResult> pokemons);
}
