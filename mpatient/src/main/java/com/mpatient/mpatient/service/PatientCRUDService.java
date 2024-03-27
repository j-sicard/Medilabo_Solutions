package com.mpatient.mpatient.service;

import com.mpatient.mpatient.businessmodel.PatientBO;
import com.mpatient.mpatient.entity.PatientMO;

import java.util.List;

public interface PatientCRUDService {

    public PatientMO FindPatientById(long patientID);

    public List<PatientMO> FindPatients();

    public void DeleteById(long patientId);

    public void SavePatient(PatientMO patientMO);

    public void updatePatientByid(long patientId, PatientBO patientBO);
}
