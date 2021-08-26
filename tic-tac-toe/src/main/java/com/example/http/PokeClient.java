package com.example.http;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

import java.util.Map;

@Singleton
public class PokeClient {
    private final HttpClient httpClient;
    private final UriBuilder uri;

    public PokeClient(
        @Client("https://pokeapi.co/api/v2") HttpClient httpClient
    ) {
        this.httpClient = httpClient;
        this.uri = UriBuilder.of("/machine/{id}");
    }

    Mono<MachineResponse> fetchMachine(String id) {
        HttpRequest<?> req = HttpRequest.GET(uri.expand(Map.of("id", id)));

        return Mono.from(httpClient.retrieve(req, MachineResponse.class));
    }
}
