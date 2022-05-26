package com.example.exceptions;

public class InvalidUsernameOrEmailException extends RuntimeException {
	public InvalidUsernameOrEmailException() {
		super("Username or Email is already in use");
	}
}