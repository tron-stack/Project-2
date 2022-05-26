package com.example.controllers;


import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.InvalidUsernameOrEmailException;
import com.example.models.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
public class UserController {

	private UserService us;

	@Autowired
	public UserController(UserService us) {
		this.us = us;
	}

	@PostMapping("/user")
	public ResponseEntity<Object> handleRegisterUser(@RequestBody LinkedHashMap<String, String> body){

		try {
			us.registerUser(body.get("username"), body.get("password"), body.get("firstName"), body.get("lastName"), body.get("email"));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Username or Email in use", HttpStatus.NOT_ACCEPTABLE);
		}


		return new ResponseEntity<>("User Registered", HttpStatus.ACCEPTED);
	}

	@PostMapping("/user/login")
	public ResponseEntity<Object> handleLogin(@RequestBody LinkedHashMap<String, String> body){

		String username = body.get("username");
		String password = body.get("password");

		try{
			return new ResponseEntity<>(us.loginUser(username,password), HttpStatus.ACCEPTED);
		} catch (InvalidCredentialsException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}
}
