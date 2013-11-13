package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;

/* Clase contenedora de UnitTest, encargada de ejecutar cada test unitario y
 * generar el reporte con el resultado de la corrida */

public class TestCollection extends GenericTest {
	private Collection<GenericTest> tests;
	private RunTemplate runMethod;

	public TestCollection(String name) {
		super(name);
		tests = new ArrayList<GenericTest>();
		// Construye con un template "RunAll" por defecto
		runMethod = new RunAll();
	};

	public void setRunMethod(RunTemplate runMethod) {
		this.runMethod = runMethod;
	}

	@Override
	final public boolean add(GenericTest test) {
		if (NameRegister.getInstance().registerName(test.getName())) {
			tests.add(test);
			return true;
		}
		return false;
	}

	@Override
	/* Utiliza el patron Template Method para las distintas formas de correr
	 * los tests */
	final public TestCollectionResult run() {
		setUp();
		TestCollectionResult results = new TestCollectionResult(getName());
		for (GenericTest test : tests) {
			if (!test.isSkippable()) {
				TestResult result = runMethod.run(test);
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

	/* Metodos redefinibles por el usuario */
	@Override
	protected void setUp() {}

	@Override
	protected void tearDown() {}
}