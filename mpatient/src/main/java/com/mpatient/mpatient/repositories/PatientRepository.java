package com.mpatient.mpatient.repositories;

import com.mpatient.mpatient.entity.PatientMO;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<PatientMO, Long> {

    public PatientMO findById(long patientID);
    
    PatientMO findByFirstnameAndLastname(String firstname, String lastname); 
      
}
