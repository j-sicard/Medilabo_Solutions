package com.diabetesmanagment.diabetesmanagment.service;

import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;

/**
 * Service interface for handling patient-related operations.
 */
public interface PatientService {

	public PatientBean findPatient(String firstname, String lastname);

	public Boolean ifGenderfeminineAndMoreAgeChecker(PatientBean patient, int ageToCheck);

	public Boolean ifGenderfeminineAndLessAgeChecker(PatientBean patient, int ageToCheck);

	public Boolean ifGendermasculineAndMoreAgeChecker(PatientBean patient, int ageToCheck);

	public Boolean ifGendermasculineAndLessAgeChecker(PatientBean patient, int ageToCheck);
}
