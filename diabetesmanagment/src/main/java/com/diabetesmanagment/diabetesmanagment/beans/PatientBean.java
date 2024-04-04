package com.diabetesmanagment.diabetesmanagment.beans;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


import java.util.Date;

public class PatientBean {
    
    @Size(max = 50, message = "The first name cannot exceed 50 characters.")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "The first name can only contain letters.")
    private String firstname;

    @Size(max = 50, message = "The last name cannot exceed 50 characters.")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "The last name can only contain letters.")
    private String lastname;

    @NotNull(message = "Date of birth cannot be null.")
    @Past(message = "The date of birth must be in the past.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    @NotNull(message = "Gender cannot be null.")
    @Pattern(regexp = "[MF]", message = "Gender must be 'M' for masculine or 'F' for feminine.")
    private String gender;

    @Size(max = 100, message = "The maximum address length is 100 characters.")
    private String address;

    @Size(max = 15, message = "The maximum phone number length is 15 characters.")
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$", message = "The phone number must be in the format 'XXX-XXX-XXXX'.")
    private String phoneNumber;

    public PatientBean() {
    }

    public PatientBean(String firstname, String lastname, Date birthDay, String gender, String address, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDay = birthDay;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PatientBean [firstname=" + firstname + ", lastname=" + lastname + ", birthDay=" + birthDay + ", gender="
                + gender + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
    }
}

