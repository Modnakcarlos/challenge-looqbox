package com.desafio_tecnico.pokeapi.service.impl;

import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import com.desafio_tecnico.pokeapi.service.PokemonFilterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonFilterServiceImpl implements PokemonFilterService {

    /**
     * Filtra a lista de Pokémon por uma query (insensível a maiúsculas/minúsculas).
     */
    @Override
    public List<PokemonResult> filterByQuery(List<PokemonResult> pokemons, String query) {
        if (query == null || query.isEmpty()) {
            return pokemons;
        }
        String lowerCaseQuery = query.toLowerCase();
        List<PokemonResult> filtered = new ArrayList<>();
        for (PokemonResult pokemon : pokemons) {
            if (pokemon.getName().toLowerCase().contains(lowerCaseQuery)) {
                filtered.add(pokemon);
            }
        }
        return filtered;
    }
}
