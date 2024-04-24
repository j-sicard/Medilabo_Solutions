package com.mfront.front.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mfront.front.beans.CommentBean;
import com.mfront.front.beans.PatientBean;
import com.mfront.front.beans.UserBean;

/**
 * Proxy interface for accessing microservices endpoints.
 */
@FeignClient(name = "api-gateway", url = "localhost:8765")
public interface Microservicesproxy {

	  /**
     * Retrieves the list of patients from the MPATIENTS microservice.
     * @return List of PatientBean objects.
     */
	@GetMapping(value = "/MPATIENTS/PatientRecord/patients")
	List<PatientBean> listPatients();

	 /**
     * Retrieves a specific patient by their first and last name from the MPATIENTS microservice.
     * @param firstname First name of the patient.
     * @param lastname Last name of the patient.
     * @return PatientBean object representing the patient.
     */
	@GetMapping(value = "/MPATIENTS/PatientRecord/patient/{firstname}/{lastname}")
	PatientBean patient(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname);

	   /**
     * Adds a new patient to the MPATIENTS microservice.
     * @param patientBean PatientBean object representing the new patient.
     * @return ResponseEntity indicating the success or failure of the operation.
     */
	@PostMapping(value = "/MPATIENTS/PatientRecord/create")
	ResponseEntity<String> addPatient(@RequestBody PatientBean patientBean);

	 /**
     * Updates an existing patient in the MPATIENTS microservice.
     * @param patientBean PatientBean object representing the patient with updated information.
     * @return ResponseEntity indicating the success or failure of the operation.
     */
	@PutMapping(value = "/MPATIENTS/PatientRecord/patient/update")
	ResponseEntity<String> updatePatient(@RequestBody PatientBean patientBean);

	  /**
     * Retrieves user information by username from the MPATIENTS microservice.
     * @param username Username of the user.
     * @return UserBean object representing the user.
     */
	@GetMapping(value = "/MPATIENTS/user/{username}")
	public UserBean getuser(@PathVariable String username);

	 /**
     * Retrieves the list of users from the MPATIENTS microservice.
     * @return List of UserBean objects.
     */
	@GetMapping("/MPATIENTS/user/users")
	public List<UserBean> getUsers();

	  /**
     * Saves a new user to the MPATIENTS microservice.
     * @param user UserBean object representing the new user.
     */
	@PostMapping("/MPATIENTS/user/save")
	public void saveUser(@RequestBody UserBean user);

	  /**
     * Retrieves all comments of a specific patient from the MCOMMENTPATIENT microservice.
     * @param patient Patient identifier.
     * @return List of CommentBean objects representing comments of the patient.
     */
	@GetMapping(value = "/MCOMMENTPATIENT/comment/patient/comment/{patient}")
	public List<CommentBean> getAllCommentOfOnePatient(@PathVariable String patient);

	   /**
     * Posts a new comment to the MCOMMENTPATIENT microservice.
     * @param commentBean CommentBean object representing the new comment.
     */
	@PostMapping(value = "/MCOMMENTPATIENT/comment/new")
	public void postNewComment(@RequestBody CommentBean commentBean);

	  /**
     * Retrieves risk levels for a specific patient from the DIABETESMANAGMENT microservice.
     * @param firstname First name of the patient.
     * @param lastname Last name of the patient.
     * @return String representing the risk levels.
     */
	@GetMapping("/DIABETESMANAGMENT/check/{firstname}/{lastname}")
	public String getRiskLevels(@PathVariable String firstname, @PathVariable String lastname);

}
