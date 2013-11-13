package grupo11.frameworktests;

/* Clase abstracta de la cual el cliente hereda para crear su test unitario. El
 * cliente debe implementar el metodo "test" con el comportamiento que desea
 * testear */

public abstract class UnitTest extends GenericTest {

	public UnitTest(String testName) {
		super(testName);
	}

	/* Metodo que tiene el comportamiento a testear. Es llamado por "run" */
	protected abstract void test();

	/* Redefinibles por el usuario si se le desea dar comportamiento */
	@Override
	protected void setUp() {}

	@Override
	protected void tearDown() {}

	/* Sin comportamiento. Falencia de diseño en el patron Composite */
	@Override
	final protected boolean add(GenericTest test) {
		return false;
	}

	@Override
	final public UnitTestResult run() {
		try {
			setUp();
			test();
			tearDown();
		}
		catch (ValidationFailure failure) {
			return UnitTestResult.createFailedResult(getName(),
					failure.getMessage());
		}
		catch (RuntimeException exception) {
			return UnitTestResult.createErrorResult(getName(),
					"RuntimeException");
		}
		return UnitTestResult.createSuccessfulResult(getName());
	}
}