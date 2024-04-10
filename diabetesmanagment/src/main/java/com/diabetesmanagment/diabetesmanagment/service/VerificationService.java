package com.diabetesmanagment.diabetesmanagment.service;

import java.time.LocalDate;

import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;

public interface VerificationService {

	public Boolean ageChecker(LocalDate  birthDate, int ageToCheck); 
	
	public Boolean forLevelRisqueNone(int occurenceCount); 
	
	public Boolean forLevelRisqueBorderline(int occurenceCount, Boolean ageChecker);

	public Boolean forLevelRisqueDanger(int occurenceCount, PatientBean patient, Boolean ageChecker);
	
	public Boolean forLevelRisqueEarlyOnset(int occurenceCount, PatientBean patient, Boolean ageChecker); 
	
}
