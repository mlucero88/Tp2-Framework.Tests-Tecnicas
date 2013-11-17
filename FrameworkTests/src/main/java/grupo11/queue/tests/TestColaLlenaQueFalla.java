package grupo11.queue.tests;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;
import grupo11.queue.Cola;

public class TestColaLlenaQueFalla  extends UnitTest {
	private Cola colaDePrueba;

	public TestColaLlenaQueFalla(String testName) {
		super(testName);
		colaDePrueba = new Cola();
	}

	public void test() {
		int elem = 4;
		colaDePrueba.add(elem);
		Validation.validateTrue(colaDePrueba.isEmpty());
	}

}
