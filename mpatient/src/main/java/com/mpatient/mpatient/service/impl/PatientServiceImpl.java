package com.mpatient.mpatient.service.impl;

import com.mpatient.mpatient.businessmodel.PatientBO;
import com.mpatient.mpatient.entity.PatientMO;
import com.mpatient.mpatient.repositories.PatientRepository;
import com.mpatient.mpatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Implementation of the PatientService interface.
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;


    /**
     * Get the ID of a patient by their first name and last name.
     *
     * @param firstName The first name of the patient.
     * @param lastName  The last name of the patient.
     * @return The ID of the patient, or null if not found.
     */
    public Long getIdByNames(String firstName, String lastName) {
        Optional<PatientMO> matchingPatient = StreamSupport.stream(patientRepository.findAll().spliterator(), false)
                .filter(patient -> patient.getFirstname().equals(firstName) && patient.getLastname().equals(lastName))
                .findFirst();

        return matchingPatient.map(PatientMO::getPatientID).orElse(null);
    }

    /**
     * Check if a patient exists by their first name and last name.
     *
     * @param firstName The first name of the patient.
     * @param lastName  The last name of the patient.
     * @return True if the patient exists, false otherwise.
     */
    public boolean patientExists(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            return false;       }
        
        return StreamSupport.stream(patientRepository.findAll().spliterator(), false)
                .anyMatch(patient -> 
                    firstName.equals(patient.getFirstname()) && lastName.equals(patient.getLastname())
                );
    }
    
    /**
     * Get a patient by their first name and last name.
     *
     * @param patientBO The patient business object containing the first name and last name.
     * @return The patient matching the given first name and last name.
     */
    public PatientMO getPatientByName(PatientBO patientBO) {
    	return patientRepository.findByFirstnameAndLastname(patientBO.getFirstname(), patientBO.getLastname()); 
    }
}
