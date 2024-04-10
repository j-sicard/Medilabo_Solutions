package com.diabetesmanagment.diabetesmanagment.service.impl;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;
import com.diabetesmanagment.diabetesmanagment.service.VerificationService;

@Service
public class VerificationServiceImpl implements VerificationService {

	public static int calculateAge(LocalDate birthDate) {

		LocalDate currentDate = LocalDate.now();

		Period period = Period.between(birthDate, currentDate);

		int age = period.getYears();

		return age;

	}

	public Boolean ageChecker(LocalDate birthDate, int ageToCheck) {

		if (VerificationServiceImpl.calculateAge(birthDate) >= ageToCheck) {
			return true;
		}
		return false;
	}

	public Boolean forLevelRisqueNone(int occurenceCount) {
		if (occurenceCount == 0) {
			return true;
		}
		return false;
	}

	public Boolean forLevelRisqueBorderline(int occurenceCount, Boolean ageChecker) {
		if (ageChecker && occurenceCount >= 2 && occurenceCount <= 5) {
			return true;
		}
		return false;
	}

	public Boolean forLevelRisqueDanger(int occurenceCount, PatientBean patient, Boolean ageChecker) {
		if (!ageChecker) {
			if (patient.getGender().equals("H") && occurenceCount == 3) {
				return true;
			}
			if (patient.getGender().equals("F") && occurenceCount == 4) {
				return true;
			}		
			if (occurenceCount >= 6 && occurenceCount <= 7) {
				return true;
			}
		}
		return false;
	}

	public Boolean forLevelRisqueEarlyOnset(int occurenceCount, PatientBean patient, Boolean ageChecker) {
		if (!ageChecker) {
			if (patient.getGender().equals("H") && occurenceCount == 5) {
				return true;
			}
			if (patient.getGender().equals("F") && occurenceCount == 4) {
				return true;
			}
	
			if (occurenceCount >= 8) {
				return true;
			}
		}
		return false;
	}

}
