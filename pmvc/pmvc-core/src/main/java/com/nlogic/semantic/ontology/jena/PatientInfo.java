package com.nlogic.semantic.ontology.jena;

public class PatientInfo extends OntologyInfo {

	private PatientInfo() {
		subject = "<http://dbpedia.org/resource/Patient>";
	}

	private static class PatientInfoInstanceHolder {
		public static final PatientInfo INSTANCE = new PatientInfo();
	}

	public static PatientInfo getInstance() {
		return PatientInfoInstanceHolder.INSTANCE;
	}

}
