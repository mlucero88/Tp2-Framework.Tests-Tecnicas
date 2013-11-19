package grupo11.frameworktests;

/* Clase abstracta de la cual el cliente hereda para crear su test unitario. El
 * cliente debe implementar el metodo "test" con el comportamiento que desea
 * testear */

public abstract class UnitTest extends GenericTest {

	// MOD0568 - BEGIN
	public enum ResultType {
		Ok, Fail, Error
	}

	private ResultType resultType;

	public boolean isOK() {
		return (resultType == ResultType.Ok) ? true : false;
	}
	// MOD0568 - END
	
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
		UnitTestResult result;
		double timeTotal;
		double timeStart = System.currentTimeMillis();
		try {
			setUp();
			if (!isSkippable()) {
				test();
			}
			tearDown();
			timeTotal = (System.currentTimeMillis() - timeStart);
		}
		catch (ValidationFailure failure) {
			timeTotal = (System.currentTimeMillis() - timeStart);
			result =
					UnitTestResult.createFailedResult(getName(),
							failure.getMessage());
			result.setTiempoEjecucion(timeTotal);
			System.out.println(result.getMessage());
			return result;
		}
		catch (RuntimeException exception) {
			timeTotal = (System.currentTimeMillis() - timeStart);
			result =
					UnitTestResult.createErrorResult(getName(),
							"RuntimeException");
			result.setTiempoEjecucion(timeTotal);
			System.out.println(result.getMessage());
			return result;
		}
		timeTotal = (System.currentTimeMillis() - timeStart);
		result = UnitTestResult.createSuccessfulResult(getName());
		result.setTiempoEjecucion(timeTotal);
		System.out.println(result.getMessage());
		return result;
	}

	public void setTestCollectionContenedora(String nombreContenedora) {

	}

	public String getTestCollectionContenedora() {
		return null;
	}
}