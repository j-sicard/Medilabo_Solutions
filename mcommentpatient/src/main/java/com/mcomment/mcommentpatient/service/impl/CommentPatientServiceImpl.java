package com.mcomment.mcommentpatient.service.impl;


import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcomment.mcommentpatient.repository.CommentRepository;
import com.mcomment.mcommentpatient.service.CommentPatientService;

@Service
public class CommentPatientServiceImpl implements CommentPatientService{
	
	@Autowired
	CommentRepository commentRepository; 
	
	
	public String getCommentPatIdByPatient(String patient) {
	    List<String> patIds = commentRepository.findDistinctPatIdsByPatient(patient); 
	    if (!patIds.isEmpty()) {
	        JSONObject jsonObject = new JSONObject(patIds.get(0));
	        return jsonObject.getString("patId");
	    } else {
	        return null; 
	    }
	}


}
