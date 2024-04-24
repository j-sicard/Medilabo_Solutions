package com.mcomment.mcommentpatient.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcomment.mcommentpatient.business.CommentBusinessService;
import com.mcomment.mcommentpatient.model.CommentPatientMO;
import com.mcomment.mcommentpatient.service.CommentPatientCRUDService;
import com.mcomment.mcommentpatient.service.CommentPatientService;

/**
 * Implementation of the CommentBusinessService interface.
 */
@Service
public class CommentBusinessImpl implements CommentBusinessService {

	@Autowired
	CommentPatientService commentPatientService;

	@Autowired
	CommentPatientCRUDService commentPatientCRUDService;

	 /**
     * Adds a new comment for an existing patient.
     * 
     * @param newCommentPatient The new comment to be added.
     */
	public void addNewCommentOfexistingPatient(CommentPatientMO newCommentPatient) {
		// Retrieve the patient ID using the patient's name
		String patIdValue = commentPatientService.getCommentPatIdByPatient(newCommentPatient.getPatient());
			
		// Create a new comment object with the patient ID, patient name, and note
		CommentPatientMO comment = new CommentPatientMO(patIdValue, newCommentPatient.getPatient(),
				newCommentPatient.getNote());
		
		// Add the new comment to the database
		commentPatientCRUDService.addcomments(comment);
	}
}
