package com.diabetesmanagment.diabetesmanagment.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.diabetesmanagment.diabetesmanagment.beans.CommentPatientBean;

@FeignClient(name = "mcommentpatient", url = "localhost:9002")
public interface  McommentProxy {

	@GetMapping(value = "/comment/patient/comment/{patient}")
	public List<CommentPatientBean> findAllCommentOfOnePatient(@PathVariable String patient);

}
