package com.desafio_tecnico.pokeapi.service.impl;

import com.desafio_tecnico.pokeapi.client.ExternalApiClient;
import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import com.desafio_tecnico.pokeapi.service.PokemonFilterService;
import com.desafio_tecnico.pokeapi.service.PokemonNameExtractor;
import com.desafio_tecnico.pokeapi.service.PokemonNameService;
import com.desafio_tecnico.pokeapi.service.sort.PokemonSortService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonNameServiceImpl implements PokemonNameService {

    private final ExternalApiClient apiClient;
    private final PokemonFilterService filterService;
    private final PokemonSortService sortService;
    private final PokemonNameExtractor nameExtractor;

    public PokemonNameServiceImpl(ExternalApiClient apiClient,
                                  PokemonFilterService filterService,
                                  PokemonSortService sortService,
                                  PokemonNameExtractor nameExtractor) {
        this.apiClient = apiClient;
        this.filterService = filterService;
        this.sortService = sortService;
        this.nameExtractor = nameExtractor;
    }

    @Override
    public List<String> getFilteredAndSortedNames(String query, String sort) {
        List<PokemonResult> pokemons = apiClient.getAllPokemons();
        pokemons = filterService.filterByQuery(pokemons, query);
        pokemons = sortService.sort(pokemons, sort);
        return nameExtractor.extractNames(pokemons);
    }
}
