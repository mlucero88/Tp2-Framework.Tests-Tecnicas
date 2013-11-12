package grupo11.frameworktests;

/* Clase que almacena el resultado de un UnitTest */

public abstract class TestResult {
	private String testName;
	
	protected TestResult (String testName){
		this.testName = testName;
	}
	
	public String getTestName() {
		return testName;
	}

	protected abstract boolean add(TestResult test);

	public String getMessage(){
		return null;
	}	
	
}