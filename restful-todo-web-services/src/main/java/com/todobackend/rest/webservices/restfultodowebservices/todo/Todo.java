package com.todobackend.rest.webservices.restfultodowebservices.todo;

import java.util.Date;

public class Todo {

	private long id;
	private String username;
	private String description;
	private Date targetDate;
	private boolean isDone;

	//default Constructor
	protected Todo() {
		
	}
	
	// Constructor
	public Todo(long id, String username, String description, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	// Getter for ID
	public long getId() {
		return id;
	}

	// Setter for ID
	public void setId(long id) {
		this.id = id;
	}

	// Getter for username
	public String getUsername() {
		return username;
	}

	// Setter for Username
	public void setUsername(String username) {
		this.username = username;
	}

	// Getter for Description
	public String getDescription() {
		return description;
	}

	// Setter for Description
	public void setDescription(String description) {
		this.description = description;
	}

	// Getter for Date
	public Date getTargetDate() {
		return targetDate;
	}

	// Setter for Date
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	// Getter for isDone
	public boolean isDone() {
		return isDone;
	}

	// Setter for isDone
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
