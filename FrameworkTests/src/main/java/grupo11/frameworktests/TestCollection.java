package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;

/* Clase contenedora de UnitTest, encargada de ejecutar cada test unitario y
 * generar el reporte con el resultado de la corrida */

public class TestCollection {

	private Collection<UnitTest> tests;
	private TestReport report;

	public TestCollection() {
		tests = new ArrayList<UnitTest>();
		report = new TestReport();
	};

	public void runAll() {
		for (UnitTest test : tests) {
			report.addTestResult(test.run());
		}
	}

	public void addUnitTest(UnitTest test) {
		tests.add(test);
	}

	public void showTestResults() {
		report.showAll();
	}
	
	public Collection<UnitTest> getTests() {
		return tests;
	}

	public TestReport getReport() {
		return report;
	}

}