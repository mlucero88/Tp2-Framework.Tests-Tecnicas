package grupo11.queue.tests;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;
import grupo11.queue.Cola;

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