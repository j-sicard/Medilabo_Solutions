package com.diabetesmanagment.diabetesmanagment.beans;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public class SexeBirthDatePatientBean {


    @NotNull(message = "Date of birth cannot be null.")
    @Past(message = "The date of birth must be in the past.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    @NotNull(message = "Gender cannot be null.")
    @Pattern(regexp = "[MF]", message = "Gender must be 'M' for masculine or 'F' for feminine.")
    private String gender;
 
}
