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

@FeignClient(name = "api-gateway", url = "localhost:8765")
public interface Microservicesproxy {

	// Mpatient end-point
	@GetMapping(value = "/MPATIENTS/PatientRecord/patients")
	List<PatientBean> listPatients();

	@GetMapping(value = "/MPATIENTS/PatientRecord/patient/{firstname}/{lastname}")
	PatientBean patient(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname);

	@PostMapping(value = "/MPATIENTS/PatientRecord/create")
	ResponseEntity<String> addPatient(@RequestBody PatientBean patientBean);

	@PutMapping(value = "/MPATIENTS/PatientRecord/patient/update")
	ResponseEntity<String> updatePatient(@RequestBody PatientBean patientBean);

	@GetMapping(value = "/MPATIENTS/user/{username}")
	public UserBean getuser(@PathVariable String username);

	@GetMapping("/MPATIENTS/user/users")
	public List<UserBean> getUsers();

	@PostMapping("/MPATIENTS/user/save")
	public void saveUser(@RequestBody UserBean user);

	// mcomment end-point //

	@GetMapping(value = "/MCOMMENTPATIENT/comment/patient/comment/{patient}")
	public List<CommentBean> getAllCommentOfOnePatient(@PathVariable String patient);

	@PostMapping(value = "/MCOMMENTPATIENT/comment/new")
	public void postNewComment(@RequestBody CommentBean commentBean);

	// diabetesmanagement end-point

	@GetMapping("/DIABETESMANAGMENT/check/{firstname}/{lastname}")
	public String getRiskLevels(@PathVariable String firstname, @PathVariable String lastname);

}
