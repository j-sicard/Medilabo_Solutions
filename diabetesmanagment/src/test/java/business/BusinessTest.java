package business;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.diabetesmanagment.diabetesmanagment.DiabetesmanagmentApplication;
import com.diabetesmanagment.diabetesmanagment.business.BusinessService;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(classes = DiabetesmanagmentApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class BusinessTest {
	
	
	@Autowired
	BusinessService businessService; 
	

	
	@Test
	void getRiskLevelsReturnNoneTest() {	
		System.out.println("TEST DE MERDE: x 10");
		String test = businessService.getRiskLevels("TestEarlyOnset", "Test"); 
		System.out.println("TEST DE MERDE: " + test);
		assertTrue(test.equals("None"));
	}
	
	
	
	//public String test(String firstname, String lastname) {
	//	Boolean agechecker = verificationService.AgeChecker(patientService.getPatientInfo(firstname, lastname).getBirthDay(), agecheck);
	//	System.out.println(agechecker);
	//	int occurenceCount = commentService.countUniqueTerms(commentService.mergeNotes(commentService.getNotes(commentService.getAllCommentForOnePatient(firstname))), termsToCheck);
	//	System.out.println(occurenceCount);
	//	PatientBean patient = patientService.getPatientInfo(firstname, lastname); 
	//.out.println(patient);
	//	if(verificationService.forLevelRisqueNone(occurenceCount) == true) {
	//		return "None"; 
	//	}
	//	if(verificationService.forLevelRisqueBorderline(occurenceCount, agechecker) == true) {
	//		return "Bordeline"; 
	//	}
	//	if(verificationService.forLevelRisqueDanger(occurenceCount, patient, agechecker)) {
	//		return "Danger"; 
	//	}
	//	if(verificationService.forLevelRisqueEarlyOnset(occurenceCount, patient, agechecker) == true) {
	//		return "Early onset"; 
	//	}
	//	return "occurrence will be calculated soon";		
			
//	}
}
