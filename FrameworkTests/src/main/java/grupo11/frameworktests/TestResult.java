package grupo11.frameworktests;

/* Clase que almacena el resultado de un test generico */

public abstract class TestResult {
	protected String testName;
	protected double tiempoEjecucion;

	protected TestResult(String testName) {
		this.testName = testName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTiempoEjecucion(double tiempo) {
		tiempoEjecucion = tiempo;
	}

	protected abstract boolean add(TestResult test);

	public abstract String getMessage();

	public abstract void setCollectionResultCadenaDeNombres(String cadena);

	public abstract String getCollectionResultCadenaDeNombres();

	public abstract void registrarResultadoEnReporte(TestReport report);

	public abstract void registrarResultadoEnXML(TestReportXML report);
}