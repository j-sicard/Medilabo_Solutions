package servicetest;

import com.mpatient.mpatient.service.PatientService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import utilstest.AbstractConfigurationTest;

import static org.junit.jupiter.api.Assertions.*;
@Transactional
public class PatientServiceTest extends AbstractConfigurationTest {

    @Autowired
    PatientService patientService;

    @Test
    void getIdByNamesTest(){
        assertTrue(patientService.getIdByNames("TestNone", "Test").equals(1L));
    }
}
