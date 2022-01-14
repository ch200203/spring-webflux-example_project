package com.msa.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msa.sample.service.ExampleService;

import reactor.core.publisher.Flux;

@RestController
public class ExampleController {
	
	@Autowired
	ExampleService exampleService;
	
	@GetMapping("/example")
	public Flux getExample() {
		Flux examples = Flux.just(exampleService.getSampleExample1(),
		exampleService.getSampleExample2(),
		exampleService.getSampleExample3(),
		exampleService.getSampleExample4())
		.doOnNext(el -> System.out.println("getExample : " + el));
		
		return examples;
	}
}
