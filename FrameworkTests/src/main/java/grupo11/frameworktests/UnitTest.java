package grupo11.frameworktests;

/* Clase abstracta de la cual el cliente hereda para crear su test unitario. El
 * cliente debe implementar el metodo "test" con el comportamiento que desea
 * testear */

public abstract class UnitTest {
	private String name;

	public UnitTest(String testName) {
		name = testName;
	}

	public String getName() {
		return name;
	}

	/* Metodo que tiene el comportamiento a testear. Es llamado por "run" */
	public abstract void test();

	TestResult run() {
		try {
			test();
		}
		catch (AssertionError error) {
			return TestResult.createFailedResult(name, error.getMessage());
		}
		return TestResult.createSuccessfulResult(name);
	}
}