package com.mpatient.mpatient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpatient.mpatient.entity.UserMO;

/**
 * Repository interface for accessing user data.
 */
public interface UserRepository extends JpaRepository<UserMO, Long> {

	   /**
     * Find a user by their username.
     *
     * @param username The username of the user to find.
     * @return The user with the specified username, or null if not found.
     */
	public UserMO findByUsername(String username); 
}
