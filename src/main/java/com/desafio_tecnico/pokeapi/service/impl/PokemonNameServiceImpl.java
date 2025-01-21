package com.desafio_tecnico.pokeapi.service.impl;

import com.desafio_tecnico.pokeapi.client.ExternalApiClient;
import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import com.desafio_tecnico.pokeapi.service.PokemonNameExtractor;
import com.desafio_tecnico.pokeapi.service.PokemonNameService;
import com.desafio_tecnico.pokeapi.service.sort.impl.PokemonSortServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonNameServiceImpl implements PokemonNameService {

    private final ExternalApiClient apiClient;
    private final PokemonFilterServiceImpl filterService;
    private final PokemonSortServiceImpl sortService;
    private final PokemonNameExtractor nameExtractor;

    public PokemonNameServiceImpl(ExternalApiClient apiClient,
                                  PokemonFilterServiceImpl filterService,
                                  PokemonSortServiceImpl sortService,
                                  PokemonNameExtractor nameExtractor) {
        this.apiClient = apiClient;
        this.filterService = filterService;
        this.sortService = sortService;
        this.nameExtractor = nameExtractor;
    }

    @Override
    public List<String> getFilteredAndSortedNames(String query, String sort) {
        List<PokemonResult> pokemons = apiClient.getAllPokemons();
        pokemons = filterService.filter(pokemons, query);
        pokemons = sortService.sort(pokemons, sort);
        return nameExtractor.extractNames(pokemons);
    }
}
