package com.desafio_tecnico.pokeapi.service;

import com.desafio_tecnico.pokeapi.dto.PokemonResponse;
import com.desafio_tecnico.pokeapi.dto.PokemonResult;

import java.util.List;

public interface PokemonResponseFormatter {
    List<PokemonResponse> formatWithHighlight(List<PokemonResult> pokemons, String query);
}
