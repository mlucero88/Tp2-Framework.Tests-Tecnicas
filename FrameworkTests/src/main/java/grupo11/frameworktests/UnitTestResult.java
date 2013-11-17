package grupo11.frameworktests;

import org.jdom.Attribute;
import org.jdom.Element;

/* Clase que almacena el resultado de un unit test */

public class UnitTestResult extends TestResult {

	private String errorMsg = new String("");

	public enum ResultType {
		Ok, Fail, Error
	}

	private ResultType resultType;

	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

	static UnitTestResult createSuccessfulResult(String testName) {
		UnitTestResult ut = new UnitTestResult(testName);
		ut.setResultType(ResultType.Ok);
		return ut;
	}

	static UnitTestResult createFailedResult(String testName, String failureMessage) {
		UnitTestResult ut = new UnitTestResult(testName);
		ut.setResultType(ResultType.Fail);
		ut.setErrorMsg(failureMessage);
		return ut;
	}

	static UnitTestResult createErrorResult(String testName, String errorMessage) {
		UnitTestResult ut = new UnitTestResult(testName);
		ut.setResultType(ResultType.Error);
		ut.setErrorMsg(errorMessage);
		return ut;
	}
	
	static UnitTestResult createUnitTestResult(Element e) {
		UnitTestResult ut = new UnitTestResult(e.getAttributeValue("name"));
		String status = e.getAttributeValue("status");
		ut.setResultType(ResultType.valueOf(status));
		if (ut.getResultType() != ResultType.Ok ) {
			ut.setErrorMsg(e.getAttributeValue("message"));
		}
		return ut;
	}

	public String getMessage() {
		return "[" + resultType + "] " + testName + ": " + errorMsg + " (" + tiempoEjecucion + " ms)";
	}

	public ResultType getResultType() {
		return resultType;
	}

	protected UnitTestResult(String testName) {
		super(testName);
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public boolean add(TestResult test) {
		return false;
	}

	@Override
	public void setTiempoEjecucion(double tiempo) {
		tiempoEjecucion = tiempo;
	}

	public void setCollectionResultCadenaDeNombres(String contenedora) {
	}

	public String getCollectionResultCadenaDeNombres() {
		return null;
	}

	public void registrarResultadoEnReporte(TestReport report) {
		report.registrarUnitTestResult(resultType, errorMsg);
	}

	@Override
	public Element toXMLElement() {
		Element element = new Element("testcase");
		element.setAttribute("name", testName);
		element.setAttribute("status", resultType.name());
		element.setAttribute("time", String.valueOf(tiempoEjecucion));
		if (resultType != ResultType.Ok) {
			element.setAttribute(new Attribute("message", errorMsg));
		}

		return element;
	}

	@Override
	public Integer countTests() {
		return 1;
	}

	@Override
	public Integer countErrors() {
		return (resultType == ResultType.Error) ? 1 : 0;
	}

	@Override
	public Integer countFailures() {
		return (resultType == ResultType.Fail) ? 1 : 0;
	}
}