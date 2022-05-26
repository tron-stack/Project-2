package com.example.exceptions;

public class InvalidCredentialsException extends RuntimeException{
	public InvalidCredentialsException(){
		super("Username or Password Incorrect");
	}
}
