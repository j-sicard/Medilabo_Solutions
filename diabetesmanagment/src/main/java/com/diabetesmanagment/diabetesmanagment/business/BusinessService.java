package com.diabetesmanagment.diabetesmanagment.business;

import java.util.List;

import com.diabetesmanagment.diabetesmanagment.beans.CommentPatientBean;
import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;

public interface BusinessService {
	
	public List<String> getNotes(List<CommentPatientBean> listComment); 
	
	public List<CommentPatientBean> getAllNoteOffOnePatient(String patient);	
	
	public String getRiskLevels(String firstname, String lastname); 	

}
