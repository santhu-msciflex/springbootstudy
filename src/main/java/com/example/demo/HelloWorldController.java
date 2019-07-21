package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World !";
	}
	
	@GetMapping("/hello-world/{name}")
	public String helloWorldParam(@PathVariable String name) {
		return String.format("Hello World !!! !, %s", name);
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorld helloWorldBean() {
		return new HelloWorld("Hello World ! Bean");
	}

}
