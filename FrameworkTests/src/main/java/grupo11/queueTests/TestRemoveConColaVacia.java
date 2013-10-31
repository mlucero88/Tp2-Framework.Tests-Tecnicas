package grupo11.queueTests;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;
import grupo11.ColaTp0.Cola;

public class TestRemoveConColaVacia extends UnitTest {
	private Cola colaDePrueba;

	public TestRemoveConColaVacia(String testName) {
		super(testName);
		colaDePrueba = new Cola();
	}

	public void test() {
		try {
			this.colaDePrueba.remove();
		}
		catch (AssertionError e) {
			Validation.validateTrue(true);
		}
	}
}