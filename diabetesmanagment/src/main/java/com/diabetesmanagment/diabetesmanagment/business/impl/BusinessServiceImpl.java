package com.diabetesmanagment.diabetesmanagment.business.impl;


import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diabetesmanagment.diabetesmanagment.beans.CommentPatientBean;
import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;
import com.diabetesmanagment.diabetesmanagment.business.BusinessService;
import com.diabetesmanagment.diabetesmanagment.service.CommentService;
import com.diabetesmanagment.diabetesmanagment.service.PatientService;
import com.diabetesmanagment.diabetesmanagment.service.VerificationService;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	PatientService patientService;

	@Autowired
	CommentService commentService;

	@Autowired
	VerificationService verificationService;

	final private int agecheck = 30;	
	
	String[] termsToCheck = {
            "Hémoglobine A1C","Hémoglobine", "Microalbumine", "Taille", "Poids",
            "Fumeur", "Fumeuse", "Anormal", "Anormale", "Anormales",  "Cholestérol", "Vertiges", "Vertige",
            "Rechute", "Réaction", "Anticorps"
        }; 
	
	private static final Logger logger = Logger.getLogger(BusinessServiceImpl.class.getName());
	
	
	public List<String> getNotes(List<CommentPatientBean> listComment) {
		return commentService.getNotes(listComment); 
	}
	
	public List<CommentPatientBean> getAllNoteOffOnePatient(String patient) {
		return commentService.getAllCommentForOnePatient(patient); 
	}

	
	public Boolean ageChecker(PatientBean patient) {
		return verificationService.ageChecker(patient.getBirthDay(), agecheck); 
	}
	
	
	public int occurenceCount(String note) {
		return commentService.countUniqueTerms( note, termsToCheck);
	}
	
	public String mergeNotes(List<String> listNote) {
		return commentService.mergeNotes(listNote); 
	}
	
	public List<CommentPatientBean> getAllCommentForOnePatient(String firstname) {
		return commentService.getAllCommentForOnePatient(firstname);
	}
	
	public PatientBean getPatientInfo(String firstname, String lastname) {
		return patientService.findPatient(firstname, lastname); 
	}
	

	public String getRiskLevels(Boolean agechecker, int occurenceCount, PatientBean patient) {	
		
		logger.info("Gender Patient : " + patient.getGender());
		
		if(verificationService.forLevelRisqueNone(occurenceCount) == true) {
			logger.info("Rish : None");			
			return "None"; 
		}
		if(verificationService.forLevelRisqueBorderline(occurenceCount, agechecker) == true) {
			logger.info("Rish : Bordeline");
			return "Bordeline"; 
		}
		if(verificationService.forLevelRisqueDanger(occurenceCount, patient, agechecker) == true) {
			logger.info("Rish : Danger");
			return "Danger"; 
		}
		if(verificationService.forLevelRisqueEarlyOnset(occurenceCount, patient, agechecker) == true) {
			logger.info("Rish : Early onset");
			return "Early onset"; 
		}
		logger.info("Rish : Outside the criterion of calculation");
		return "Outside the criterion of calculation";		
			
	}
		

}
