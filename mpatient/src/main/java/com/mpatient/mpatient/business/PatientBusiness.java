package com.mpatient.mpatient.business;

import com.mpatient.mpatient.businessmodel.PatientBO;
import com.mpatient.mpatient.entity.PatientMO;

import java.util.List;

/**
 * Interface defining the business logic for patient operations.
 */
public interface PatientBusiness {

	public PatientMO getPatientInfo(String firstname, String lastname);

	public List<PatientMO> getPatients();

	public boolean createProfilePatient(PatientMO patientMO);

	public void deleteProfilePatient(String firstname, String lastname);

	public void updatePatientInfo(PatientBO patientBO);
}
