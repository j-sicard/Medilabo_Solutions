package servicetest;

import com.mpatient.mpatient.businessmodel.PatientBO;
import com.mpatient.mpatient.entity.PatientMO;
import com.mpatient.mpatient.repositories.PatientRepository;
import com.mpatient.mpatient.service.PatientCRUDService;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import utilstest.AbstractConfigurationTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
public class PatientCRUDServiceTest extends AbstractConfigurationTest {
    @Autowired
    PatientCRUDService patientCRUDService;
    @Autowired
    PatientRepository patientRepository;
    @Test
    void getPatientByIdTest(){
        assertTrue(patientCRUDService.FindPatientById(1L).getFirstname().equals("TestNone") );
    }

    @Test
    void  getPatientsTest(){
        assertTrue(patientCRUDService.FindPatients().size() >= 3);
    }

    @Test
    void deletePatientByIdTest(){
        Long countBefore = patientRepository.count();
        patientCRUDService.DeleteById(2L);
        Long countAfter = patientRepository.count();
        assertTrue(countBefore > countAfter);
    }


    @Test
    void createPatientTest() {
        boolean nameExists = patientCRUDService.FindPatients().stream().anyMatch(patient -> patient.getFirstname().equals("CreatePatientName"));
        assertFalse(nameExists, "The patient's name must not exist in the list.");

        PatientMO patientMO = new PatientMO();
        patientMO.setFirstname("CreatePatientName");
        patientMO.setLastname("test");
        patientMO.setBirthDay(new Date());
        patientMO.setGender("M");
        patientMO.setAddress("Adresse test");
        patientMO.setPhoneNumber("123-456-7890");

        patientCRUDService.SavePatient(patientMO);
        List<PatientMO> patientsAfter = patientCRUDService.FindPatients();
        boolean nameExistsAfter = patientsAfter.stream().anyMatch(patient -> patient.getFirstname().equals("CreatePatientName"));
        assertTrue(nameExistsAfter, "Patient name must exist in the list after creation");
    }

    @Test
    void updatePatientTest(){
        assertTrue(patientRepository.findById(5L).getAddress().equals("5 Mountain Dr"));
        String newAdress = "10 valley Dr";
        PatientBO patientinfoUpdated = new PatientBO();

        patientinfoUpdated.setFirstname("CreatePatientName");
        patientinfoUpdated.setLastname("test");
        patientinfoUpdated.setBirthDay(new Date(2002-06-28));
        patientinfoUpdated.setGender("M");
        patientinfoUpdated.setAddress(newAdress);
        patientinfoUpdated.setPhoneNumber("123-456-7890");
        patientCRUDService.updatePatientByid(5L, patientinfoUpdated);
        assertTrue(patientRepository.findById(5L).getAddress().equals(newAdress));
    }

}
