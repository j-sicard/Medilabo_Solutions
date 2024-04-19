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

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	McommentProxy mcommentProxy;
	
	private static final Logger logger = Logger.getLogger(CommentServiceImpl.class.getName());


	public List<CommentPatientBean> getAllCommentForOnePatient(String Patient) {
		return mcommentProxy.findAllCommentOfOnePatient(Patient);
	}

	public List<String> getNotes(List<CommentPatientBean> listComment) {
		List<String> notes = new ArrayList<>();
		listComment.forEach(commentPatient -> notes.add(commentPatient.getNote()));
		return notes;
	}

	public String mergeNotes(List<String> notes) {
		StringBuilder mergedNotes = new StringBuilder();
		notes.forEach(note -> mergedNotes.append(note).append("\n"));
		return mergedNotes.toString();
	}

	private String normalizeTerm(String term) {
		return term.replaceAll("é", "e").toLowerCase();
	}

	public int countUniqueTerms(String note, String[] termsToCheck) {
		Map<String, Integer> uniqueTerms = new HashMap<>();

		// Normaliser la chaîne en forme NFD et retirer les caractères diacritiques
		note = Normalizer.normalize(note, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
				.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();

		// Diviser la note en mots
		String[] words = note.split("\\s+");

		// Vérifier chaque terme dans la liste des termes à vérifier
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
