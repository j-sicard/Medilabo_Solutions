package com.mpatient.mpatient.service.impl;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.mpatient.mpatient.entity.PatientMO;
import com.mpatient.mpatient.repositories.PatientRepository;
import com.mpatient.mpatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.StreamSupport;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    private static final Logger logger = Logger.getLogger(PatientServiceImpl.class.getName());

    public Long getIdByNames(String firstName, String lastName) {
        Optional<PatientMO> matchingPatient = StreamSupport.stream(patientRepository.findAll().spliterator(), false)
                .filter(patient -> patient.getFirstname().equals(firstName) && patient.getLastname().equals(lastName))
                .findFirst();

        return matchingPatient.map(PatientMO::getPatientID).orElse(null);
    }

    public boolean patientExists(String firstName, String lastName) {
        return StreamSupport.stream(patientRepository.findAll().spliterator(), false)
                .anyMatch(patient -> patient.getFirstname().equals(firstName) && patient.getLastname().equals(lastName));
    }


}
