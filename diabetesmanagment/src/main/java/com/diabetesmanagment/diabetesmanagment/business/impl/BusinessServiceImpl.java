package com.diabetesmanagment.diabetesmanagment.business.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diabetesmanagment.diabetesmanagment.beans.CommentPatientBean;
import com.diabetesmanagment.diabetesmanagment.beans.PatientBean;
import com.diabetesmanagment.diabetesmanagment.business.BusinessService;
import com.diabetesmanagment.diabetesmanagment.service.CommentService;
import com.diabetesmanagment.diabetesmanagment.service.PatientService;
import com.diabetesmanagment.diabetesmanagment.service.VerificationService;

/**
 * Implementation of the BusinessService interface providing business logic
 * operations.
 */
@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	PatientService patientService;

	@Autowired
	CommentService commentService;

	@Autowired
	VerificationService verificationService;

	final private int agecheck = 30;

	String[] termsToCheck = { "Hémoglobine A1C", "Hémoglobine", "Microalbumine", "Taille", "Poids", "Fumeur", "Fumeuse",
			"Anormal", "Anormale", "Anormales", "Cholestérol", "Vertiges", "Vertige", "Rechute", "Réaction",
			"Anticorps" };

	private static final Logger logger = Logger.getLogger(BusinessServiceImpl.class.getName());

	/**
	 * Retrieves the notes from a list of CommentPatientBean objects.
	 *
	 * @param listComment The list of CommentPatientBean objects.
	 * @return The list of notes.
	 */
	public List<String> getNotes(List<CommentPatientBean> listComment) {
		return commentService.getNotes(listComment);
	}

	/**
	 * Retrieves all comments of a specific patient.
	 *
	 * @param patient The patient's name.
	 * @return The list of comments associated with the patient.
	 */
	public List<CommentPatientBean> getAllNoteOffOnePatient(String patient) {
		return commentService.getAllCommentForOnePatient(patient);
	}

	/**
	 * Checks if the patient's age is above a certain threshold.
	 *
	 * @param patient The patient whose age is to be checked.
	 * @return True if the patient's age is above the threshold, false otherwise.
	 */
	public Boolean ageChecker(PatientBean patient) {
		return verificationService.ageChecker(patient.getBirthDay(), agecheck);
	}

	/**
	 * Counts the occurrences of specific terms in a note.
	 *
	 * @param note The note to be analyzed.
	 * @return The count of unique terms.
	 */
	public int occurenceCount(String note) {
		return commentService.countUniqueTerms(note, termsToCheck);
	}

	/**
	 * Merges a list of notes into a single string.
	 *
	 * @param listNote The list of notes to be merged.
	 * @return The merged notes.
	 */
	public String mergeNotes(List<String> listNote) {
		return commentService.mergeNotes(listNote);
	}

	/**
	 * Retrieves all comments of a specific patient.
	 *
	 * @param firstname The first name of the patient.
	 * @return The list of comments associated with the patient.
	 */
	public List<CommentPatientBean> getAllCommentForOnePatient(String firstname) {
		return commentService.getAllCommentForOnePatient(firstname);
	}
	
	/**
     * Retrieves information about a specific patient.
     *
     * @param firstname The first name of the patient.
     * @param lastname  The last name of the patient.
     * @return The PatientBean object containing the patient information.
     */
	public PatientBean getPatientInfo(String firstname, String lastname) {
		return patientService.findPatient(firstname, lastname);
	}
	
	/**
     * Calculates the risk levels for a patient based on age and comment occurrences.
     *
     * @param agechecker    Indicates if the patient's age is above a certain threshold.
     * @param occurenceCount The count of unique terms in the patient's notes.
     * @param patient       The PatientBean object containing patient information.
     * @return The risk level for the patient.
     */
	public String getRiskLevels(Boolean agechecker, int occurenceCount, PatientBean patient) {

		logger.info("Gender Patient : " + patient.getGender());

		if (verificationService.forLevelRisqueNone(occurenceCount) == true) {
			logger.info("Rish : None");
			return "None";
		}
		if (verificationService.forLevelRisqueBorderline(occurenceCount, agechecker) == true) {
			logger.info("Rish : Bordeline");
			return "Bordeline";
		}
		if (verificationService.forLevelRisqueDanger(occurenceCount, patient, agechecker) == true) {
			logger.info("Rish : Danger");
			return "Danger";
		}
		if (verificationService.forLevelRisqueEarlyOnset(occurenceCount, patient, agechecker) == true) {
			logger.info("Rish : Early onset");
			return "Early onset";
		}
		logger.info("Rish : Outside the criterion of calculation");
		return "Outside the criterion of calculation";

	}

}
