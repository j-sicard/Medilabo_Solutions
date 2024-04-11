package ControllerTest;

import com.mpatient.mpatient.MpatientApplication;
import com.mpatient.mpatient.business.PatientBusiness;
import com.mpatient.mpatient.controller.PatientController;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MpatientApplication.class)
@Sql(scripts = { "classpath:data-test.sql" })
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class PatientControllerTest{

    @Mock
    private PatientBusiness patientBusiness;

    @InjectMocks
    private PatientController patientController;

    @Autowired
    private MockMvc mockMvc;

    /* -- Tests patientInfo --*/
    @Test
    void testGetPatientInfo_Success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/PatientRecord/patient/TestNone/Test")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetPatientInfo_EntityNotFoundException() throws Exception {
        when(patientBusiness.getPatientInfo(anyString(), anyString())).thenThrow(EntityNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/PatientRecord/patient/NonExisting/User")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
