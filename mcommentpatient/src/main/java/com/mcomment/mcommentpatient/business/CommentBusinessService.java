package com.mcomment.mcommentpatient.business;

import com.mcomment.mcommentpatient.model.CommentPatientMO;

/**
 * Interface for managing comment-related business operations.
 */
public interface CommentBusinessService {

	public void addNewCommentOfexistingPatient(CommentPatientMO newCommentPatient); 
}
