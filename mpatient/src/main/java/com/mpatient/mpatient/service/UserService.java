package com.mpatient.mpatient.service;

import java.util.List;

import com.mpatient.mpatient.entity.UserMO;

/**
 * Service interface for user-related operations.
 */
public interface UserService {

	public UserMO findByUsername(String username); 
	
	public List<UserMO> findUsers(); 
	
	public void saveUser(UserMO user); 

	public boolean isValidUser(UserMO user);
}
