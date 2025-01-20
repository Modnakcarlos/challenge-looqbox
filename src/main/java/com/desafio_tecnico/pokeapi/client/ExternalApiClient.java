package com.desafio_tecnico.pokeapi.client;

import com.desafio_tecnico.pokeapi.dto.PokeApiResponse;
import com.desafio_tecnico.pokeapi.dto.PokemonResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
public class ExternalApiClient {

    private static final String POKE_API_URL = "https://pokeapi.co/api/v2/pokemon?limit=10000";

    private final RestTemplate restTemplate;

    public ExternalApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<PokemonResult> getAllPokemons() {
        return Objects.requireNonNull(restTemplate.getForObject(POKE_API_URL, PokeApiResponse.class))
                .getResults();
    }

}
