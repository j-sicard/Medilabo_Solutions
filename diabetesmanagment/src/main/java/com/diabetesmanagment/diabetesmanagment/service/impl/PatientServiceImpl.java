package com.diabetesmanagment.diabetesmanagment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;
import com.diabetesmanagment.diabetesmanagment.proxies.Mpatientproxy;
import com.diabetesmanagment.diabetesmanagment.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	Mpatientproxy mpatientproxy;

	@Autowired
	VerificationServiceImpl utils;

	public PatientBean findPatient(String firstname, String lastname) {
		return mpatientproxy.getPatientInfo(firstname, lastname);
	}

	public Boolean ifGenderfeminineAndMoreAgeChecker(PatientBean patient, int ageToCheck) {
		if (utils.ageChecker(patient.getBirthDay(), ageToCheck).equals(true) && mpatientproxy
				.getPatientInfo(patient.getFirstname(), patient.getLastname()).getGender().equals("F")) {
			return true;
		}
		return false;
	}

	public Boolean ifGenderfeminineAndLessAgeChecker(PatientBean patient, int ageToCheck) {
		if (utils.ageChecker(patient.getBirthDay(), ageToCheck).equals(false) && mpatientproxy
				.getPatientInfo(patient.getFirstname(), patient.getLastname()).getGender().equals("F")) {
			return true;
		}
		return false;
	}

	public Boolean ifGendermasculineAndMoreAgeChecker(PatientBean patient, int ageToCheck) {
		if (utils.ageChecker(patient.getBirthDay(), ageToCheck).equals(true) && mpatientproxy
				.getPatientInfo(patient.getFirstname(), patient.getLastname()).getGender().equals("M")) {
			return true;
		}
		return false;
	}

	public Boolean ifGendermasculineAndLessAgeChecker(PatientBean patient, int ageToCheck) {
		if (utils.ageChecker(patient.getBirthDay(), ageToCheck).equals(false) && mpatientproxy
				.getPatientInfo(patient.getFirstname(), patient.getLastname()).getGender().equals("M")) {
			return true;
		}
		return false;
	}

}
