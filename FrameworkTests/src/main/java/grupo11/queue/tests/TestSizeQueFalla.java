package grupo11.queue.tests;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;
import grupo11.queue.Cola;

public class TestSizeQueFalla extends UnitTest {
	private Cola colaDePrueba;

	public TestSizeQueFalla(String testName) {
		super(testName);
		colaDePrueba = new Cola();
	}

	public void test() {

		agregarElementos(3);
		Validation.validateEquals(this.colaDePrueba.size(), 67);

	}

	private void agregarElementos(int cantidad) {
		for (int i = 1; i <= cantidad; i++) {
			this.colaDePrueba.add(new Integer(i));
		}
	}
}