package com.diabetesmanagment.diabetesmanagment.commentservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.diabetesmanagment.diabetesmanagment.DiabetesmanagmentApplication;
import com.diabetesmanagment.diabetesmanagment.beans.CommentPatientBean;
import com.diabetesmanagment.diabetesmanagment.service.CommentService;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(classes = DiabetesmanagmentApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class CommentServiceTest {
	
	@Autowired
	CommentService commentService; 

	@Test
	void getNotesTest() {	
		CommentPatientBean commentPatient1 = new CommentPatientBean("1", "patientTest1","note patient 1"); 
		CommentPatientBean commentPatient2 = new CommentPatientBean("2", "patientTest2","note patient 2");
		
		List<CommentPatientBean> comments = new ArrayList<>();
		comments.add(commentPatient1); 
		comments.add(commentPatient2);
		
		List<String> notes = commentService.getNotes(comments);
		
	    assertEquals(2, notes.size());    
	    assertEquals("note patient 1", notes.get(0));
	    assertEquals("note patient 2", notes.get(1));		
	}
	
	@Test
	void mergeNotesTest() {      
	    List<String> notes = new ArrayList<>();
	    notes.add("note patient 1"); 
	    notes.add("note patient 2");	    
	    
	    String mergedNote = commentService.mergeNotes(notes); 
	    
	    assertEquals( "note patient 1\nnote patient 2\n", mergedNote);
	}
	
	@Test
	void countUniqueTermsTest(){
	    String[] termsToCheck = {
	        "Taille", "Poids", "Fumeur", "Fumeuse", 
	    };           
	   
	   assertEquals( 4, commentService.countUniqueTerms("Taille, Poids, Fumeur, Fumeuse", termsToCheck));
	}
	
		
}
