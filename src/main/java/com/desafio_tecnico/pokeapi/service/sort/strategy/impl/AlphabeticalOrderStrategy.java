package com.desafio_tecnico.pokeapi.service.sort.strategy.impl;

import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import com.desafio_tecnico.pokeapi.service.sort.strategy.OrderStrategy;

public class AlphabeticalOrderStrategy implements OrderStrategy {
    @Override
    public boolean compare(PokemonResult left, PokemonResult right) {
        return left.getName().compareToIgnoreCase(right.getName()) <= 0;
    }
}
