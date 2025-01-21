package com.desafio_tecnico.pokeapi.service.impl;

import com.desafio_tecnico.pokeapi.dto.PokemonResponse;
import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import com.desafio_tecnico.pokeapi.service.PokemonResponseFormatter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonResponseFormatterImpl implements PokemonResponseFormatter {

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
