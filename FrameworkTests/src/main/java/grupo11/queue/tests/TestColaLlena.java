package grupo11.queue.tests;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;
import grupo11.queue.Cola;

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