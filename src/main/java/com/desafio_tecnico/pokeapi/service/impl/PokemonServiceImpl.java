package com.desafio_tecnico.pokeapi.service.impl;

import com.desafio_tecnico.pokeapi.dto.PokemonResponse;
import com.desafio_tecnico.pokeapi.service.PokemonHighlightService;
import com.desafio_tecnico.pokeapi.service.PokemonNameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl {

    private final PokemonNameService nameService;
    private final PokemonHighlightService highlightService;

    public PokemonServiceImpl(PokemonNameService nameService, PokemonHighlightService highlightService) {
        this.nameService = nameService;
        this.highlightService = highlightService;
    }

    public List<String> getAllPokemonNames(String query, String sort) {
        return nameService.getFilteredAndSortedNames(query, sort);
    }

    public List<PokemonResponse> getHighlightedPokemonNames(String query, String sort) {
        return highlightService.getHighlightedResponses(query, sort);
    }
}
