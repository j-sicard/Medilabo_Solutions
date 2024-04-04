package com.diabetesmanagment.diabetesmanagment.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;

@FeignClient(name = "mpatients", url = "localhost:9001")
public interface Mpatientproxy {
	
	 
	  @GetMapping("/PatientRecord/patient/{firstname}/{lastname}")
	  PatientBean getPatientInfo(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname);
}
