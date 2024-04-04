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

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentPatientCRUDService commentPatientCRUDService;

	@Autowired
	CommentPatientService commentPatientService;
	
	@Autowired
	CommentBusinessService commentBusinessService; 

	@GetMapping(value = "/list")
	public List<CommentPatientMO> getAllComments() {
		return commentPatientCRUDService.getAllComment();
	}

	@PostMapping(value = "/insert")
	public void instertcomment(@RequestBody CommentPatientMO commentPatientMO) {
		commentPatientCRUDService.addcomments(commentPatientMO);
	}

	@GetMapping(value = "/patID/{patient}")
	public String getPatIdByPatient(@PathVariable String patient) {
		return commentPatientService.getCommentPatIdByPatient(patient);
	}
		
	@PostMapping(value = "new")
	public void addNewCommentOfexistingPatient(@RequestBody CommentPatientMO newCommentPatient) {
		commentBusinessService.addNewCommentOfexistingPatient(newCommentPatient);
	}
	
	@GetMapping(value = "/patient/comment/{patient}")
	public List<CommentPatientMO> getAllCommentOfOnePatient(@PathVariable String patient){
		return commentPatientCRUDService.getcommentsOfpatient(patient);
	}
}
