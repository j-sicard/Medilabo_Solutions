package com.diabetesmanagment.diabetesmanagment.ultils;

import java.time.LocalDate;
import java.time.Period;

public class Utils {

	public static int calculateAge(LocalDate birthDate) {

		LocalDate currentDate = LocalDate.now();

		Period period = Period.between(birthDate, currentDate);

		int age = period.getYears();

		return age;

	}

	public Boolean moreThirtyYearsOld(LocalDate birthDate, int ageToCheck) {

		if (Utils.calculateAge(birthDate) >= ageToCheck) {
			return true;
		}
		return false;
	}

}
