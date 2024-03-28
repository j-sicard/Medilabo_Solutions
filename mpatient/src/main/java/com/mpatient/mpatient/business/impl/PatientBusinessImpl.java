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

@Service
public class PatientBusinessImpl implements PatientBusiness {
    @Autowired
    PatientCRUDService patientCRUDService;
    @Autowired
    PatientService patientService;

    public PatientMO getPatientInfo(String firstname, String lastname) throws EntityNotFoundException {
        Long patientId = patientService.getIdByNames(firstname, lastname);
        if (patientId != null) {
            return patientCRUDService.FindPatientById(patientId);
        } else {
            throw new EntityNotFoundException("Patient not found with firstname: " + firstname + " and lastname: " + lastname);
        }
    }


    public List<PatientMO> getPatients(){
        return patientCRUDService.FindPatients();
    }

    public boolean createProfilePatient(PatientMO patientMO){
        if (patientService.patientExists(patientMO.getFirstname(), patientMO.getLastname())) {
            return false;
        } else {
            patientCRUDService.SavePatient(patientMO);
            return true;
        }
    }    


    public void deleteProfilePatient(String firstname, String lastname){
        patientCRUDService.DeleteById(patientService.getIdByNames(firstname, lastname));
    }

    public void updatePatientInfo(PatientBO patientBO){  	
    	patientCRUDService.updatePatient(patientService.getPatientByName(patientBO), patientBO);        
    }
}
