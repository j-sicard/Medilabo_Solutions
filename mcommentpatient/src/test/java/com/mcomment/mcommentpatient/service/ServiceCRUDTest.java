package com.mcomment.mcommentpatient.service;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.mcomment.mcommentpatient.McommentpatientApplication;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(classes = McommentpatientApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class ServiceCRUDTest {

}