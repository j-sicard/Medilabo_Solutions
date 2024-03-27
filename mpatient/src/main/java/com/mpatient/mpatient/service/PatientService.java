package com.mpatient.mpatient.service;

public interface PatientService {

    public Long getIdByNames(String firstName, String lastName);
    public boolean patientExists(String firstName, String lastName);

}
