package Grupo11.FrameworkTests;

import java.util.ArrayList;
import java.util.Collection;

/* Clase contenedora de UnitTest, encargada de ejecutar cada test unitario
 * y generar el reporte con el resultado de la corrida */

public class TestCollection {
	private Collection<UnitTest> tests;
//	private TestReport report;

	public TestCollection() {
		tests = new ArrayList<UnitTest>();
	};

	public void runAll() {
		for (UnitTest test : tests) {
			if (test.run()) {
				
			}
			/* TODO se puede hacer que luego de correr un test, se agregue su
			 * resultado en el informe, en lugar de guardar en un collection
			 * de booleanos */
		}
	}

	public void addUnitTest(UnitTest test) {
		tests.add(test);
	}

	public void showTestCase() {
	}
}