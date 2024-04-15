package com.mpatient.mpatient.business.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpatient.mpatient.business.UserBusiness;
import com.mpatient.mpatient.entity.UserMO;
import com.mpatient.mpatient.service.UserService;

@Service
public class UserBusinessImpl implements UserBusiness {

	@Autowired
	UserService userService;

	private static final Logger logger = Logger.getLogger(UserBusinessImpl.class.getName());

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
	
	public void saveUser(UserMO user) {
		userService.saveUser(user);
	}

}
