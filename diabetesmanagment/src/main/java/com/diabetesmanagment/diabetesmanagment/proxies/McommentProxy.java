package com.diabetesmanagment.diabetesmanagment.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.diabetesmanagment.diabetesmanagment.beans.CommentPatientBean;

/**
 * Feign client interface for interacting with the Comment service.
 * This interface defines methods to retrieve comments related to patients.
 */
@FeignClient(name = "mcommentpatient")
public interface  McommentProxy {

	

}
