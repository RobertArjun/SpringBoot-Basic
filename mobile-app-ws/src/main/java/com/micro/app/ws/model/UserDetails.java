package com.micro.app.ws.model;

public class UserDetails {
	private String firstName;
	private String lastName;
	private String role;
	private String userId;

	public UserDetails(String firstName, String lastName, String role, String userId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.userId = userId;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
