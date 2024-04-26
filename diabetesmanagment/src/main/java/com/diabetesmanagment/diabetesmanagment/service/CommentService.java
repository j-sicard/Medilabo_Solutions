package com.diabetesmanagment.diabetesmanagment.service;

import java.util.List;

import com.diabetesmanagment.diabetesmanagment.beans.CommentPatientBean;

/**
 * Service interface for handling comments related to patients.
 */
public interface CommentService {

	public List<String> getNotes(List<CommentPatientBean> listComment);

	public  List<CommentPatientBean> getAllCommentForOnePatient (String Patient);	
	
	public String mergeNotes(List<String> notes);
	
	public int countUniqueTerms(String note, String[] termsToCheck); 

}
