package com.desafio_tecnico.pokeapi.service.impl;

import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import com.desafio_tecnico.pokeapi.service.PokemonNameExtractor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonNameExtractorImpl implements PokemonNameExtractor {

    /**
     * Extrai apenas os nomes dos Pokémon.
     */
    @Override
    public List<String> extractNames(List<PokemonResult> pokemons) {
        List<String> names = new ArrayList<>();
        for (PokemonResult pokemon : pokemons) {
            names.add(pokemon.getName());
        }
        return names;
    }
}
