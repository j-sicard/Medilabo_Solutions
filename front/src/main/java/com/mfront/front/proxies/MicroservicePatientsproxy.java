package com.mfront.front.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mfront.front.beans.PatientBean;

@FeignClient(name = "mpatients", url = "localhost:9001")
public interface MicroservicePatientsproxy {

    @GetMapping(value = "/PatientRecord/patients")
    List<PatientBean> listPatients();
    
    @GetMapping(value = "/PatientRecord/patient/{firstname}/{lastname}")
    PatientBean patient(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname);
   
    
}
