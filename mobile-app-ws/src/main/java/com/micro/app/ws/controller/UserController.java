package com.micro.app.ws.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro.app.ws.exception.UserServiceException;
import com.micro.app.ws.impl.UserService;
import com.micro.app.ws.model.UserDetails;
import com.micro.app.ws.request.mapper.UserRequest;

@RestController
@RequestMapping("/users") // http://localhost:8080/user
public class UserController {

	// for store temporally
	Map<String, UserDetails> users;

	@Autowired
	UserService userService;

	// Path @param
	@GetMapping(path = "/{userId}")
	public ResponseEntity<UserDetails> getUser(@PathVariable String userId) {
		if (users.containsKey(userId))
			return new ResponseEntity<UserDetails>(users.get(userId), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// Query @param -- Using Pagination
	@GetMapping
	public String getUsers(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit) {
		return "getUser method was called : Page " + page + "Limit " + limit;
	}

	// Query @param -- Using optional parameter
	@GetMapping(path = "/optional")
	public String getUsersByLimitOptional(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "getUsers method was called : Page " + page + "Limit " + limit + "sort " + sort;
	}

	@GetMapping(path = "details/{userId}")
	public UserDetails getUserDetails(@PathVariable int userId) {
		UserDetails details = new UserDetails("Robert", "Jenifer", "Admin", "1");
		return details;
	}

	@GetMapping(path = "/users1")
	public ResponseEntity<UserDetails> getUserResponse() {
		UserDetails details = new UserDetails("Robert", "Jenifer", "Admin", "1");
		return new ResponseEntity<UserDetails>(details, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserDetails> createUser(@RequestBody UserRequest userRequest) {
		UserDetails details = userService.createUser(userRequest);
		return new ResponseEntity<UserDetails>(details, HttpStatus.OK);
	}

	@PostMapping(path = "/validuser")
	public ResponseEntity<UserDetails> createValidUser(@Valid @RequestBody UserRequest userRequest) {
		UserDetails details = new UserDetails(userRequest.getFirstName(), userRequest.getLastName(),
				userRequest.getEmail(), "");
		return new ResponseEntity<UserDetails>(details, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}")
	public UserDetails UserDetails(@PathVariable String userId, @RequestBody UserRequest userRequest) {

		UserDetails user = users.get(userId);
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setRole(userRequest.getEmail());

		users.put(userId, user);

		return user;
	}

	@DeleteMapping(path = "/{id}")
	public UserDetails deleteUser(@PathVariable String id) {
		String firstName = null;
		System.out.println(firstName.length());
		return users.remove(id);

	}

	@DeleteMapping(path = "user/{id}")
	public UserDetails deleteUserById(@PathVariable String id) {
		String firstName = null;
		if (firstName == null)
			throw new UserServiceException("Exception are throwed by User Service");
		return users.remove(id);

	}
}
