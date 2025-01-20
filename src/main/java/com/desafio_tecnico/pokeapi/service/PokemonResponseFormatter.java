package com.desafio_tecnico.pokeapi.service;

import com.desafio_tecnico.pokeapi.dto.PokemonResponse;
import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonResponseFormatter {

    /**
     * Extrai apenas os nomes dos Pokémon.
     */
    public List<String> extractNames(List<PokemonResult> pokemons) {
        List<String> names = new ArrayList<>();
        for (PokemonResult pokemon : pokemons) {
            names.add(pokemon.getName());
        }
        return names;
    }

    /**
     * Formata a lista de Pokémon com destaque para a query.
     */
    public List<PokemonResponse> formatWithHighlight(List<PokemonResult> pokemons, String query) {
        List<PokemonResponse> responses = new ArrayList<>();
        for (PokemonResult pokemon : pokemons) {
            String name = pokemon.getName();
            String highlight = (query != null && !query.isEmpty())
                    ? name.replaceAll("(?i)(" + query + ")", "<pre>$1</pre>")
                    : name;
            responses.add(new PokemonResponse(name, highlight));
        }
        return responses;
    }
}
