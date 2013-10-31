package grupo11.queueTests;
import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;
import grupo11.ColaTp0.Cola;

public class TestTopConColaVacia extends UnitTest {
	private Cola colaDePrueba;

	public TestTopConColaVacia(String testName) {
		super(testName);
		colaDePrueba = new Cola();
	}

	public void test() {
		try {
			colaDePrueba.top();
		}
		catch (AssertionError e) {
			Validation.validateTrue(true);
		}
	}
}