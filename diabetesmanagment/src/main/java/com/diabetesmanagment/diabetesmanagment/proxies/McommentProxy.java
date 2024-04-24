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
@FeignClient(name = "mcommentpatient", url = "localhost:9002")
public interface  McommentProxy {

	/**
	 * Retrieves all comments for a specific patient from the Comment service.
	 *
	 * @param patient The name of the patient.
	 * @return A list of CommentPatientBean objects representing the comments for the patient.
	 */
	@GetMapping(value = "/comment/patient/comment/{patient}")
	public List<CommentPatientBean> findAllCommentOfOnePatient(@PathVariable String patient);

}
