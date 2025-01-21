package com.desafio_tecnico.pokeapi.service.impl;

import com.desafio_tecnico.pokeapi.client.ExternalApiClient;
import com.desafio_tecnico.pokeapi.dto.PokemonResponse;
import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import com.desafio_tecnico.pokeapi.service.PokemonFilterService;
import com.desafio_tecnico.pokeapi.service.PokemonHighlightService;
import com.desafio_tecnico.pokeapi.service.PokemonResponseFormatter;
import com.desafio_tecnico.pokeapi.service.sort.PokemonSortService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonHighlightServiceImpl implements PokemonHighlightService {

    private final ExternalApiClient apiClient;
    private final PokemonFilterService filterService;
    private final PokemonSortService sortService;
    private final PokemonResponseFormatter responseFormatter;

    public PokemonHighlightServiceImpl(ExternalApiClient apiClient,
                                       PokemonFilterService filterService,
                                       PokemonSortService sortService,
                                       PokemonResponseFormatter responseFormatter) {
        this.apiClient = apiClient;
        this.filterService = filterService;
        this.sortService = sortService;
        this.responseFormatter = responseFormatter;
    }

    @Override
    public List<PokemonResponse> getHighlightedResponses(String query, String sort) {
        List<PokemonResult> pokemons = apiClient.getAllPokemons();
        pokemons = filterService.filterByQuery(pokemons, query);
        pokemons = sortService.sort(pokemons, sort);
        return responseFormatter.formatWithHighlight(pokemons, query);
    }
}
