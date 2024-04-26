package com.mcomment.mcommentpatient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcomment.mcommentpatient.model.CommentPatientMO;
import com.mcomment.mcommentpatient.repository.CommentRepository;
import com.mcomment.mcommentpatient.service.CommentPatientCRUDService;

/**
 * Implementation of the CommentPatientCRUDService interface providing CRUD operations for CommentPatientMO objects.
 */
@Service
public class CommentPatientCRUDServiceImpl implements CommentPatientCRUDService{
	
	@Autowired
	CommentRepository commentRepository; 
	
    /**
     * Retrieves all comments.
     *
     * @return The list of all comments.
     */
	public List<CommentPatientMO> getAllComment(){
		return commentRepository.findAll(); 		
	}
	
	   /**
     * Adds a new comment.
     *
     * @param commentPatient The comment to be added.
     */
	public void addcomments(CommentPatientMO commentPatient) {
		commentRepository.insert(commentPatient);
	}
	
	 /**
     * Retrieves all comments associated with a specific patient.
     *
     * @param patient The name of the patient.
     * @return The list of comments associated with the patient.
     */
	public List<CommentPatientMO> getcommentsOfpatient(String patient){
		return commentRepository.findByPatient(patient); 
	}	
}
