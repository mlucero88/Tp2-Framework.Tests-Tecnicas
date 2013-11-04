package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.*;

/* Clase contenedora de UnitTest, encargada de ejecutar cada test unitario y
 * generar el reporte con el resultado de la corrida */

public class TestCollection {

	private Collection<UnitTest> tests;
	private TestReport report;
	private String nombreSuite;

	public TestCollection(String nombre) {
		tests = new ArrayList<UnitTest>();
		report = new TestReport();
		nombreSuite = nombre;
	};

	public void runAll() {
		setUp();
		for (UnitTest test : tests) {
			report.addTestResult(test.run());
		}
		tearDown();
	}

	public void addUnitTest(UnitTest test) {
		if (!validarNombre(test.getName())){
			tests.add(test);
		}else{
			String mensaje = "The name is used in another";
			report.addTestResult(TestResult.createFailedResult(test.getName(), mensaje));
		}
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

	public String getNombre() {
		return nombreSuite;
	}
	
	public void setNombreSuite(String nombreSuite) {
		this.nombreSuite = nombreSuite;
	}

	//Metodo vacio que el usuario podra redefinir en caso que lo requiera
	public void setUp(){

	}

	//Metodo vacio que el usuario podra redefinir en caso que lo requiera
	public void tearDown(){
		
	}
	
	public void runSelection(String regexp){
		setUp();
		for(UnitTest test:tests){
			if(test.getName().matches(regexp)){
				report.addTestResult(test.run());
			}
		}
		tearDown();
	}

	public boolean validarNombre(String nombreUnitTest){
		boolean repetido = false;
		for (UnitTest test:tests){
			if(test.getName().equals(nombreUnitTest)){
				repetido = true;
			}
		}
		return repetido;
	}
}