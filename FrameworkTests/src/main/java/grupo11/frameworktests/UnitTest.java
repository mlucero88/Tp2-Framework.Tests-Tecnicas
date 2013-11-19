package grupo11.frameworktests;

import org.jdom.Attribute;
import org.jdom.Element;

/* Clase abstracta de la cual el cliente hereda para crear su test unitario. El
 * cliente debe implementar el metodo "test" con el comportamiento que desea
 * testear */

public abstract class UnitTest extends GenericTest {

	public enum ResultType {
		Ok, Fail, Error
	}

	private ResultType resultType;
	double timeTotal;
	String errorMsg = new String("");

	public boolean isOK() {
		return (resultType == ResultType.Ok);
	}
	
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
			errorMsg = failure.getMessage();
			result =
					UnitTestResult.createFailedResult(getName(),
							errorMsg);
			result.setTiempoEjecucion(timeTotal);
			System.out.println(result.getMessage());
			return result;
		}
		catch (RuntimeException exception) {
			timeTotal = (System.currentTimeMillis() - timeStart);
			errorMsg = "RuntimeException";
			result =
					UnitTestResult.createErrorResult(getName(),
							errorMsg);
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
	
	@Override
	public Element toXMLElement() {
		Element element = new Element("testcase");
		element.setAttribute("name", getName());
		element.setAttribute("status", resultType.name());
		element.setAttribute("time", String.valueOf(timeTotal));
		if (resultType != ResultType.Ok) {
			element.setAttribute(new Attribute("message", errorMsg));
		}

		return element;
	}
	
	@Override
	public int countTests() {
		return 1;
	}

	@Override
	public int countErrors() {
		return (resultType == ResultType.Error) ? 1 : 0;
	}

	@Override
	public int countFailures() {
		return (resultType == ResultType.Fail) ? 1 : 0;
	}
}