package com.diabetesmanagment.diabetesmanagment.business.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diabetesmanagment.diabetesmanagment.beans.CommentPatientBean;
import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;
import com.diabetesmanagment.diabetesmanagment.business.BusinessService;
import com.diabetesmanagment.diabetesmanagment.service.CommentService;
import com.diabetesmanagment.diabetesmanagment.service.PatientService;
import com.diabetesmanagment.diabetesmanagment.service.VerificationService;
import com.diabetesmanagment.diabetesmanagment.service.impl.VerificationServiceImpl;

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
            "Hémoglobine A1C", "Microalbumine", "Taille", "Poids",
            "Fumeur", "Fumeuse", "Anormal", "Cholestérol", "Vertiges",
            "Rechute", "Réaction", "Anticorps"
        };
	
	
	public List<String> getNotes(List<CommentPatientBean> listComment) {
		return commentService.getNotes(listComment); 
	}
	
	public List<CommentPatientBean> getAllNoteOffOnePatient(String patient) {
		return commentService.getAllCommentForOnePatient(patient); 
	}


	public String getRiskLevels(String firstname, String lastname) {
		Boolean agechecker = verificationService.ageChecker(patientService.findPatient(firstname, lastname).getBirthDay(), agecheck);		
		int occurenceCount = commentService.countUniqueTerms(commentService.mergeNotes(commentService.getNotes(commentService.getAllCommentForOnePatient(firstname))), termsToCheck);		
		PatientBean patient = patientService.findPatient(firstname, lastname); 
		
		if(verificationService.forLevelRisqueNone(occurenceCount) == true) {
			return "None"; 
		}
		if(verificationService.forLevelRisqueBorderline(occurenceCount, agechecker) == true) {
			return "Bordeline"; 
		}
		if(verificationService.forLevelRisqueDanger(occurenceCount, patient, agechecker)) {
			return "Danger"; 
		}
		if(verificationService.forLevelRisqueEarlyOnset(occurenceCount, patient, agechecker) == true) {
			return "Early onset"; 
		}
		return "occurrence will be calculated soon";		
			
	}
		

}
