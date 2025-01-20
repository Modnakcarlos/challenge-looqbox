package com.desafio_tecnico.pokeapi.service;

import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonSortService {

    /**
     * Realiza a classificação dos Pokémon utilizando o algoritmo Merge Sort.
     * @param pokemons Lista de Pokémon a ser classificada.
     * @param sort Critério de ordenação: "length" (ordenação por tamanho do nome) ou "alphabetical" (ordem alfabética).
     * @return Lista classificada de Pokémon.
     */
    public List<PokemonResult> sort(List<PokemonResult> pokemons, String sort) {

        // Caso base: listas com 0 ou 1 elemento já estão ordenadas.
        if (pokemons.size() <= 1) {
            return pokemons;
        }

        // Divide a lista ao meio
        int mid = pokemons.size() / 2;
        List<PokemonResult> left = sort(new ArrayList<>(pokemons.subList(0, mid)), sort);
        List<PokemonResult> right = sort(new ArrayList<>(pokemons.subList(mid, pokemons.size())), sort);

        // Mescla as duas metades ordenadas.
        return merge(left, right, sort);
    }

    /**
     * Mescla duas listas classificadas em uma única lista ordenada.
     */
    private List<PokemonResult> merge(List<PokemonResult> left, List<PokemonResult> right, String sort) {
        List<PokemonResult> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Combina elementos de ambas as listas, seguindo o critério de ordenação.
        while (i < left.size() && j < right.size()) {
            boolean condition;
            if ("length".equalsIgnoreCase(sort)) {
                // Ordenação por comprimento do nome.
                condition = left.get(i).getName().length() <= right.get(j).getName().length();
            } else {
                // Ordenação alfabética (padrão).
                condition = left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) <= 0;
            }

            if (condition) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        // Adiciona os elementos restantes de cada lista.
        while (i < left.size()) {
            merged.add(left.get(i++));
        }

        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        return merged;
    }
}
