package grupo11.queue.tests;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;
import grupo11.queue.Cola;

public class TestRemoveConColaLlena extends UnitTest {
	private Cola colaDePrueba;

	public TestRemoveConColaLlena(String testName) {
		super(testName);
		colaDePrueba = new Cola();
	}

	public void test() {
		agregarElementos(3);
		colaDePrueba.remove();
		Validation.validateEquals(colaDePrueba.size(), 2);
	}

	private void agregarElementos(int cantidad) {
		for (int i = 1; i <= cantidad; i++) {
			colaDePrueba.add(new Integer(i));
		}
	}
}