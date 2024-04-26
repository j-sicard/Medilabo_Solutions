package com.diabetesmanagment.diabetesmanagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diabetesmanagment.diabetesmanagment.beans.CommentPatientBean;
import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;
import com.diabetesmanagment.diabetesmanagment.business.BusinessService;
import com.diabetesmanagment.diabetesmanagment.proxies.McommentProxy;
import com.diabetesmanagment.diabetesmanagment.proxies.Mpatientproxy;
import com.diabetesmanagment.diabetesmanagment.service.CommentService;
import com.diabetesmanagment.diabetesmanagment.service.PatientService;

/**
 * REST Controller for handling comment-related endpoints.
 */
@RestController
public class CommentController {

	@Autowired
	BusinessService businessService;

	  /**
     * Endpoint to retrieve all comments of a specific patient.
     *
     * @param patient The patient's name.
     * @return A list of comments associated with the patient.
     */
	@GetMapping(value = "/patient/comment/{patient}")
	public List<String> getAllCommentOfOnePatient(@PathVariable String patient) {
		return businessService.getNotes(businessService.getAllNoteOffOnePatient(patient));
	}

	  /**
     * Endpoint to check the risk levels for a given patient based on age and comment occurrences.
     *
     * @param firstname The first name of the patient.
     * @param lastname  The last name of the patient.
     * @return The risk level for the patient.
     */
	@GetMapping("/check/{firstname}/{lastname}")
	public String getRiskLevels(@PathVariable String firstname, @PathVariable String lastname) {
		Boolean agechecker = businessService.ageChecker(businessService.getPatientInfo(firstname, lastname));
		int occurenceCount = businessService.occurenceCount(businessService
				.mergeNotes(businessService.getNotes(businessService.getAllCommentForOnePatient(firstname))));
		PatientBean patient = businessService.getPatientInfo(firstname, lastname);

		return businessService.getRiskLevels(agechecker, occurenceCount, patient);
	}	

}
