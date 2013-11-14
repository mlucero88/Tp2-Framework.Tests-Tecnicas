package grupo11.frameworktests;

import grupo11.frameworktests.UnitTestResult.ResultType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;

/* Clase para generar el reporte de los testsEjecutados para ser informado al cliente
 * por salida estandar y por archivo*/

public class TestReport {

	private Collection<TestResult> results;
	private ReportWriter reportWriter= null; 
	private int cantidadTotalTests = 0;
	private int cantidadTotalFailed = 0;
	private int cantidadTotalError = 0;

	public TestReport(TestCollectionResult results) {
		this.results = results.getTestsResults();
		reportWriter = new ReportWriter("TestsReport.txt");
	}

	public void generarReporteEnArchivo(){
		for (TestResult result : results) {
			/* TODO manejar como se guardan los resultados */
			registrarTestResult(result);
		}
		guardarReporte();
	}
	
	public Collection<TestResult> getResults() {
		return results;
	}
	
	public void registrarInicioTestSuite(String nombre){
		reportWriter.writeLineaEnBlanco();
		reportWriter.writeEncabezadoTestSuite(nombre);
	}
	
	public void registrarTestResult (TestResult result){
		reportWriter.writeResult(result.getMessage());
//		registrarEstadistica(unitTestResult.getResultType());	
		
	}
	
		
	public void finalizarRegistroTestSuite(String nombreTestSuite){
		reportWriter.writeMarcaFinTestSuite(nombreTestSuite);
	}
	
	public void guardarReporte (){
		reportWriter.writeEncabezadoSummary();
		reportWriter.writeResult("Run: " + cantidadTotalTests);
		reportWriter.writeResult("Errors: " + cantidadTotalError);
		reportWriter.writeResult("Failures: " + cantidadTotalFailed);
		reportWriter.closeSaveReport();
	}
	
	private void registrarEstadistica (ResultType type){
		cantidadTotalTests++;
		switch (type) {
		case Fail:
			cantidadTotalFailed++;
			break;
		case Error:
			cantidadTotalError++;
		default:
			break;
		}
	}
}