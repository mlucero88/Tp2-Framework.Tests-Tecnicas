package grupo11.pruebaColaTP0.Tests;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;
import grupo11.pruebaColaTP0.Cola;

public class TestColaVacia extends UnitTest {
	private Cola colaDePrueba;

	public TestColaVacia(String testName) {
		super(testName);
		colaDePrueba = new Cola();
	}

	public void test() {
		Validation.validateTrue(colaDePrueba.isEmpty());
	}
}