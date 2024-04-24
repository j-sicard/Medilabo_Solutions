package com.mpatient.mpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mpatient.mpatient.business.UserBusiness;

import com.mpatient.mpatient.entity.UserMO;

import jakarta.persistence.EntityNotFoundException;

/**
 * REST Controller for managing user entities.
 */
@RestController
public class UserController {

	@Autowired
	UserBusiness userBusiness;

	  /**
     * Retrieves a user by username.
     *
     * @param username The username of the user to retrieve.
     * @return ResponseEntity containing the user information or a notFound response if the user is not found.
     */
	@GetMapping("/user/{username}")
	public ResponseEntity<UserMO> getUser(@PathVariable String username) {
		try {
			return ResponseEntity.ok(userBusiness.getUser(username));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	 /**
     * Retrieves the list of all users.
     *
     * @return List of all users.
     */
	@GetMapping("/user/users")
	public List<UserMO> getUsers() {
		try {
			return userBusiness.getUsers();
		} catch (EntityNotFoundException e) {
			return null;
		}
	}
	
	 /**
     * Saves a new user.
     *
     * @param user The user entity to save.
     */
	@PostMapping("/user/save")
	public void saveUser(@RequestBody UserMO user) {
		userBusiness.saveUser(user); 
	}

}
