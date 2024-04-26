package com.mfront.front.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mfront.front.beans.CommentBean;
import com.mfront.front.beans.PatientBean;
import com.mfront.front.proxies.Microservicesproxy;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

/**
 * Controller class for handling front-end requests related to patient management.
 */
@Controller
public class FrontController {

	@Autowired
	private Microservicesproxy microservicesproxy;


    /**
     * Handles GET requests to list all patients.
     * @param model the model to be populated with patient data
     * @return the name of the view template to be rendered
     */
	@GetMapping("/patient/list")
	  public String litsPatients(Model model)
	  {
		 List<PatientBean> patients =  microservicesproxy.listPatients();
		 model.addAttribute("patients", patients);		 
	      return "ListPatients";
	  }
	   
	 /**
     * Handles GET requests to display patient information.
     * @param firstname the first name of the patient
     * @param lastname the last name of the patient
     * @param model the model to be populated with patient information
     * @return the name of the view template to be rendered
     */
	@GetMapping("/patient/info/{firstname}/{lastname}")
	public String showPatientInfo(@PathVariable String firstname, @PathVariable String lastname, Model model) {    
	    PatientBean patient = microservicesproxy.patient(firstname, lastname); 	    
	    String risk = microservicesproxy.getRiskLevels(firstname, lastname);
	    List<CommentBean> comments = microservicesproxy.getAllCommentOfOnePatient(lastname);
	    model.addAttribute("patient", patient);
	    model.addAttribute("risk", risk); 
	    model.addAttribute("comments",  comments); 
	    return "PatientInfo";
	}
	

	 /**
     * Handles GET requests to display the form for adding a new patient.
     * @param model the model to be passed to the view template
     * @return the name of the view template to be rendered
     */
	@GetMapping("/patient/add")
	public String addPatient(Model model) {
		return "AddPatrient";
	}
	
	 /**
     * Handles POST requests to create a new patient.
     * @param patientBean the patient data to be added
     * @return a ResponseEntity indicating the success or failure of the operation
     */
	@PostMapping("/patient/create")
	public ResponseEntity<String> createPatient(@RequestBody PatientBean patientBean) {
	    ResponseEntity<String> response = microservicesproxy.addPatient(patientBean);	    
	    return response;
	}
	
	  /**
     * Handles GET requests to display the form for updating patient information.
     * @param firstname the first name of the patient
     * @param lastname the last name of the patient
     * @param model the model to be populated with patient information
     * @return the name of the view template to be rendered
     */
	@GetMapping("/patient/update/{firstname}/{lastname}")
	public String updatePatient(@PathVariable String firstname, @PathVariable String lastname, Model model) {
	    // Récupérer les informations du patient
	    PatientBean patient = microservicesproxy.patient(firstname, lastname);

	    // Formater la date de naissance au format "yyyy-MM-dd"
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    String formattedBirthDay = dateFormat.format(patient.getBirthDay());

	    // Ajouter les informations du patient et la date formatée au modèle
	    model.addAttribute("patient", patient);
	    model.addAttribute("formattedBirthDay", formattedBirthDay);

	    return "UpdatePatient";
	}

	 /**
     * Handles PUT requests to update patient information.
     * @param patientBean the updated patient data
     * @return a ResponseEntity indicating the success or failure of the operation
     */
	@PutMapping("/patient/update/data")
	public ResponseEntity<String> updateDataPatient(@RequestBody PatientBean patientBean) {
		ResponseEntity<String> response = microservicesproxy.updatePatient(patientBean);
		return response;		
	}
		
	   /**
     * Handles POST requests to add a new comment.
     * @param commentBean the comment data to be added
     * @return a ResponseEntity indicating the success or failure of the operation
     */
	@PostMapping(value = "/comment/add/data")
    public ResponseEntity<String> addCommentData(@RequestBody CommentBean commentBean) {
        try {          
            microservicesproxy.postNewComment(commentBean);       
            return ResponseEntity.ok("Comment added successfully");
        } catch (Exception e) {          
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add comment: " + e.getMessage());
        }
    }
}
