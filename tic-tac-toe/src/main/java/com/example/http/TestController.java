package com.example.http;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Mono;

@Controller("/api/http-test")
public class TestController {
    final private PokeClient pokeClient;

    public TestController(PokeClient pokeClient) {
        this.pokeClient = pokeClient;
    }

    @Get
    public Mono<MachineResponse> test() {
        return pokeClient.fetchMachine("1");
    }
}
