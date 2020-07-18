package com.todobackend.rest.webservices.restfultodowebservices.todo.hello.world;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Controller
//localhost:4200
@RestController// controller that can handle rest
@CrossOrigin(origins="http://localhost:4200")
public class HelloWorldController {
	
	//GET
	//URI - /hello-world
	//method - "Hello World"
	@GetMapping(path="/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	
	//
	@GetMapping(path="/helloworld-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping(path="/helloworld/path-variable/{name}")
	public HelloWorldBean helloWorldPathVar(@PathVariable String name) {
		//throw new RuntimeException("Something went wrong! AHHHHHHHHHH");
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
