package com.diabetesmanagment.diabetesmanagment.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;
import com.diabetesmanagment.diabetesmanagment.proxies.Mpatientproxy;
import com.diabetesmanagment.diabetesmanagment.service.PatientService;

/**
 * Implementation of the PatientService interface providing methods to interact with patient data.
 */
@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	Mpatientproxy mpatientproxy;

	@Autowired
	VerificationServiceImpl verificationService;

	/**
     * Finds a patient by their first name and last name.
     *
     * @param firstname The first name of the patient.
     * @param lastname  The last name of the patient.
     * @return The PatientBean object representing the patient.
     */
	public PatientBean findPatient(String firstname, String lastname) {
		return mpatientproxy.getPatientInfo(firstname, lastname);
	}

	/**
     * Checks if the patient is feminine and older than a specified age.
     *
     * @param patient    The PatientBean object representing the patient.
     * @param ageToCheck The age to check against.
     * @return True if the patient is feminine and older than the specified age, otherwise false.
     */
	public Boolean ifGenderfeminineAndMoreAgeChecker(PatientBean patient, int ageToCheck) {
		if (verificationService.ageChecker(patient.getBirthDay(), ageToCheck).equals(true) && patient.getGender().equals("F")) {
			return true;
		}
		return false;
	}

	/**
     * Checks if the patient is feminine and younger than a specified age.
     *
     * @param patient    The PatientBean object representing the patient.
     * @param ageToCheck The age to check against.
     * @return True if the patient is feminine and younger than the specified age, otherwise false.
     */
	public Boolean ifGenderfeminineAndLessAgeChecker(PatientBean patient, int ageToCheck) {
		if (verificationService.ageChecker(patient.getBirthDay(), ageToCheck).equals(false) && patient.getGender().equals("F")) {
			return true;
		}
		return false;
	}

	/**
     * Checks if the patient is masculine and older than a specified age.
     *
     * @param patient    The PatientBean object representing the patient.
     * @param ageToCheck The age to check against.
     * @return True if the patient is masculine and older than the specified age, otherwise false.
     */
	public Boolean ifGendermasculineAndMoreAgeChecker(PatientBean patient, int ageToCheck) {
		if (verificationService.ageChecker(patient.getBirthDay(), ageToCheck).equals(true) && patient.getGender().equals("M")) {
			return true;
		}
		return false;
	}

	 /**
     * Checks if the patient is masculine and younger than a specified age.
     *
     * @param patient    The PatientBean object representing the patient.
     * @param ageToCheck The age to check against.
     * @return True if the patient is masculine and younger than the specified age, otherwise false.
     */
	public Boolean ifGendermasculineAndLessAgeChecker(PatientBean patient, int ageToCheck) {
		if (verificationService.ageChecker(patient.getBirthDay(), ageToCheck).equals(false) && patient.getGender().equals("M")) {
			return true;
		}
		return false;
	}

}
