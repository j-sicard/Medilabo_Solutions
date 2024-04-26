package com.diabetesmanagment.diabetesmanagment.proxies;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.diabetesmanagment.diabetesmanagment.beans.CommentPatientBean;
import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;

/**
 * Feign client interface for interacting with the Patient service.
 * This interface defines methods to retrieve patient information.
 */
@FeignClient( name = "api-gateway")
public interface Mpatientproxy {
	
	/**
	 * Retrieves patient information by first name and last name from the Patient service.
	 *
	 * @param firstname The first name of the patient.
	 * @param lastname  The last name of the patient.
	 * @return A PatientBean object representing the patient information.
	 */
	  @GetMapping("/MPATIENT/PatientRecord/patient/{firstname}/{lastname}")
	  PatientBean getPatientInfo(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname);	
	  	  
	  /**
		 * Retrieves all comments for a specific patient from the Comment service.
		 *
		 * @param patient The name of the patient.
		 * @return A list of CommentPatientBean objects representing the comments for the patient.
		 */
		@GetMapping(value = "/MCOMMENTPATIENT/comment/patient/comment/{patient}")
		public List<CommentPatientBean> findAllCommentOfOnePatient(@PathVariable String patient);
	
}
