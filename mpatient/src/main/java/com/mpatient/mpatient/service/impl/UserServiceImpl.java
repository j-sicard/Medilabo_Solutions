package com.mpatient.mpatient.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpatient.mpatient.entity.UserMO;
import com.mpatient.mpatient.repositories.UserRepository;
import com.mpatient.mpatient.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository; 
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

	public UserMO findByUsername(String username) {
		logger.info("User name: " + username);
		return userRepository.findByUsername(username); 
	}
	
	public List<UserMO> findUsers(){
		return userRepository.findAll(); 
	}
	
	public void saveUser(UserMO userMO) {
		 userRepository.save(userMO); 
	}
	
	public boolean isValidUser(UserMO user) {	
	    return user.getUsername() != null && !user.getUsername().isEmpty()
	            && user.getPassword() != null && !user.getPassword().isEmpty()
	            && user.getRole() != null && !user.getRole().isEmpty(); 
	}

}

