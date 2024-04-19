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
import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;
import com.diabetesmanagment.diabetesmanagment.business.BusinessService;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(classes = DiabetesmanagmentApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class BusinessTest {

	@Autowired
	BusinessService businessService;

	@Test
	void getRiskLevelsReturnNone() {
		PatientBean patient = new PatientBean();		
		patient.setGender("F");	

		assertTrue(businessService.getRiskLevels(false, 0, patient).equals("None"));
	}
	
	@Test
	void getRiskLevelsReturnBorderline() {
		PatientBean patient = new PatientBean();		
		patient.setGender("F");	
		
		assertTrue(businessService.getRiskLevels(true, 4, patient).equals("Bordeline"));
	}
	
	@Test
	void getRiskLevelsReturnDangerForWomen() {
		PatientBean patient = new PatientBean();		
		patient.setGender("F");	
		
		assertTrue(businessService.getRiskLevels(false, 4, patient).equals("Danger"));
	}
	
	@Test
	void getRiskLevelsReturnDangerForMen() {
		PatientBean patient = new PatientBean();		
		patient.setGender("H");	
		
		assertTrue(businessService.getRiskLevels(false, 3, patient).equals("Danger"));
	}
	
	@Test
	void getRiskLevelsReturnDangerForHightOccurence() {
		PatientBean patient = new PatientBean();		
		patient.setGender("H");	
		
		assertTrue(businessService.getRiskLevels(true, 6, patient).equals("Danger"));
	}
	
	@Test
	void getRiskLevelsReturnEarlyOnsetForMen() {
		PatientBean patient = new PatientBean();		
		patient.setGender("H");	
	
		assertTrue(businessService.getRiskLevels(false, 5, patient).equals("Early onset"));
	}
	
	@Test
	void getRiskLevelsReturnEarlyOnsetForWomen() {
		PatientBean patient = new PatientBean();		
		patient.setGender("F");	
	
		System.out.println(businessService.getRiskLevels(false, 7, patient));
		assertTrue(businessService.getRiskLevels(false, 7, patient).equals("Early onset"));
	}
	
	@Test
	void getRiskLevelsReturnEarlyOnsetForHightOccurence() {
		PatientBean patient = new PatientBean();		
		patient.setGender("F");	
	
		assertTrue(businessService.getRiskLevels(false, 8, patient).equals("Early onset"));
	}
		
}
