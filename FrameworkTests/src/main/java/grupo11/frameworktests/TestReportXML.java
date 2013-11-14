package grupo11.frameworktests;

import grupo11.frameworktests.UnitTestResult.ResultType;

// TODO implementar
public class TestReportXML {

	private TestCollectionResult results;
	private XMLWriter fileWriter;
	private int cantidadTotalTests = 0;
	private int cantidadTotalFailed = 0;
	private int cantidadTotalError = 0;
	private int cantidadTotalSuccesfull = 0;

	public TestReportXML(TestCollectionResult results) {
		this.results = results;
		fileWriter = new XMLWriter("TestsReport.xml");
	}

	public void generarReporteXML() {
		results.registrarResultadoEnXML(this);
		guardarReporte();
	}

	public void registrarUnitTestEnXML(ResultType type, String resultMessage) {
		// Aca va la parte en que se genera el texto de XML para el
		// UnitTestResult
		registrarEstadistica(type);
	}

	public void registrarTestCollectionEnXML(String nombreEncadenado,
			String message) {
		// Hay que ver que ponemos en el XML del TestCollectionResult
	}

	public void guardarReporte() {
		guardarEstadisticasEnXML();
		fileWriter.closeSaveReportXML();
	}

	private void registrarEstadistica(ResultType type) {
		cantidadTotalTests++;
		switch (type) {
		case Fail:
			cantidadTotalFailed++;
			break;
		case Error:
			cantidadTotalError++;
		case Ok:
			cantidadTotalSuccesfull++;
		default:
			break;
		}
	}

	private void guardarEstadisticasEnXML() {}
}