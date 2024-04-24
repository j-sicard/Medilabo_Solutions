package com.mcomment.mcommentpatient.service;

import java.util.List;

import com.mcomment.mcommentpatient.model.CommentPatientMO;

/**
 * Service interface for CRUD operations on comment patients.
 */
public interface CommentPatientCRUDService {
	
	public List<CommentPatientMO> getAllComment(); 
	
	public void addcomments(CommentPatientMO commentPatient); 
	
	public List<CommentPatientMO> getcommentsOfpatient(String patient); 

}
