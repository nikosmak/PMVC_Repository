package com.nlogic.semantic.ontology.jena;



import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;


public class OntologyInfo {

	protected String subject = "";

	public String getInfo() {
		StringBuilder result = new StringBuilder();
		String queryString = "SELECT ?abstract "
				+ "WHERE { "
				+ "{ "+subject+" <http://dbpedia.org/ontology/abstract> ?abstract. "
				+ " FILTER langMatches( lang(?abstract), 'en') } " + "}";

		Query query = QueryFactory.create(queryString);

		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.sparqlService(
				"http://dbpedia.org/sparql", query);
		ResultSet results = qe.execSelect();

		
			while (results.hasNext()) {
				QuerySolution row = results.next();

				Literal label = row.getLiteral("abstract");
				System.out.println(label.getString());
				result.append(label.toString());
			}
		
		// Output query results
		// ResultSetFormatter.out(System.out, results, query);

		// Important - free up resources used running the query
		qe.close();
		return result.toString().substring(0,100);
	}
}
