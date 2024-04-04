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
import org.springframework.http.MediaType;




@Controller
public class PatientController {

	@Autowired
	private Microservicesproxy Microservicesproxy;

	
	@GetMapping("/patient/list")
	  public String litsPatients(Model model)
	  {
		 List<PatientBean> patients =  Microservicesproxy.listPatients();
		 model.addAttribute("patients", patients);		 
	      return "ListPatients";
	  }
	   
	@GetMapping("/patient/search")
	public String gestionPatient(Model model) {
		model.addAttribute("patients");
		return "PatientSearch";
	}

	@GetMapping("/patient/info")
	public String showPatientInfo(@RequestParam String firstname, @RequestParam String lastname, Model model) {    
	    PatientBean patient = Microservicesproxy.patient(firstname, lastname); 
	    List<CommentBean> comments = Microservicesproxy.getAllCommentOfOnePatient(firstname);
	    model.addAttribute("patient", patient);
	    model.addAttribute("comments",  comments); 
	    return "patientInfo";
	}


	@GetMapping("/patient/add")
	public String addPatient(Model model) {
		return "AddPatrient";
	}
	
	@PostMapping("/patient/create")
	public ResponseEntity<String> createPatient(@RequestBody PatientBean patientBean) {
	    ResponseEntity<String> response = Microservicesproxy.addPatient(patientBean);	    
	    return response;
	}
	

	@GetMapping("/patient/update")
	public String updatePatient(Model model) {		    
		 model.addAttribute("patient");
		return "UpdatePatient";
	}

	@PutMapping("/patient/update/data")
	public ResponseEntity<String> updateDataPatient(@RequestBody PatientBean patientBean) {
		ResponseEntity<String> response = Microservicesproxy.updatePatient(patientBean);
		return response;		
	}
	
	@GetMapping("/comment/add")
	public String pageAddComment(Model model) {	 
		return "AddComment"; 			
		}
	
	@PostMapping(value = "/comment/add/data")
	public String addCommentData(@RequestBody CommentBean commentBean) {
		Microservicesproxy.postNewComment(commentBean);
		return "confirmation";
	}
	
	
		
	
}
