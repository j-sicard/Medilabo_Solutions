package com.mfront.front.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mfront.front.beans.PatientBean;

@FeignClient(name = "mpatients", url = "localhost:9001")
public interface MicroservicePatientsproxy {

    @GetMapping(value = "/PatientRecord/patients")
    List<PatientBean> listPatients();
    
    @GetMapping(value = "/PatientRecord/patient/{firstname}/{lastname}")
    PatientBean patient(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname);
    
    @PostMapping(value = "/PatientRecord/create")
    ResponseEntity<String> addPatient(@RequestBody PatientBean patientBean);
    
    @PutMapping(value = "/PatientRecord/patient/update")
    ResponseEntity<String> updatePatient(@RequestBody PatientBean patientBean);
   
    
}
