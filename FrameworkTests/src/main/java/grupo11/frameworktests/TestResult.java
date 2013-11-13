package grupo11.frameworktests;

/* Clase que almacena el resultado de un UnitTest */

public abstract class TestResult {
	protected String testName;
	protected double tiempoEjecucion;

	
	protected TestResult (String testName){
		this.testName = testName;
	}
	
	public String getTestName() {
		return testName;
	}

	protected abstract boolean add(TestResult test);

	public abstract String getMessage();
	
	public void setTiempoEjecucion (double tiempo){
		tiempoEjecucion = tiempo;
	}
	
}