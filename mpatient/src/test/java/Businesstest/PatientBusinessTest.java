package Businesstest;

import com.mpatient.mpatient.business.PatientBusiness;
import com.mpatient.mpatient.businessmodel.PatientBO;
import com.mpatient.mpatient.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import utilstest.AbstractConfigurationTest;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
public class PatientBusinessTest extends AbstractConfigurationTest {

    @Autowired
    PatientBusiness patientBusiness;
    @Autowired
    PatientRepository patientRepository;
    @Test
    void updatePatientInfoTest(){
       assertTrue(patientRepository.findById(2L).getAddress().equals("2 High St "));
       PatientBO patientTest = new PatientBO();
       String adressUpdate = "3 Low St";
       patientTest.setAddress(adressUpdate);
       patientBusiness.updatePatientInfo("TestBorderline", "Test", patientTest );
       assertTrue(patientRepository.findById(2L).getAddress().equals(adressUpdate));
    }

    @Test
    void getPatientInfoTest(){
        assertTrue(patientBusiness.getPatientInfo("TestNone", "Test").getAddress().equals("1 Brookside St"));
    }

    @Test
    void deletePatientInfo(){
    long countBefore = patientRepository.count();

    patientBusiness.deleteProfilePatient("TestDelete", "Test");

    long countAfter = patientRepository.count();

    assertTrue(countBefore > countAfter);
    }


}
