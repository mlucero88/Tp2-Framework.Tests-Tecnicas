package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;

public class TestCollectionResult extends TestResult {
	private Collection<TestResult> testsResults;

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
		String message = "Tiempo total de ejecucion de " + testName + ": " + tiempoEjecucion + " ms";
		return message;
	}
	
	
}