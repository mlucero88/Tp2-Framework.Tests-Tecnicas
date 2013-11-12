package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;

/* Clase contenedora de UnitTest, encargada de ejecutar cada test unitario y
 * generar el reporte con el resultado de la corrida */

public class TestCollection extends GenericTest {
	private Collection<GenericTest> tests;
	private RunStrategy runStrategy;

	public TestCollection(String name) {
		super(name);
		tests = new ArrayList<GenericTest>();
		// Construye con una estrategia "RunAll" por defecto
		runStrategy = new RunAll();
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
	final public TestCollectionResult run(String regExp,
			Collection<TagType> tagTypes) {
		setUp();
		TestCollectionResult results =
				runStrategy.run(tests, getName(), null, null);
		tearDown();
		return results;
	}

	public void setRunStrategy(RunStrategy runStrategy) {
		this.runStrategy = runStrategy;
	}

	/* Retorna la cantidad de tests. Tanto un UnitTest como una test collection
	 * cuenta como un solo test */
	public int getTestsCount() {
		return tests.size();
	}

	/* Guarda los resultados de los tests en un archivo y los muestra por
	 * pantalla */
	// public void saveAndShowTestResults() {
	// report.guardarReporte();
	// report.showAll();
	// }

	// TODO este get no me gusta, si solo se usa para los tests de junit ver
	// si se puede sacar
	// public TestReport getReport() {
	// return report;
	// }

	/* Metodos redefinibles por el usuario */
	@Override
	protected void setUp() {}

	@Override
	protected void tearDown() {}
}