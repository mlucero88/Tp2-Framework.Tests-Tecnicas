package grupo11.queue.tests;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;
import grupo11.queue.Cola;

public class TestSize extends UnitTest {
	private Cola colaDePrueba;

	public TestSize(String testName) {
		super(testName);
		colaDePrueba = new Cola();
	}

	public void test() {
		Validation.validateEquals(this.colaDePrueba.size(), 0);
		agregarElementos(3);
		Validation.validateEquals(this.colaDePrueba.size(), 3);
		agregarElementos(5);
		Validation.validateEquals(this.colaDePrueba.size(), 8);
	}

	private void agregarElementos(int cantidad) {
		for (int i = 1; i <= cantidad; i++) {
			this.colaDePrueba.add(new Integer(i));
		}
	}
}