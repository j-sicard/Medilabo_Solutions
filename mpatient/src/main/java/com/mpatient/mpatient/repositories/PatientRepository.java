package com.mpatient.mpatient.repositories;

import com.mpatient.mpatient.entity.PatientMO;

import org.springframework.data.repository.CrudRepository;


/**
 * Repository interface for accessing patient data.
 */
public interface PatientRepository extends CrudRepository<PatientMO, Long> {

	/**
     * Find a patient by their ID.
     *
     * @param patientID The ID of the patient to find.
     * @return The patient with the specified ID, or null if not found.
     */
    public PatientMO findById(long patientID);
    
    /**
     * Find a patient by their first name and last name.
     *
     * @param firstname The first name of the patient.
     * @param lastname  The last name of the patient.
     * @return The patient with the specified first name and last name, or null if not found.
     */
    PatientMO findByFirstnameAndLastname(String firstname, String lastname); 
      
}
