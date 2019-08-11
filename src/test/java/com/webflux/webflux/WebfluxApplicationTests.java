package com.webflux.webflux;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebfluxApplicationTests {

	@Test
	public void contextLoads() {


       Flux<String> stringFlux= Flux.just("data","data2","data3").log();

       stringFlux.subscribe(System.out::println,(e)->{},()->{System.out.println("completed");});
	}

}
