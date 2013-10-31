package grupo11.pruebaColaTP0;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;

public class TestLlenarYVaciarCola extends UnitTest {
	private Cola colaDePrueba;

	public TestLlenarYVaciarCola(String testName) {
		super(testName);
		colaDePrueba = new Cola();
	}

	public void test() {
		agregarElementos(3);
		int tope = (Integer) colaDePrueba.top();
		Validation.validateEquals(tope, 1);
		colaDePrueba.remove();
		tope = (Integer) colaDePrueba.top();
		Validation.validateEquals(tope, 2);
		colaDePrueba.remove();
		tope = (Integer) colaDePrueba.top();
		Validation.validateEquals(tope, 3);
		colaDePrueba.remove();
		Validation.validateTrue(colaDePrueba.isEmpty());
	}

	private void agregarElementos(int cantidad) {
		for (int i = 1; i <= cantidad; i++) {
			colaDePrueba.add(new Integer(i));
		}
	}
}