package com.todobackend.rest.webservices.restfultodowebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.todobackend.rest.webservices.restfultodowebservices.todo.Todo;

@RestController
@CrossOrigin(origins="http://localhost:4200")//
public class TodoResource {
	
	@Autowired
	private TodoHardcodedService todoService;
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoService.findAll();	
	}
	
	
	@GetMapping("/users/{username}/todos/{id}") // if the url here is wrong you may end up with a 405
	public Todo getTodo(@PathVariable String username, @PathVariable long id){
		System.out.println("get todo calle3d");
		return todoService.findById(id);	
	}
	
	//DELETE METHOD
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
		
		Todo todo = todoService.deleteById(id);// calling delete method
		if(todo!=null) {
			return ResponseEntity.noContent().build(); //returning no content back 
		}
		
		return ResponseEntity.notFound().build(); // returning not found
		
		//ResponseEntity allows us to set status to send back to front end	
	}
	
	//Edit/ Update todo
	//PUT /users/{username}/todos/{todoid}
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
		
		System.out.println("Put was called to update a todo");
		
		Todo todoUpdated = todoService.save(todo);
		
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
		
	}
	
	
	//Creat new
	//POST
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Void> newTodo(@PathVariable String username, @RequestBody Todo todo) {
		
		System.out.println("POST was called to create a todo");
		
		Todo createdTodo = todoService.save(todo);
		
		//Return the location of the new resource
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	

}
