package com.desafio_tecnico.pokeapi.service;

import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonSortService {

    /**
     * Ordena a lista de Pokémon com base no critério especificado.
     */
    public List<PokemonResult> sort(List<PokemonResult> pokemons, String sort) {
        if (pokemons.size() <= 1) {
            return pokemons;
        }

        int mid = pokemons.size() / 2;
        List<PokemonResult> left = sort(new ArrayList<>(pokemons.subList(0, mid)), sort);
        List<PokemonResult> right = sort(new ArrayList<>(pokemons.subList(mid, pokemons.size())), sort);

        return merge(left, right, sort);
    }

    private List<PokemonResult> merge(List<PokemonResult> left, List<PokemonResult> right, String sort) {
        List<PokemonResult> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            boolean condition;
            if ("length".equalsIgnoreCase(sort)) {
                condition = left.get(i).getName().length() <= right.get(j).getName().length();
            } else {
                condition = left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) <= 0;
            }

            if (condition) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i++));
        }

        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        return merged;
    }
}
