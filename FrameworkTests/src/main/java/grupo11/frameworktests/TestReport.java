package grupo11.frameworktests;

import grupo11.frameworktests.UnitTestResult.ResultType;

/* Clase para generar el reporte de los testsEjecutados para ser informado al
 * cliente
 * por salida estandar y por archivo */

public class TestReport {

	private TestCollectionResult results;
	private ReportWriter reportWriter = null;
	private int cantidadTotalTests = 0;
	private int cantidadTotalFailed = 0;
	private int cantidadTotalError = 0;
	private int cantidadTotalSuccesfull = 0;
	private final static String SUBRAYADO_SUMMARY =
			"============================================================";

	public TestReport(TestCollectionResult results) {
		this.results = results;
		reportWriter = new ReportWriter("TestsReport.txt");
	}

	public void generarReporteEnArchivo() {
		results.registrarResultadoEnReporte(this);
		guardarReporte();
	}

	public TestCollectionResult getResults() {
		return results;
	}

	public void registrarInicioTestSuite(String nombre) {
		reportWriter.writeEncabezadoTestSuite(nombre);
	}

	public void registrarFinTestSuite(String message) {
		reportWriter.writeMarcaFinTestSuite(message);
	}

	public void registrarUnitTestResult(ResultType type, String resultMessage) {
		reportWriter.writeResult(resultMessage);
		registrarEstadistica(type);
	}

	public void guardarReporte() {
		reportWriter.writeEncabezadoSummary();
		reportWriter.writeResult("Run: " + cantidadTotalTests);
		reportWriter.writeResult("Errors: " + cantidadTotalError);
		reportWriter.writeResult("Failures: " + cantidadTotalFailed);
		reportWriter.writeResult("Succesfull: " + cantidadTotalSuccesfull);
		reportWriter.closeSaveReport();
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

	public void mostrarEstadisticasPorPantalla() {
		System.out.println("Summary");
		System.out.println(SUBRAYADO_SUMMARY);
		System.out.println("Run: " + cantidadTotalTests);
		System.out.println("Errors: " + cantidadTotalError);
		System.out.println("Failures: " + cantidadTotalFailed);
		System.out.println("Succesfull: " + cantidadTotalSuccesfull);
	}
}