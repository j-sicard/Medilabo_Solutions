package com.mpatient.mpatient.businessmodel;

import java.util.Date;

/**
 * Business object representing a patient.
 */
public class PatientBO {

    private String firstname;
    private String lastname;
    private Date birthDay;
    private String gender;
    private String address;
    private String phoneNumber;

    public PatientBO(String firstname, String lastname, Date birthDay, String gender, String address, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDay = birthDay;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public PatientBO() {
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
        return "PatientBO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDay=" + birthDay +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
