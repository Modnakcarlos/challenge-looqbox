package com.desafio_tecnico.pokeapi.service.sort.strategy.impl;

import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import com.desafio_tecnico.pokeapi.service.sort.strategy.OrderStrategy;

public class LengthOrderStrategy implements OrderStrategy {
    @Override
    public boolean compare(PokemonResult left, PokemonResult right) {
        return left.getName().length() <= right.getName().length();
    }
}
