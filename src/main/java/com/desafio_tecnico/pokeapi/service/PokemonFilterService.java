package com.desafio_tecnico.pokeapi.service;

import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonFilterService {

    /**
     * Filtra a lista de Pokémon por uma query (insensível a maiúsculas/minúsculas).
     */
    public List<PokemonResult> filter(List<PokemonResult> pokemons, String query) {
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
