package com.diabetesmanagment.diabetesmanagment.business;

import java.util.List;

import com.diabetesmanagment.diabetesmanagment.beans.CommentPatientBean;
import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;

/**
 * Interface defining business operations for managing diabetes management system.
 */
public interface BusinessService {
	
	public List<String> getNotes(List<CommentPatientBean> listComment); 
	
	public List<CommentPatientBean> getAllNoteOffOnePatient(String patient);	
	
	public String getRiskLevels(Boolean agechecker, int occurenceCount, PatientBean patient);
	
	public int occurenceCount(String note); 
	
	public String mergeNotes(List<String> listNote);
	
	public List<CommentPatientBean> getAllCommentForOnePatient(String firstname); 
	
	public PatientBean getPatientInfo(String firstname, String lastname); 
	
	public Boolean ageChecker(PatientBean patient); 

}
