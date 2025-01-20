package com.desafio_tecnico.pokeapi.service;

import com.desafio_tecnico.pokeapi.client.ExternalApiClient;
import com.desafio_tecnico.pokeapi.dto.PokemonResponse;
import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    private final ExternalApiClient apiClient;
    private final PokemonFilterService filterService;
    private final PokemonSortService sortService;
    private final PokemonResponseFormatter responseFormatter;

    public PokemonService(ExternalApiClient apiClient,
                          PokemonFilterService filterService,
                          PokemonSortService sortService,
                          PokemonResponseFormatter responseFormatter) {
        this.apiClient = apiClient;
        this.filterService = filterService;
        this.sortService = sortService;
        this.responseFormatter = responseFormatter;
    }

    /**
     * Retorna todos os nomes dos pokémons com filtro e ordenação.
     */
    public List<String> getAllPokemonNames(String query, String sort) {
        List<PokemonResult> pokemons = apiClient.getAllPokemons();
        pokemons = filterService.filter(pokemons, query);
        pokemons = sortService.sort(pokemons, sort);
        return responseFormatter.extractNames(pokemons);
    }

    /**
     * Retorna os pokémons com nome e destaque.
     */
    public List<PokemonResponse> getHighlightedPokemonNames(String query, String sort) {
        List<PokemonResult> pokemons = apiClient.getAllPokemons();
        pokemons = filterService.filter(pokemons, query);
        pokemons = sortService.sort(pokemons, sort);
        return responseFormatter.formatWithHighlight(pokemons, query);
    }
}
