package com.diabetesmanagment.diabetesmanagment.service.impl;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diabetesmanagment.diabetesmanagment.beans.CommentPatientBean;
import com.diabetesmanagment.diabetesmanagment.proxies.McommentProxy;
import com.diabetesmanagment.diabetesmanagment.service.CommentService;

/**
 * Implementation of the CommentService interface to handle operations related to patient comments.
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	McommentProxy mcommentProxy;
	
	private static final Logger logger = Logger.getLogger(CommentServiceImpl.class.getName());

	 /**
     * Retrieves all comments for a given patient.
     *
     * @param patient The name of the patient.
     * @return A list of CommentPatientBean objects representing the comments.
     */
	public List<CommentPatientBean> getAllCommentForOnePatient(String Patient) {
		return mcommentProxy.findAllCommentOfOnePatient(Patient);
	}

	/**
     * Extracts the notes from a list of CommentPatientBean objects.
     *
     * @param listComment The list of CommentPatientBean objects.
     * @return A list of notes extracted from the CommentPatientBean objects.
     */
	public List<String> getNotes(List<CommentPatientBean> listComment) {
		List<String> notes = new ArrayList<>();
		listComment.forEach(commentPatient -> notes.add(commentPatient.getNote()));
		return notes;
	}

	/**
     * Merges multiple notes into a single note.
     *
     * @param notes The list of notes to be merged.
     * @return A single merged note.
     */
	public String mergeNotes(List<String> notes) {
		StringBuilder mergedNotes = new StringBuilder();
		notes.forEach(note -> mergedNotes.append(note).append("\n"));
		return mergedNotes.toString();
	}

	// Private method to normalize a term
	private String normalizeTerm(String term) {
		return term.replaceAll("é", "e").toLowerCase();
	}

	/**
     * Counts the occurrences of unique terms in a given note.
     *
     * @param note         The note to be analyzed.
     * @param termsToCheck An array of terms to check for occurrences.
     * @return The count of unique terms found in the note.
     */
	public int countUniqueTerms(String note, String[] termsToCheck) {
		Map<String, Integer> uniqueTerms = new HashMap<>();

		// Normalize the string to NFD form and remove diacritics
		note = Normalizer.normalize(note, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
				.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();

		// Divide the note into words
		String[] words = note.split("\\s+");

		// Check each term in the list of terms to check
		for (String term : termsToCheck) {
			String normalizedTerm = normalizeTerm(term);
			for (String word : words) {
				if (word.equals(normalizedTerm)) {
					uniqueTerms.put(term, uniqueTerms.getOrDefault(term, 0) + 1);
					 System.out.println("Mot trouvé : " + term);
					break;
				}
			}
		}
		logger.info("Count Terms: " + uniqueTerms.size());
		return uniqueTerms.size();
	}
}
