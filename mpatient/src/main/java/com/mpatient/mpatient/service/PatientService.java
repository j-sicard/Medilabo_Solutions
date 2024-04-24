package com.mpatient.mpatient.service;

import com.mpatient.mpatient.businessmodel.PatientBO;
import com.mpatient.mpatient.entity.PatientMO;

/**
 * Service interface for operations related to patients.
 */
public interface PatientService {

    public Long getIdByNames(String firstName, String lastName);    
    
    public boolean patientExists(String firstName, String lastName);
    
    public PatientMO getPatientByName(PatientBO patientBO); 

}
