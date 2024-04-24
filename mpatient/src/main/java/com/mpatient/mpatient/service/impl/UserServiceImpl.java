package com.mpatient.mpatient.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpatient.mpatient.entity.UserMO;
import com.mpatient.mpatient.repositories.UserRepository;
import com.mpatient.mpatient.service.UserService;

/**
 * Implementation of the UserService interface.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository; 
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

	/**
     * Find a user by their username.
     *
     * @param username The username of the user to find.
     * @return The user with the specified username.
     */
	public UserMO findByUsername(String username) {
		logger.info("User name: " + username);
		return userRepository.findByUsername(username); 
	}
	
	/**
     * Find all users.
     *
     * @return A list of all users.
     */
	public List<UserMO> findUsers(){
		return userRepository.findAll(); 
	}
	
	 /**
     * Save a user.
     *
     * @param userMO The user to save.
     */
	public void saveUser(UserMO userMO) {
		 userRepository.save(userMO); 
	}
	
	/**
     * Check if a user is valid.
     *
     * @param user The user to validate.
     * @return True if the user is valid, false otherwise.
     */
	public boolean isValidUser(UserMO user) {	
	    return user.getUsername() != null && !user.getUsername().isEmpty()
	            && user.getPassword() != null && !user.getPassword().isEmpty()
	            && user.getRole() != null && !user.getRole().isEmpty(); 
	}

}

