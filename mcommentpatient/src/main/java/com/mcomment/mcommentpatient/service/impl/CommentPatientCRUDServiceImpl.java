package com.mcomment.mcommentpatient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcomment.mcommentpatient.model.CommentPatientMO;
import com.mcomment.mcommentpatient.repository.CommentRepository;
import com.mcomment.mcommentpatient.service.CommentPatientCRUDService;

@Service
public class CommentPatientCRUDServiceImpl implements CommentPatientCRUDService{
	
	@Autowired
	CommentRepository commentRepository; 
	
	public List<CommentPatientMO> getAllComment(){
		return commentRepository.findAll(); 		
	}
	
	public void addcomments(CommentPatientMO commentPatient) {
		commentRepository.insert(commentPatient);
	}
	
}
