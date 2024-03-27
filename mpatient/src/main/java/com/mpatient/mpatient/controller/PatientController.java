package com.mpatient.mpatient.controller;


import com.mpatient.mpatient.business.PatientBusiness;
import com.mpatient.mpatient.businessmodel.PatientBO;
import com.mpatient.mpatient.entity.PatientMO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PatientRecord")
public class PatientController {

    @Autowired
    PatientBusiness patientBusiness;

    @GetMapping("/patient/{firstname}/{lastname}")
    public ResponseEntity<PatientMO> getPatientInfo(@PathVariable String firstname, @PathVariable String lastname) {
        try {
            PatientMO patient = patientBusiness.getPatientInfo(firstname, lastname);
            return ResponseEntity.ok(patient);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientMO>> getPatients() throws Exception {
        List<PatientMO> patients = patientBusiness.getPatients();
        return ResponseEntity.ok(patients);
    }


    @DeleteMapping("/delete/{firstname}/{lastname}")
    public ResponseEntity<String> deletePatientById(@PathVariable String firstname, @PathVariable String lastname) {
        try {
            patientBusiness.deleteProfilePatient(firstname, lastname);
            return ResponseEntity.ok("Patient successfully deleted");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/patient/{firstname}/{lastname}")
    public ResponseEntity<String> updatePatientInfo(@PathVariable String firstname, @PathVariable String lastname, @RequestBody PatientBO patientBO) {
        try {
            patientBusiness.updatePatientInfo(firstname, lastname, patientBO);
            return ResponseEntity.ok("Patient information updated successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found.");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPatient(@RequestBody PatientMO patientMO){
    	System.out.println(patientMO); 
        boolean created = patientBusiness.createProfilePatient(patientMO);
        if (created) {
            return ResponseEntity.ok("Patient created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Patient already exists");
        }
    }

}
