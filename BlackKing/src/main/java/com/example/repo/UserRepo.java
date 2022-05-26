package com.example.repo;

import com.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findUserByEmail(String email);
	User findUserByUsernameAndPassword(String username, String password);
}
