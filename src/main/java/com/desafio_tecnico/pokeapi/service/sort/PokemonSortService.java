package com.desafio_tecnico.pokeapi.service.sort;

import com.desafio_tecnico.pokeapi.dto.PokemonResult;

import java.util.List;

public interface PokemonSortService {
    List<PokemonResult> sort(List<PokemonResult> pokemons, String sort);
}
