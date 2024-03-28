package com.mpatient.mpatient.service.impl;

import com.mpatient.mpatient.businessmodel.PatientBO;
import com.mpatient.mpatient.entity.PatientMO;
import com.mpatient.mpatient.repositories.PatientRepository;
import com.mpatient.mpatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;


    public Long getIdByNames(String firstName, String lastName) {
        Optional<PatientMO> matchingPatient = StreamSupport.stream(patientRepository.findAll().spliterator(), false)
                .filter(patient -> patient.getFirstname().equals(firstName) && patient.getLastname().equals(lastName))
                .findFirst();

        return matchingPatient.map(PatientMO::getPatientID).orElse(null);
    }

    public boolean patientExists(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            return false;       }
        
        return StreamSupport.stream(patientRepository.findAll().spliterator(), false)
                .anyMatch(patient -> 
                    firstName.equals(patient.getFirstname()) && lastName.equals(patient.getLastname())
                );
    }
    
    public PatientMO getPatientByName(PatientBO patientBO) {
    	return patientRepository.findByFirstnameAndLastname(patientBO.getFirstname(), patientBO.getLastname()); 
    }
}
