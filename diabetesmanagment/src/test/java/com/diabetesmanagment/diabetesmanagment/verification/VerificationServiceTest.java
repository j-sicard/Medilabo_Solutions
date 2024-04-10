package com.diabetesmanagment.diabetesmanagment.verification;

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
import com.diabetesmanagment.diabetesmanagment.service.VerificationService;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(classes = DiabetesmanagmentApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class VerificationServiceTest {
		
	@Autowired
	VerificationService verificationService; 
	
	@Test
	void moreThirtyYearsOldTest() {
	    LocalDate birthDate = LocalDate.of(1981, 4, 6); 
	    Boolean ifageismorethirty = verificationService.ageChecker(birthDate, 30);
	    
	    assertTrue(ifageismorethirty); 
	}
	
	@Test
	void forLevelRisqueNoneReturnTrueTest() {		
		assertTrue(verificationService.forLevelRisqueNone(0).equals(true)); 
	}
	
	@Test
	void forLevelRisqueNoneReturnfalseTest() {		
		assertTrue(verificationService.forLevelRisqueNone(1).equals(false)); 
	}
	
	
	@Test
	void forLevelRisqueBorderlineReturnTrueWiththreeOccurenceTest() {		
		assertTrue(verificationService.forLevelRisqueBorderline(3, true).equals(true)); 
	}
	
	@Test
	void forLevelRisqueBorderlineReturnTrueWithFourOccurenceTest() {		
		assertTrue(verificationService.forLevelRisqueBorderline(4, true).equals(true)); 
	}
	
	@Test
	void forLevelRisqueBorderlineReturnTrueWithFiveOccurenceTest() {		
		assertTrue(verificationService.forLevelRisqueBorderline(5, true).equals(true)); 
	}
	
	@Test
	void forLevelRisqueBorderlineReturnfalseWithMoreFiveOccurenceTest() {		
		assertTrue(verificationService.forLevelRisqueBorderline(6, true).equals(false)); 
	}
	
	@Test
	void forLevelRisqueBorderlineReturnfalseWithAgeChekerFalseTest() {		
		assertTrue(verificationService.forLevelRisqueBorderline(5, false).equals(false)); 
	}	
	
	@Test
	void forLevelRisqueDangerReturnTrueForManWithThreeOccurenceTest() {
		PatientBean patient = new PatientBean(); 
		patient.setGender("H");
		assertTrue(verificationService.forLevelRisqueDanger(3, patient, false).equals(true)) ; 
	}
	
	@Test
	void forLevelRisqueDangerReturnTrueForWomenWithFourOccurenceTest() {
		PatientBean patient = new PatientBean(); 
		patient.setGender("F");
		assertTrue(verificationService.forLevelRisqueDanger(4, patient, false).equals(true)) ; 
	}
	
	@Test
	void forLevelRisqueDangerReturnTrueForSixOccurenceTest() {
		PatientBean patient = new PatientBean(); 
		patient.setGender("F");
		assertTrue(verificationService.forLevelRisqueDanger(6, patient, false).equals(true)) ; 
	}
	
	@Test
	void forLevelRisqueDangerReturnTrueForSevenOccurenceTest() {
		PatientBean patient = new PatientBean(); 
		patient.setGender("F");
		assertTrue(verificationService.forLevelRisqueDanger(7, patient, false).equals(true)) ; 
	}
	
	@Test
	void forLevelRisqueDangerReturnFalseForMoreSevenOccurenceTest() {
		PatientBean patient = new PatientBean(); 
		patient.setGender("F");
		assertTrue(verificationService.forLevelRisqueDanger(8, patient, false).equals(false)) ; 
	}
	
	@Test
	void forLevelRisqueEarlyOnsetReturnTrueForManAndFiveOccurenceTest() {
		PatientBean patient = new PatientBean(); 
		patient.setGender("H");
		assertTrue(verificationService.forLevelRisqueEarlyOnset(5, patient, false).equals(true));
	}
	
	@Test
	void forLevelRisqueEarlyOnsetReturnTrueForWomenAndFourOccurenceTest() {
		PatientBean patient = new PatientBean(); 
		patient.setGender("F");
		assertTrue(verificationService.forLevelRisqueEarlyOnset(4, patient, false).equals(true));
	}
	
	@Test
	void forLevelRisqueEarlyOnsetReturnTrueWithHieghtOccurenceTest() {
		PatientBean patient = new PatientBean(); 
		patient.setGender("F");
		assertTrue(verificationService.forLevelRisqueEarlyOnset(8, patient, false).equals(true));
	}
	
	@Test
	void forLevelRisqueEarlyOnsetReturnFalseWithMenWithlessFiveOccurenceTest() {
		PatientBean patient = new PatientBean(); 
		patient.setGender("H");
		assertTrue(verificationService.forLevelRisqueEarlyOnset(4, patient, false).equals(false));
	}
	
	@Test
	void forLevelRisqueEarlyOnsetReturnFalseWithWomenWithlessFourOccurenceTest() {
		PatientBean patient = new PatientBean(); 
		patient.setGender("F");
		assertTrue(verificationService.forLevelRisqueEarlyOnset(3, patient, false).equals(false));
	}
	
	@Test
	void forLevelRisqueEarlyOnsetReturnFalseWithAgeCheckerTrueTest() {
		PatientBean patient = new PatientBean(); 
		patient.setGender("F");
		assertTrue(verificationService.forLevelRisqueEarlyOnset(3, patient, true).equals(false));
	}

}
