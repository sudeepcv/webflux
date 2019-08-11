package com.webflux.webflux.controller;
import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
class FluxController{

    @GetMapping(value="/fluxtest",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> testFlux(){
        return Flux.just("string1","String2","string3").delayElements(Duration.ofSeconds(1));
    }

}