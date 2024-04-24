package com.mpatient.mpatient.business.impl;

import com.mpatient.mpatient.business.PatientBusiness;
import com.mpatient.mpatient.businessmodel.PatientBO;
import com.mpatient.mpatient.entity.PatientMO;
import com.mpatient.mpatient.service.PatientCRUDService;
import com.mpatient.mpatient.service.PatientService;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * Implementation of the PatientBusiness interface that handles business logic related to patient operations.
 */
@Service
public class PatientBusinessImpl implements PatientBusiness {
	@Autowired
	PatientCRUDService patientCRUDService;
	@Autowired
	PatientService patientService;

	private static final Logger logger = Logger.getLogger(PatientBusinessImpl.class.getName());

	/**
     * Retrieves patient information by first name and last name.
     *
     * @param firstname The first name of the patient.
     * @param lastname  The last name of the patient.
     * @return The PatientMO object containing the patient information.
     * @throws EntityNotFoundException if the patient is not found.
     */
	public PatientMO getPatientInfo(String firstname, String lastname) throws EntityNotFoundException {
		Long patientId = patientService.getIdByNames(firstname, lastname);
		if (patientId != null) {
			return patientCRUDService.FindPatientById(patientId);
		} else {
			throw new EntityNotFoundException(
					"Patient not found with firstname: " + firstname + " and lastname: " + lastname);
		}
	}

	/**
     * Retrieves the list of all patients.
     *
     * @return List of PatientMO objects containing the patient information.
     */
	public List<PatientMO> getPatients() {
		return patientCRUDService.FindPatients();
	}

	/**
     * Creates a new patient profile.
     *
     * @param patientMO The PatientMO object representing the new patient profile.
     * @return true if the patient profile is created successfully, false otherwise.
     */
	public boolean createProfilePatient(PatientMO patientMO) {
		if (patientService.patientExists(patientMO.getFirstname(), patientMO.getLastname())) {
			return false;
		} else {
			patientCRUDService.SavePatient(patientMO);
			return true;
		}
	}

	/**
     * Deletes a patient profile by first name and last name.
     *
     * @param firstname The first name of the patient to be deleted.
     * @param lastname  The last name of the patient to be deleted.
     */
	public void deleteProfilePatient(String firstname, String lastname) {
		patientCRUDService.DeleteById(patientService.getIdByNames(firstname, lastname));
	}

	/**
     * Updates patient information.
     *
     * @param patientBO The PatientBO object containing the updated patient information.
     */
	public void updatePatientInfo(PatientBO patientBO) {
		patientCRUDService.updatePatient(patientService.getPatientByName(patientBO), patientBO);
	}

}
