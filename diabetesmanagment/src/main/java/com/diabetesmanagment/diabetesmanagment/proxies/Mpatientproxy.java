package com.diabetesmanagment.diabetesmanagment.proxies;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;

/**
 * Feign client interface for interacting with the Patient service.
 * This interface defines methods to retrieve patient information.
 */
@FeignClient(name = "mpatients", url = "localhost:9001")
public interface Mpatientproxy {
	
	/**
	 * Retrieves patient information by first name and last name from the Patient service.
	 *
	 * @param firstname The first name of the patient.
	 * @param lastname  The last name of the patient.
	 * @return A PatientBean object representing the patient information.
	 */
	  @GetMapping("/PatientRecord/patient/{firstname}/{lastname}")
	  PatientBean getPatientInfo(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname);	  
	
}
