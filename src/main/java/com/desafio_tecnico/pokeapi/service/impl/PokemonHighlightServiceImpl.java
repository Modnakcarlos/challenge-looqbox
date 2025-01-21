package com.desafio_tecnico.pokeapi.service.impl;

import com.desafio_tecnico.pokeapi.client.ExternalApiClient;
import com.desafio_tecnico.pokeapi.dto.PokemonResponse;
import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import com.desafio_tecnico.pokeapi.service.PokemonHighlightService;
import com.desafio_tecnico.pokeapi.service.sort.PokemonSortService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonHighlightServiceImpl implements PokemonHighlightService {

    private final ExternalApiClient apiClient;
    private final PokemonFilterServiceImpl filterService;
    private final PokemonSortService sortService;
    private final PokemonResponseFormatterImpl responseFormatter;

    public PokemonHighlightServiceImpl(ExternalApiClient apiClient,
                                       PokemonFilterServiceImpl filterService,
                                       PokemonSortService sortService,
                                       PokemonResponseFormatterImpl responseFormatter) {
        this.apiClient = apiClient;
        this.filterService = filterService;
        this.sortService = sortService;
        this.responseFormatter = responseFormatter;
    }

    @Override
    public List<PokemonResponse> getHighlightedResponses(String query, String sort) {
        List<PokemonResult> pokemons = apiClient.getAllPokemons();
        pokemons = filterService.filter(pokemons, query);
        pokemons = sortService.sort(pokemons, sort);
        return responseFormatter.formatWithHighlight(pokemons, query);
    }
}
