package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;

/* Clase contenedora de UnitTest, encargada de ejecutar cada test unitario y
 * generar el reporte con el resultado de la corrida */

public class TestCollection extends GenericTest {
	private Collection<GenericTest> tests;

	public TestCollection(String name) {
		super(name);
		tests = new ArrayList<GenericTest>();		
	};

	@Override
	final public boolean add(GenericTest test) {
		if (NameRegister.getInstance().registerName(test.getName())) {
			tests.add(test);
			return true;
		}
		return false;
	}

	@Override
	final public TestCollectionResult run() {
		setUp();
		TestCollectionResult results = new TestCollectionResult(getName());
		for (GenericTest test : tests) {
			/* TODO manejar como se guardan los resultados */
			if(!test.isSkip()){
				TestResult result = test.run();
				results.add(result);
			}
		}
		tearDown();
		return results;
	}

	final public TestCollectionResult runSelection(String regexp) {
		setUp();
		TestCollectionResult results = new TestCollectionResult(getName());
		for (GenericTest test : tests) {
			if (test.getName().matches(regexp)) {
				/* TODO manejar como se guardan los resultados */
				/* TODO parece codigo duplicado con el run, ver si puedo hacer
				 * algo */
				TestResult result = test.run();
				results.add(result);
			}
		}
		tearDown();
		return results;
	}

	/* Retorna la cantidad de tests. Tanto un UnitTest como una test collection
	 * cuenta como un solo test */
	public int getTestsCount() {
		return tests.size();
	}

	/*Guarda los resultados de los tests en un archivo y los muestra por pantalla*/
	//public void saveAndShowTestResults() {
		//report.guardarReporte();
		//report.showAll();
	//}

	// TODO este get no me gusta, si solo se usa para los tests de junit ver
	// si se puede sacar
	//public TestReport getReport() {
		//return report;
	//}
	
	/* Metodos redefinibles por el usuario */
	@Override
	protected void setUp() {}

	@Override
	protected void tearDown() {}
}