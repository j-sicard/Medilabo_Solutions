package com.diabetesmanagment.diabetesmanagment.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;
import com.diabetesmanagment.diabetesmanagment.service.VerificationService;

/**
 * Implementation of the VerificationService interface providing methods for age verification and risk level determination.
 */
@Service
public class VerificationServiceImpl implements VerificationService {
	
	private static final Logger logger = Logger.getLogger(VerificationServiceImpl.class.getName());

	/**
	 * Calculates the age based on the given birth date.
	 *
	 * @param birthDate The birth date of the patient.
	 * @return The age of the patient.
	 */
	public static int calculateAge(LocalDate birthDate) {
		LocalDate currentDate = LocalDate.now();
		Period period = Period.between(birthDate, currentDate);
		int age = period.getYears();
		logger.info("Age patient: " + age);
		return age;
	}

	/**
	 * Checks if the age of the patient is greater than or equal to the specified age.
	 *
	 * @param birthDate   The birth date of the patient.
	 * @param ageToCheck  The age to check against.
	 * @return True if the patient's age is greater than or equal to the specified age, otherwise false.
	 */
	public Boolean ageChecker(LocalDate birthDate, int ageToCheck) {
		if (VerificationServiceImpl.calculateAge(birthDate) >= ageToCheck) {
			logger.info("AgeChecker return TRUE");
			return true;
		}
		logger.info("AgeChecker return FALSE");
		return false;
	}

	/**
	 * Checks if the occurrence count is zero.
	 *
	 * @param occurenceCount The occurrence count.
	 * @return True if the occurrence count is zero, otherwise false.
	 */
	public Boolean forLevelRisqueNone(int occurenceCount) {
		if (occurenceCount == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if the occurrence count falls within the borderline risk level range.
	 *
	 * @param occurenceCount The occurrence count.
	 * @param ageChecker     The result of age checker.
	 * @return True if the occurrence count falls within the borderline risk level range and age checker is true, otherwise false.
	 */
	public Boolean forLevelRisqueBorderline(int occurenceCount, Boolean ageChecker) {
		if (ageChecker && occurenceCount >= 2 && occurenceCount <= 5) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if the occurrence count and age checker meet the danger risk level criteria.
	 *
	 * @param occurenceCount The occurrence count.
	 * @param patient        The patient.
	 * @param ageChecker     The result of age checker.
	 * @return True if the occurrence count and age checker meet the danger risk level criteria, otherwise false.
	 */
	public Boolean forLevelRisqueDanger(int occurenceCount, PatientBean patient, Boolean ageChecker) {
		if (!ageChecker) {
			if (patient.getGender().equals("H") && occurenceCount == 3) {
				return true;
			}
			if (patient.getGender().equals("F") && occurenceCount == 4) {
				return true;
			}			
		}
		if(ageChecker) {
			if (occurenceCount >= 6 && occurenceCount <= 7) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the occurrence count, patient gender, and age checker meet the early onset risk level criteria.
	 *
	 * @param occurenceCount The occurrence count.
	 * @param patient        The patient.
	 * @param ageChecker     The result of age checker.
	 * @return True if the occurrence count, patient gender, and age checker meet the early onset risk level criteria, otherwise false.
	 */
	public Boolean forLevelRisqueEarlyOnset(int occurenceCount, PatientBean patient, Boolean ageChecker) {
		if (!ageChecker) {
			if (patient.getGender().equals("H") && occurenceCount == 5) {
				return true;
			}
			if (patient.getGender().equals("F") && occurenceCount == 7) {
				return true;
			}	
			if (occurenceCount >= 8) {
				return true;
			}
		}
		return false;
	}
}
