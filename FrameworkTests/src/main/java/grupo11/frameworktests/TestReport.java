package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;

/* Clase que almacena una coleccion de TestResult para ser informada al cliente
 * por salida estandar */

public class TestReport {

	private Collection<TestResult> results;

	public TestReport() {
		results = new ArrayList<TestResult>();
	}

	public void addTestResult(TestResult result) {
		results.add(result);
	}

	public void clear() {
		results.clear();
	}

	/* Imprime por salida estandar el resultado de cada test */
	/* TODO Como variacion, se puede hacer que lo escriba en un log */
	public void showAll() {
		ReportWriter reportWriter = new ReportWriter("TestsReport.txt");
		for (TestResult result : results) {
			System.out.println(result.getMessage());
			reportWriter.writeResult(result.getMessage());
		}
		reportWriter.closeSaveReport();
	}

	public Collection<TestResult> getResults() {
		return results;
	}
}