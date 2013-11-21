package grupo11.frameworktests;

import grupo11.frameworktests.grupo13classes.AlreadyRunnedUnitTest;

import org.jdom.Attribute;
import org.jdom.DataConversionException;
import org.jdom.Element;

/* Clase abstracta de la cual el cliente hereda para crear su test unitario. El
 * cliente debe implementar el metodo "test" con el comportamiento que desea
 * testear */

public abstract class UnitTest extends GenericTest {

	public enum ResultType {
		Ok, Fail, Error, notExecuted
	}

	private ResultType resultType = ResultType.notExecuted;
	double timeTotal;
	String errorMsg = new String("");

	public boolean isOK() {
		return (resultType == ResultType.Ok);
	}

	public UnitTest(String testName) {
		super(testName);
	}

	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

	public void setTimeTotal(double timeTotal) {
		this.timeTotal = timeTotal;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/* Metodo que tiene el comportamiento a testear. Es llamado por "run" */
	protected abstract void test();

	/* Redefinibles por el usuario si se le desea dar comportamiento */
	@Override
	protected void setUp() {
	}

	@Override
	protected void tearDown() {
	}

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
			timeTotal = System.currentTimeMillis() - timeStart;
			if (getMaxTime() >0 && timeTotal >= getMaxTime()) {
								result =
										UnitTestResult.createErrorResult(getName(),
												"El tiempo de ejecucion es mayor al tiempo esperado");
								result.setTiempoEjecucion(timeTotal);
								System.out.println(result.getMessage());
								return result;			}
		} catch (ValidationFailure failure) {
			timeTotal = System.currentTimeMillis() - timeStart;
			errorMsg = failure.getMessage();
			resultType = ResultType.Fail;
			result = UnitTestResult.createFailedResult(getName(), errorMsg);
			result.setTiempoEjecucion(timeTotal);
			System.out.println(result.getMessage());
			return result;
		} catch (RuntimeException exception) {
			timeTotal = System.currentTimeMillis() - timeStart;
			errorMsg = "RuntimeException";
			resultType = ResultType.Error;
			result = UnitTestResult.createErrorResult(getName(), errorMsg);
			result.setTiempoEjecucion(timeTotal);
			System.out.println(result.getMessage());
			return result;
		}
		resultType = ResultType.Ok;
		timeTotal = System.currentTimeMillis() - timeStart;
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
		if (getName() != null) {
			element.setAttribute("name", getName());
		}
		if (resultType != null) {
			element.setAttribute("status", resultType.name());
		}
		element.setAttribute("time", String.valueOf(timeTotal));
		if (!isOK() && !(resultType == ResultType.notExecuted)) {
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

	public static GenericTest createUnitTest(Element e2) {
		
		UnitTest ut = new AlreadyRunnedUnitTest(e2.getAttributeValue("name"));
		String status = e2.getAttributeValue("status");
		ut.setResultType(ResultType.valueOf(status));
		if (ut.isOK()) {
			ut.setSkippable(true);
		} else {
			ut.setSkippable(false);

		}
		Attribute attrTime = e2.getAttribute("time");
		if (attrTime != null) {
			try {
				ut.setTimeTotal(attrTime.getDoubleValue());
			} catch (DataConversionException e) {
				e.printStackTrace();
			}
		}
		Attribute attrMessage = e2.getAttribute("message");
		if (attrMessage != null) {
			ut.setErrorMsg(attrMessage.getValue());
		}
		return ut;
	}
	
	public boolean runnable() {
		return !isSkippable();
	}
	

	public boolean isUnitTest() {
		return true;
	}

	public boolean executed() {
		return (resultType != ResultType.notExecuted);
	}
}