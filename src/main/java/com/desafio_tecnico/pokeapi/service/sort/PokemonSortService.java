package com.desafio_tecnico.pokeapi.service.sort;

import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import com.desafio_tecnico.pokeapi.service.sort.strategy.impl.AlphabeticalOrderStrategy;
import com.desafio_tecnico.pokeapi.service.sort.strategy.impl.LengthOrderStrategy;
import com.desafio_tecnico.pokeapi.service.sort.strategy.OrderStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonSortService {

    /**
     * Realiza a classificação dos Pokémon utilizando o algoritmo Merge Sort.
     *
     * @param pokemons Lista de Pokémon a ser classificada.
     * @param sort     Critério de ordenação: "length" (ordenação por tamanho do nome) ou "alphabetical" (ordem alfabética).
     * @return Lista classificada de Pokémon.
     */
    public List<PokemonResult> sort(List<PokemonResult> pokemons, String sort) {
        if (pokemons.size() <= 1) {
            return pokemons;
        }

        int mid = pokemons.size() / 2;
        OrderStrategy strategy = getOrderStrategy(sort);

        List<PokemonResult> left = sort(new ArrayList<>(pokemons.subList(0, mid)), sort);
        List<PokemonResult> right = sort(new ArrayList<>(pokemons.subList(mid, pokemons.size())), sort);

        return merge(left, right, strategy);
    }

    /**
     * Mescla duas listas classificadas em uma única lista ordenada com base na estratégia fornecida.
     *
     * @param left     Lista esquerda já ordenada.
     * @param right    Lista direita já ordenada.
     * @param strategy Estratégia de ordenação a ser utilizada.
     * @return Lista mesclada e ordenada.
     */
    private List<PokemonResult> merge(List<PokemonResult> left, List<PokemonResult> right, OrderStrategy strategy) {
        List<PokemonResult> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (strategy.compare(left.get(i), right.get(j))) {
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

    /**
     * Retorna a estratégia de ordenação com base no critério fornecido.
     *
     * @param sort Critério de ordenação: "length" ou "alphabetical".
     * @return Instância da estratégia correspondente.
     */
    private OrderStrategy getOrderStrategy(String sort) {
        if ("length".equalsIgnoreCase(sort)) {
            return new LengthOrderStrategy();
        }
        return new AlphabeticalOrderStrategy();
    }

}
