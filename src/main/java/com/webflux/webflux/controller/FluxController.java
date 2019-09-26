package com.webflux.webflux.controller;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
class FluxController{

    @GetMapping(value="/",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> testFlux(){
        return Flux.just("string1","String2","string3").delayElements(Duration.ofSeconds(1));
    }

    @GetMapping(value="/generate",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> testFluxGenerate(){


Flux<String> flux = Flux.generate(
    AtomicLong::new,
      (state, sink) -> {
      long i = state.getAndIncrement();
      sink.next("3 x " + i + " = " + 3*i);
      if (i == 10) sink.complete();
      return state;
    }, (state) -> System.out.println("state: " + state));


    return flux;



    }
}