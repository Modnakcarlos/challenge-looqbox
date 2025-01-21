package com.desafio_tecnico.pokeapi.controller;

import com.desafio_tecnico.pokeapi.dto.PokemonResponse;
import com.desafio_tecnico.pokeapi.service.impl.PokemonServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class PokemonController {

    private final PokemonServiceImpl pokemonServiceImpl;

    public PokemonController(PokemonServiceImpl pokemonServiceImpl) {
        this.pokemonServiceImpl = pokemonServiceImpl;
    }

    @GetMapping("/pokemons")
    public List<String> getPokemons(@RequestParam(required = false) String query,
                                    @RequestParam(required = false, defaultValue = "alphabetical") String sort) {
        return pokemonServiceImpl.getAllPokemonNames(query, sort);
    }
    @GetMapping("/pokemons/highlight")
    public List<PokemonResponse> getHighlightedPokemons(@RequestParam(required = false) String query,
                                                        @RequestParam(required = false, defaultValue = "alphabetical") String sort) {
        return pokemonServiceImpl.getHighlightedPokemonNames(query, sort);
    }
}
