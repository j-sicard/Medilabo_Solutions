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

@Service
public class PatientCRUDServiceImpl implements PatientCRUDService {

    @Autowired
    PatientRepository patientRepository;

    public PatientMO FindPatientById(long patientID){
        return patientRepository.findById(patientID);
    }

    public List<PatientMO> FindPatients(){
        return (List<PatientMO>) patientRepository.findAll();
    }

    public void DeleteById(long patientId){
        patientRepository.deleteById(patientId);
    }

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
            System.out.println("Erreur : patient or patientBO is null.");     }
    }




    public void SavePatient(PatientMO patientMO){
        patientRepository.save(patientMO);
    }
}
