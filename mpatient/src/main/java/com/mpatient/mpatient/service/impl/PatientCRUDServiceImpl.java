package com.mpatient.mpatient.service.impl;

import com.mpatient.mpatient.businessmodel.PatientBO;
import com.mpatient.mpatient.entity.PatientMO;
import com.mpatient.mpatient.repositories.PatientRepository;
import com.mpatient.mpatient.service.PatientCRUDService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the PatientCRUDService interface.
 */
@Service
public class PatientCRUDServiceImpl implements PatientCRUDService {

	@Autowired
	PatientRepository patientRepository;

	/**
	 * Find a patient by their ID.
	 *
	 * @param patientID The ID of the patient to find.
	 * @return The patient with the specified ID.
	 * @throws EntityNotFoundException if no patient with the specified ID is found.
	 */
	public PatientMO FindPatientById(long patientID) {
		return patientRepository.findById(patientID);
	}

	/**
     * Find all patients.
     *
     * @return A list of all patients.
     */
	public List<PatientMO> FindPatients() {
		return (List<PatientMO>) patientRepository.findAll();
	}

	/**
     * Delete a patient by their ID.
     *
     * @param patientId The ID of the patient to delete.
     */
	public void DeleteById(long patientId) {
		patientRepository.deleteById(patientId);
	}

	/**
     * Update the information of a patient.
     *
     * @param patient   The patient entity to update.
     * @param patientBO The patient business object containing the updated information.
     */
	public void updatePatient(PatientMO patient, PatientBO patientBO) {

		if (patient != null && patientBO != null) {

			System.out.println("Log Service Patient: " + patientBO);

			if (patientBO.getAddress() != null) {
				patient.setAddress(patientBO.getAddress());
			}
			if (patientBO.getGender() != null) {
				patient.setGender(patientBO.getGender());
			}
			if (patientBO.getBirthDay() != null) {
				patient.setBirthDay(patientBO.getBirthDay());
			}
			if (patientBO.getPhoneNumber() != null) {
				patient.setPhoneNumber(patientBO.getPhoneNumber());
			}
			patientRepository.save(patient);
		} else {
			System.out.println("Erreur : patient or patientBO is null.");
		}
	}

	/**
     * Save a new patient.
     *
     * @param patientMO The patient entity to save.
     */
	public void SavePatient(PatientMO patientMO) {
		patientRepository.save(patientMO);
	}
}
