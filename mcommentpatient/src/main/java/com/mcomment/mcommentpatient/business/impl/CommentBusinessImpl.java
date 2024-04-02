package com.mcomment.mcommentpatient.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcomment.mcommentpatient.business.CommentBusinessService;
import com.mcomment.mcommentpatient.model.CommentPatientMO;
import com.mcomment.mcommentpatient.service.CommentPatientCRUDService;
import com.mcomment.mcommentpatient.service.CommentPatientService;

@Service
public class CommentBusinessImpl implements CommentBusinessService {

	@Autowired
	CommentPatientService commentPatientService;

	@Autowired
	CommentPatientCRUDService commentPatientCRUDService;

	public void addNewCommentOfexistingPatient(CommentPatientMO newCommentPatient) {
		String patIdValue = commentPatientService.getCommentPatIdByPatient(newCommentPatient.getPatient());
			
		CommentPatientMO comment = new CommentPatientMO(patIdValue, newCommentPatient.getPatient(),
				newCommentPatient.getNote());
		
		commentPatientCRUDService.addcomments(comment);
	}
}
