package com.todobackend.rest.webservices.restfultodowebservices.todo.basic.auth;

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
public class BasicAuthenticationController {
	

	//
	@GetMapping(path="/basicauth")
	public AuthenticationBean helloWorldBean() {
		return new AuthenticationBean("You are authenticated");
	}

}
