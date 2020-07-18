package com.todobackend.rest.webservices.restfultodowebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TodoHardcodedService {
	
	private static List<Todo> todos = new ArrayList();
	private static int idCounter = 0;
	static {
		todos.add(new Todo(++idCounter, "Rozzy", "Find Amira", new Date(), false));
		todos.add(new Todo(++idCounter, "Rozzy", "Find Arya", new Date(), false));
		todos.add(new Todo(++idCounter, "Rozzy", "Find Daken", new Date(), false));
	}
	
	public List<Todo> findAll() {
		return todos;
	}
	
	public Todo save(Todo todo) {
		System.out.println(todo.getId());
		System.out.println(todo.getDescription());
		if(todo.getId()==-1 || todo.getId()==0) {// adds a new todo and increments counter
			todo.setId(++idCounter);
			todos.add(todo);
			System.out.println("A new Todo is being added");
		} else {
			deleteById(todo.getId());// update deletes then replaces / kind of a short cut
			todos.add(todo);
			System.out.println("Todo has been updated by deleting the old one and replaceing it");
		}
		return todo;
	}
	
	public Todo deleteById(long id) {
		Todo todo= findById(id);
		
		if(todo==null) return null; // can we find the todo
		
		if(todos.remove(todo)) { //can we delete it?
			return todo;
		}
		
		return null;
	}

	public Todo findById(long id) {
		// TODO Auto-generated method stub
		for(Todo todo:todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}

}
