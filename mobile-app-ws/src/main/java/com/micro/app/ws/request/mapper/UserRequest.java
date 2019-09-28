package com.micro.app.ws.request.mapper;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserRequest {
	@NotNull
	private String firstName;
	
	@NotNull(message = "last name required")
	private String lastName;
	
	@NotNull
	@Email
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
