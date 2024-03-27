package com.mfront.front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mfront.front.beans.PatientBean;
import com.mfront.front.proxies.MicroservicePatientsproxy;

@Controller
public class FrontController {

	@Autowired
	private MicroservicePatientsproxy microservicePatientsproxy;

	
	@GetMapping("/patient/list")
	  public String litsPatients(Model model)
	  {
		 List<PatientBean> patients =  microservicePatientsproxy.listPatients();
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
	    PatientBean patient = microservicePatientsproxy.patient(firstname, lastname);     
	    model.addAttribute("patient", patient);
	    return "patientInfo";
	}


	@GetMapping("/patient/add")
	public String addPatient(Model model) {
		return "AddPatrient";
	}
	
	@PostMapping("/patient/create")
	public ResponseEntity<String> createPatient(@RequestBody PatientBean patientBean) {
	    ResponseEntity<String> response = microservicePatientsproxy.addPatient(patientBean);
	    // Traitez ici la réponse en fonction de son statut et de son contenu
	    return response;
	}

	

	@GetMapping("/patient/update")
	public String updatePatient(@RequestParam String firstname, @RequestParam String lastname, Model model) {
		 PatientBean patient = microservicePatientsproxy.patient(firstname, lastname);     
		 model.addAttribute("patient", patient);
		return "UpdatePatient";
	}

}
