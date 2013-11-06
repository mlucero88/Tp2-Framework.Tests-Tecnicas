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
	final public TestResult run() {
		try {
			setUp();
			test();
			tearDown();
		}
		catch (ValidationFailure failure) {
			// TODO manejar
			return TestResult.createFailedResult(getName(), failure.getMessage());
		}
		catch (RuntimeException exception) {
			// TODO manejar
		}
		// TODO adapatar a los cambios
		return TestResult.createSuccessfulResult(getName());
	}
}