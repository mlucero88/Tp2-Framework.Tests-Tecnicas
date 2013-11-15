package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.jdom.Element;


/* Clase que almacena el resultado de un test collection */

public class TestCollectionResult extends TestResult {
	private Collection<TestResult> testsResults;
	private String resultCollectionCadenaDeNombres;
	int countTests, countError, countFailures;

	public TestCollectionResult(String testName) {
		super(testName);
		testsResults = new ArrayList<TestResult>();
	}

	@Override
	protected boolean add(TestResult testResult) {
		if (testResult != null) {
			testsResults.add(testResult);
			updateCounts(testResult);
			return true;
		}
		return false;
	}
	
	private void updateCounts(TestResult component) {
		countTests += component.countTests();
		countError += component.countErrors();
		countFailures += component.countFailures();
	}

	public Collection<TestResult> getTestsResults() {
		return testsResults;
	}

	public String getMessage() {
		String message =
				"Tiempo total de ejecucion de " + testName + ": "
						+ tiempoEjecucion + " ms";
		return message;
	}

	public void setCollectionResultCadenaDeNombres(String cadena) {
		resultCollectionCadenaDeNombres = cadena;
	}

	public String getCollectionResultCadenaDeNombres() {
		return resultCollectionCadenaDeNombres;
	}

	public void registrarResultadoEnReporte(TestReport report) {
		report.registrarInicioTestSuite(resultCollectionCadenaDeNombres);
		for (TestResult testResult : testsResults) {
			testResult.registrarResultadoEnReporte(report);
		}
		report.registrarFinTestSuite(getMessage());
	}


	@Override
	public Element toXMLElement() {
		Element element = new Element("testsuite");
		element.setAttribute("name", getCollectionResultCadenaDeNombres());
		element.setAttribute("tests", countTests().toString());
		element.setAttribute("failures", countFailures().toString());
		element.setAttribute("errors", countErrors().toString());
		element.setAttribute("time", String.valueOf(tiempoEjecucion));
		Iterator<TestResult> keySetIterator = testsResults.iterator();
		while (keySetIterator.hasNext()) {
			TestResult component = keySetIterator.next();
			element.addContent(component.toXMLElement());
		}
		return element;
	}
	
	
	@Override
	public Integer countTests() {
		return countTests;
	}

	@Override
	public Integer countErrors() {
		return countError;
	}

	@Override
	public Integer countFailures() {
		return countFailures;
	}
}