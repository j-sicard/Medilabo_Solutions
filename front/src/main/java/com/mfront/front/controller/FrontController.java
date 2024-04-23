package com.mfront.front.controller;

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




@Controller
public class FrontController {

	@Autowired
	private Microservicesproxy microservicesproxy;

	
	@GetMapping("/patient/list")
	  public String litsPatients(Model model)
	  {
		 List<PatientBean> patients =  microservicesproxy.listPatients();
		 model.addAttribute("patients", patients);		 
	      return "ListPatients";
	  }
	   
	@GetMapping("/patient/info/{firstname}/{lastname}")
	public String showPatientInfo(@PathVariable String firstname, @PathVariable String lastname, Model model) {    
	    PatientBean patient = microservicesproxy.patient(firstname, lastname); 
	    String risk = microservicesproxy.getRiskLevels(firstname, lastname);
	    List<CommentBean> comments = microservicesproxy.getAllCommentOfOnePatient(lastname);
	    model.addAttribute("patient", patient);
	    model.addAttribute("risk", risk); 
	    model.addAttribute("comments",  comments); 
	    return "patientInfo";
	}


	@GetMapping("/patient/add")
	public String addPatient(Model model) {
		return "AddPatrient";
	}
	
	@PostMapping("/patient/create")
	public ResponseEntity<String> createPatient(@RequestBody PatientBean patientBean) {
	    ResponseEntity<String> response = microservicesproxy.addPatient(patientBean);	    
	    return response;
	}
	

	@GetMapping("/patient/update")
	public String updatePatient(Model model) {		    
		 model.addAttribute("patient");
		return "UpdatePatient";
	}

	@PutMapping("/patient/update/data")
	public ResponseEntity<String> updateDataPatient(@RequestBody PatientBean patientBean) {
		ResponseEntity<String> response = microservicesproxy.updatePatient(patientBean);
		return response;		
	}
	
	@GetMapping("/comment/add")
	public String pageAddComment(Model model) {	 
		return "AddComment"; 			
		}
	
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
