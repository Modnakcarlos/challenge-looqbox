package com.desafio_tecnico.pokeapi.service;

import java.util.List;

public interface PokemonNameService {
    List<String> getFilteredAndSortedNames(String query, String sort);
}
