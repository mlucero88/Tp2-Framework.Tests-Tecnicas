package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;

/* Clase que almacena el resultado de un test collection */

public class TestCollectionResult extends TestResult {
	private Collection<TestResult> testsResults;
	private String resultCollectionCadenaDeNombres;

	public TestCollectionResult(String testName) {
		super(testName);
		testsResults = new ArrayList<TestResult>();
	}

	@Override
	protected boolean add(TestResult testResult) {
		if (testResult != null) {
			testsResults.add(testResult);
			return true;
		}
		return false;
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

	public void registrarResultadoEnXML(TestReportXML report) {
		report.registrarTestCollectionEnXML(resultCollectionCadenaDeNombres,
				getMessage());
		for (TestResult testResult : testsResults) {
			testResult.registrarResultadoEnXML(report);
		}
	}
}