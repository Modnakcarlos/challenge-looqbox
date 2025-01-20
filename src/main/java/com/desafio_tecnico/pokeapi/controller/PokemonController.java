package com.desafio_tecnico.pokeapi.controller;

import com.desafio_tecnico.pokeapi.dto.PokemonResponse;
import com.desafio_tecnico.pokeapi.service.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemons")
    public List<String> getPokemons(@RequestParam(required = false) String query,
                                    @RequestParam(required = false, defaultValue = "alphabetical") String sort) {
        return pokemonService.getAllPokemonNames(query, sort);
    }
    @GetMapping("/pokemons/highlight")
    public List<PokemonResponse> getHighlightedPokemons(@RequestParam(required = false) String query,
                                                        @RequestParam(required = false, defaultValue = "alphabetical") String sort) {
        return pokemonService.getHighlightedPokemonNames(query, sort);
    }
}
