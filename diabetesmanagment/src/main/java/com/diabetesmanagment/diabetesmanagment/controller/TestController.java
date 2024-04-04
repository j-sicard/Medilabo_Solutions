package com.diabetesmanagment.diabetesmanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;
import com.diabetesmanagment.diabetesmanagment.proxies.Mpatientproxy;

@RestController
public class TestController {

	@Autowired
	Mpatientproxy mpatientproxy;

	@GetMapping("/test/{firstname}/{lastname}")
	public PatientBean getPatientInfo(@PathVariable String firstname, @PathVariable String lastname) {
		return mpatientproxy.getPatientInfo(firstname, lastname);
	}

}
