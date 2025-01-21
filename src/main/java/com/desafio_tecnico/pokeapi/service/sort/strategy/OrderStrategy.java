package com.desafio_tecnico.pokeapi.service.sort.strategy;

import com.desafio_tecnico.pokeapi.dto.PokemonResult;

public interface OrderStrategy {
    boolean compare(PokemonResult left, PokemonResult right);
}
