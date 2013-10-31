package grupo11.pruebaColaTP0.Tests;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;
import grupo11.pruebaColaTP0.Cola;

public class TestColaLlena extends UnitTest {
	private Cola colaDePrueba;

	public TestColaLlena(String testName) {
		super(testName);
		colaDePrueba = new Cola();
	}

	public void test() {
		int elem = 4;
		colaDePrueba.add(elem);
		Validation.validateFalse(colaDePrueba.isEmpty());
	}
}