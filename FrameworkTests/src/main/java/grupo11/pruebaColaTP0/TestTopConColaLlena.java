package grupo11.pruebaColaTP0;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;

public class TestTopConColaLlena extends UnitTest {
	private Cola colaDePrueba;

	public TestTopConColaLlena(String testName) {
		super(testName);
		colaDePrueba = new Cola();
	}

	public void test() {
		agregarElementos(3);
		int tope = (Integer) colaDePrueba.top();
		Validation.validateEquals(tope, 1);
	}

	private void agregarElementos(int cantidad) {
		for (int i = 1; i <= cantidad; i++) {
			colaDePrueba.add(new Integer(i));
		}
	}
}