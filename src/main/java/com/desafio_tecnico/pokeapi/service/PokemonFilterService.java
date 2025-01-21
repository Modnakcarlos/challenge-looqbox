package com.desafio_tecnico.pokeapi.service;

import com.desafio_tecnico.pokeapi.dto.PokemonResult;

import java.util.List;

public interface PokemonFilterService {
    List<PokemonResult> filterByQuery(List<PokemonResult> pokemons, String query);
}
