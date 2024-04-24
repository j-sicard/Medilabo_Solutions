package com.mpatient.mpatient.business;

import java.util.List;

import com.mpatient.mpatient.entity.UserMO;

/**
 * Interface defining the business logic for user operations.
 */
public interface UserBusiness {

	public UserMO getUser(String username); 
	
	public List<UserMO> getUsers(); 
	
	public void saveUser(UserMO user); 
	
}
