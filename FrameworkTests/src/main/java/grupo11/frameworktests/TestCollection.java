package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;

/* Clase contenedora de UnitTest, encargada de ejecutar cada test unitario y
 * generar el reporte con el resultado de la corrida */

public class TestCollection extends GenericTest {
	private Collection<GenericTest> tests;
	private TestReport report;
	private TestResult result;

	public TestCollection(String name) {
		super(name);
		tests = new ArrayList<GenericTest>();
		report = new TestReport();
		result = new TestCollectionResult(null);
	};

	@Override
	final public void add(GenericTest test) {
		if (NameRegister.getInstance().registerName(test.getName())) {
			tests.add(test);
		}
		else {
			/* TODO manejar caso el nombre ya existe */
			String mensaje = "The name is used in another";
			report.addTestResult(TestResult.createFailedResult(
					test.getName(), mensaje));
		}
	}

	@Override
	final public TestResult run() {
		setUp();
		for (GenericTest test : tests) {
			/* TODO manejar como se guardan los resultados */
			report.addTestResult(test.run());
		}
		tearDown();
		return result;
	}

	final public void runSelection(String regexp) {
		setUp();
		for (GenericTest test : tests) {
			if (test.getName().matches(regexp)) {
				/* TODO manejar como se guardan los resultados */
				/* TODO parece codigo duplicado con el run, ver si puedo hacer
				 * algo */
				report.addTestResult(test.run());
			}
		}
		tearDown();
	}
	
	/* Retorna la cantidad de tests. Tanto un UnitTest como una test collection
	 * cuenta como un solo test */
	public int getTestsCount() {
		return tests.size();
	}

	public void showTestResults() {
		report.showAll();
	}

	// TODO este get no me gusta, si solo se usa para los tests de junit ver
	// si se puede sacar
	public TestReport getReport() {
		return report;
	}

	/* Metodos redefinibles por el usuario */
	@Override
	protected void setUp() {}

	@Override
	protected void tearDown() {}
}