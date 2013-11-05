package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.*;

/* Clase contenedora de UnitTest, encargada de ejecutar cada test unitario y
 * generar el reporte con el resultado de la corrida */

public class TestCollection extends GenericTest{

	private Collection<GenericTest> tests;
	private TestReport report;
	private TestResult resultado;
	
	public TestCollection(String nombre) {
		super(nombre);
		tests = new ArrayList<GenericTest>();
		report = new TestReport();
		resultado = new TestCollectionResult(null);
	};

	@Override
	public TestResult run() {
		setUp();
		for (GenericTest test : tests) {
			report.addTestResult(test.run());
		}
		tearDown();
		return resultado;
	}

	@Override
	public void add(GenericTest test) {
		if (!validarNombre(test.getNombre())){
			tests.add(test);
		}else{
			String mensaje = "The name is used in another";
			report.addTestResult(TestResult.createFailedResult(test.getNombre(), mensaje));
		}
	}

	public void showTestResults() {
		report.showAll();
	}

	public Collection<GenericTest> getTests() {
		return tests;
	}

	public TestReport getReport() {
		return report;
	}

	@Override
	public void setUp(){

	}

	@Override
	public void tearDown(){
		
	}
	
	public void runSelection(String regexp){
		setUp();
		for(GenericTest test:tests){
			if(test.getNombre().matches(regexp)){
				report.addTestResult(test.run());
			}
		}
		tearDown();
	}

	public boolean validarNombre(String nombreGenericTest){
		boolean repetido = false;
		for (GenericTest test:tests){
			if(test.getNombre().equals(nombreGenericTest)){
				repetido = true;
			}
		}
		return repetido;
	}
}