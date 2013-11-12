package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;

public class TestCollectionResult extends TestResult {
	private Collection<TestResult> testsResults;
	

	public TestCollectionResult(String testName){
		super(testName);
		testsResults = new ArrayList<TestResult>();
	}

	@Override
	protected boolean add(TestResult testResult) {
		testsResults.add(testResult);
		return false;
	}
	
}
