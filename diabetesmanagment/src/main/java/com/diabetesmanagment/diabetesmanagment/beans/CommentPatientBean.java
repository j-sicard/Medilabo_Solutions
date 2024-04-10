package com.diabetesmanagment.diabetesmanagment.beans;

public class CommentPatientBean {

		private String patId;

		private String patient;

		private String note;

		public CommentPatientBean(String patId, String patient, String note) {
			super();
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
