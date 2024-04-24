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

/**
 * REST Controller for CRUD operations on Patient entities.
 */
@RestController
@RequestMapping("/PatientRecord")
public class PatientController {

    @Autowired
    PatientBusiness patientBusiness;

    /**
     * Endpoint to retrieve patient information by first name and last name.
     *
     * @param firstname The first name of the patient.
     * @param lastname  The last name of the patient.
     * @return ResponseEntity containing the patient information or a notFound response if the patient is not found.
     */
    @GetMapping("/patient/{firstname}/{lastname}")
    public ResponseEntity<PatientMO> getPatientInfo(@PathVariable String firstname, @PathVariable String lastname) {
        try {
            PatientMO patient = patientBusiness.getPatientInfo(firstname, lastname);
            return ResponseEntity.ok(patient);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint to retrieve the list of all patients.
     *
     * @return ResponseEntity containing the list of all patients.
     */
    @GetMapping("/patients")
    public ResponseEntity<List<PatientMO>> getPatients() throws Exception {
        List<PatientMO> patients = patientBusiness.getPatients();
        return ResponseEntity.ok(patients);
    }

    /**
     * Deletes a patient by first name and last name.
     *
     * @param firstname The first name of the patient to delete.
     * @param lastname  The last name of the patient to delete.
     * @return ResponseEntity with a message indicating whether the deletion was successful or not.
     */
    @DeleteMapping("/delete/{firstname}/{lastname}")
    public ResponseEntity<String> deletePatientById(@PathVariable String firstname, @PathVariable String lastname) {
        try {
            patientBusiness.deleteProfilePatient(firstname, lastname);
            return ResponseEntity.ok("Patient successfully deleted");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Updates patient information.
     *
     * @param patientBO The patient business object containing the updated information.
     * @return ResponseEntity with a message indicating whether the update was successful or not.
     */
    @PutMapping("/patient/update")
    public ResponseEntity<String> updatePatientInfo(@RequestBody PatientBO patientBO) {
        try {
            patientBusiness.updatePatientInfo(patientBO);
            return ResponseEntity.ok("Patient information updated successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found.");
        }
    }

    /**
     * Creates a new patient record.
     *
     * @param patientMO The patient entity to create.
     * @return ResponseEntity with a message indicating whether the creation was successful or not.
     */
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
