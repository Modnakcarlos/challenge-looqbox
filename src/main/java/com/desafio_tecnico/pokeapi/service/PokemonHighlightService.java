package com.desafio_tecnico.pokeapi.service;

import com.desafio_tecnico.pokeapi.dto.PokemonResponse;

import java.util.List;

public interface PokemonHighlightService {
    List<PokemonResponse> getHighlightedResponses(String query, String sort);
}
