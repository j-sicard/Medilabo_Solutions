package com.diabetesmanagment.diabetesmanagment.patientservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.diabetesmanagment.diabetesmanagment.DiabetesmanagmentApplication;
import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;
import com.diabetesmanagment.diabetesmanagment.service.PatientService;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(classes = DiabetesmanagmentApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class PatientServiceTest {
	
	@Autowired
	PatientService patientService;
		
	@Test
	void ifGenderfeminineAndMoreAgeCheckerSuccessTest() {
		PatientBean patient = new PatientBean(); 
		patient.setBirthDay(LocalDate.of(1981, 4, 6));
		patient.setGender("F");		
	
		assertTrue(patientService.ifGenderfeminineAndMoreAgeChecker(patient, 30).equals(true)); 		
	}
	
	@Test
	void ifGenderfeminineAndMoreAgeCheckerFailDateTest() {
		PatientBean patient = new PatientBean(); 
		patient.setBirthDay(LocalDate.of(2022, 4, 6));
		patient.setGender("F");
		
		assertTrue(patientService.ifGenderfeminineAndMoreAgeChecker(patient, 30).equals(false)); 		
	}
	
	@Test
	void ifGenderfeminineAndMoreAgeCheckerFailGenderTest() {
		PatientBean patient = new PatientBean(); 
		patient.setBirthDay(LocalDate.of(1981, 4, 6));
		patient.setGender("H");
		
		assertTrue(patientService.ifGenderfeminineAndMoreAgeChecker(patient, 30).equals(false)); 		
	}
	
	@Test
	void ifGenderfeminineAndLessAgeCheckerSuccessTest() {
		PatientBean patient = new PatientBean(); 
		patient.setBirthDay(LocalDate.of(2020, 4, 6));
		patient.setGender("F");
		
		assertTrue(patientService.ifGenderfeminineAndLessAgeChecker(patient, 30).equals(true)); 		
	}
	
	@Test
	void ifGenderfeminineAndLessAgeCheckerFailDateTest() {
		PatientBean patient = new PatientBean(); 
		patient.setBirthDay(LocalDate.of(1980, 4, 6));
		patient.setGender("F");
		
		assertTrue(patientService.ifGenderfeminineAndLessAgeChecker(patient, 30).equals(false)); 		
	}
	
	@Test
	void ifGenderfeminineAndLessAgeCheckerFaiGenderTest() {
		PatientBean patient = new PatientBean(); 
		patient.setBirthDay(LocalDate.of(2020, 4, 6));
		patient.setGender("H");
		
		assertTrue(patientService.ifGenderfeminineAndLessAgeChecker(patient, 30).equals(false)); 		
	}
	
	@Test
	void ifGendermasculineAndMoreAgeCheckersuccessTest() {
		PatientBean patient = new PatientBean(); 
		patient.setBirthDay(LocalDate.of(1980, 4, 6));
		patient.setGender("M");
		
		assertTrue(patientService.ifGendermasculineAndMoreAgeChecker(patient, 30).equals(true)); 		
	}
	
	@Test
	void ifGendermasculineAndMoreAgeCheckerFailDateTest() {
		PatientBean patient = new PatientBean(); 
		patient.setBirthDay(LocalDate.of(2020, 4, 6));
		patient.setGender("H");
		
		assertTrue(patientService.ifGendermasculineAndMoreAgeChecker(patient, 30).equals(false)); 		
	}
	
	@Test
	void ifGendermasculineAndMoreAgeCheckerFailGenderTest() {
		PatientBean patient = new PatientBean(); 
		patient.setBirthDay(LocalDate.of(2020, 4, 6));
		patient.setGender("F");
		
		assertTrue(patientService.ifGendermasculineAndMoreAgeChecker(patient, 30).equals(false)); 		
	}
	
	
	@Test
	void ifGendermasculineAndMoreAgeCheckerSuccessTest() {
		PatientBean patient = new PatientBean(); 
		patient.setBirthDay(LocalDate.of(2020, 4, 6));
		patient.setGender("H");
		
		assertTrue(patientService.ifGendermasculineAndLessAgeChecker(patient, 30).equals(false)); 		
	}
	
	@Test
	void ifGendermasculineAndLessAgeCheckerFailDateTest() {
		PatientBean patient = new PatientBean(); 
		patient.setBirthDay(LocalDate.of(1980, 4, 6));
		patient.setGender("H");
		
		assertTrue(patientService.ifGendermasculineAndLessAgeChecker(patient, 30).equals(false)); 		
	}
	
	@Test
	void ifGendermasculineAndLessAgeCheckerFailGenderTest() {
		PatientBean patient = new PatientBean(); 
		patient.setBirthDay(LocalDate.of(2020, 4, 6));
		patient.setGender("F");
		
		assertTrue(patientService.ifGendermasculineAndLessAgeChecker(patient, 30).equals(false)); 		
	}
	


	

}
