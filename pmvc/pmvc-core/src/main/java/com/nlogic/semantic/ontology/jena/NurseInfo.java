package com.nlogic.semantic.ontology.jena;

public class NurseInfo extends OntologyInfo {

	private NurseInfo() {
		subject="<http://dbpedia.org/resource/Nursing>";
	}

	private static class NurseInfoInstanceHolder {
		public static final NurseInfo INSTANCE = new NurseInfo();
	}

	public static NurseInfo getInstance() {
		return NurseInfoInstanceHolder.INSTANCE;
	}
	

}
