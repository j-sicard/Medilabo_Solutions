package com.mpatient.mpatient.business.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpatient.mpatient.business.UserBusiness;
import com.mpatient.mpatient.entity.UserMO;
import com.mpatient.mpatient.service.UserService;

/**
 * Implementation of the UserBusiness interface that handles business logic related to user operations.
 */
@Service
public class UserBusinessImpl implements UserBusiness {

	@Autowired
	UserService userService;

	private static final Logger logger = Logger.getLogger(UserBusinessImpl.class.getName());

	 /**
     * Retrieves a user by username.
     *
     * @param username The username of the user to retrieve.
     * @return The user information.
     * @throws RuntimeException if an error occurs while fetching the user.
     */
	public UserMO getUser(String username) {
		try {
			UserMO user = userService.findByUsername(username);
			if (user != null) {
				logger.info("User : " + username + " found");
			} else {
				logger.info("User : " + username + " not found");
			}
			return user;
		} catch (Exception e) {
			logger.info("Error while fetching user with username: " + username);
			throw new RuntimeException("Failed to fetch user with username: " + username, e);
		}
	}
	
	/**
     * Retrieves the list of all users.
     *
     * @return List of all users.
     */
	public List<UserMO> getUsers(){
	    try {
	        List<UserMO> users = userService.findUsers();
	        if(users != null) {
	            logger.info("UserList : " + users.toString() + " found");
	        } else {
	            logger.info("No users found"); 
	        }
	        return users;
	    } catch(Exception e) {
	        logger.info("An error occurred while retrieving the list"); 
	        return null; 
	    }    
	}
	
	 /**
     * Saves a new user.
     *
     * @param user The user entity to save.
     */
	public void saveUser(UserMO user) {
		userService.saveUser(user);
	}

}
