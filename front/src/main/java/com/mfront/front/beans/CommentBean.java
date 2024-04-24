package com.mfront.front.beans;

/**
 * Bean class representing a comment.
 */
public class CommentBean {
	
	private String patId;

	private String patient;

	private String note;

	public CommentBean(String patId, String patient, String note) {		
		this.patId = patId;
		this.patient = patient;
		this.note = note;
	}

	public String getPatId() {
		return patId;
	}

	public void setPatId(String patId) {
		this.patId = patId;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "CommentPatientMO [patId=" + patId + ", patient=" + patient + ", note=" + note + "]";
	}

}
