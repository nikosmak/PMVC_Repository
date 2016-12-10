package com.nlogic.semantic.ontology.jena;

public class DoctorInfo extends OntologyInfo{

	private DoctorInfo() {
		subject= "<http://dbpedia.org/resource/Surgeon>";
	}

	private static class DoctorInfoInstanceHolder {
		public static final DoctorInfo INSTANCE = new DoctorInfo();
	}

	public static DoctorInfo getInstance() {
		return DoctorInfoInstanceHolder.INSTANCE;
	}
	

}
