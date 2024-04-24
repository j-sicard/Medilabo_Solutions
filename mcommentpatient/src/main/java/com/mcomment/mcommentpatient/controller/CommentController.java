package com.mcomment.mcommentpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.mcomment.mcommentpatient.business.CommentBusinessService;
import com.mcomment.mcommentpatient.model.CommentPatientMO;
import com.mcomment.mcommentpatient.service.CommentPatientCRUDService;
import com.mcomment.mcommentpatient.service.CommentPatientService;

/**
 * Controller class for managing comments.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentPatientCRUDService commentPatientCRUDService;

	@Autowired
	CommentPatientService commentPatientService;

	@Autowired
	CommentBusinessService commentBusinessService;

	/**
	 * Endpoint to add a new comment for an existing patient.
	 * 
	 * @param newCommentPatient The new comment to be added.
	 */
	@PostMapping(value = "new")
	public void addNewCommentOfexistingPatient(@RequestBody CommentPatientMO newCommentPatient) {
		commentBusinessService.addNewCommentOfexistingPatient(newCommentPatient);
	}

	/**
	 * Endpoint to retrieve all comments for a specific patient.
	 * 
	 * @param patient The name of the patient.
	 * @return A list of comments for the specified patient.
	 */
	@GetMapping(value = "/patient/comment/{patient}")
	public List<CommentPatientMO> getAllCommentOfOnePatient(@PathVariable String patient) {
		return commentPatientCRUDService.getcommentsOfpatient(patient);
	}
}
