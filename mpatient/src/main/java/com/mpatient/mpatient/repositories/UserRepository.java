package com.mpatient.mpatient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpatient.mpatient.entity.UserMO;

public interface UserRepository extends JpaRepository<UserMO, Long> {

	public UserMO findByUsername(String username); 
}
