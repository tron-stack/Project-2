package com.example.services;

import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.InvalidUsernameOrEmailException;
import com.example.models.User;
import com.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	private UserRepo ur;

	@Autowired
	public UserService(UserRepo ur) {
		this.ur = ur;
	}

	public void registerUser (String username, String password, String firstName, String lastName, String email){
		User register = new User(username, password, firstName, lastName, email);
		ur.save(register);
	}

	public User loginUser (String username, String password) {

		User loggedIn = ur.findUserByUsernameAndPassword(username,password);

		if(loggedIn == null){
			throw new InvalidCredentialsException();
		}

		return loggedIn;

	}
}
