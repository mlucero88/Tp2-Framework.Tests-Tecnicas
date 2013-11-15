package grupo11.frameworktests;

import org.jdom.Attribute;
import org.jdom.Element;

/* Clase que almacena el resultado de un unit test */

public class UnitTestResult extends TestResult {

	private String result;

	public enum ResultType {
		Ok, Fail, Error
	}

	private static ResultType resultType;

	static UnitTestResult createSuccessfulResult(String testName) {
		resultType = (ResultType.Ok);
		return new UnitTestResult(testName, "");
	}

	static UnitTestResult createFailedResult(String testName,
			String failureMessage) {
		resultType = (ResultType.Fail);
		return new UnitTestResult(testName, failureMessage);
	}

	static UnitTestResult
			createErrorResult(String testName, String errorMessage) {
		resultType = (ResultType.Error);
		return new UnitTestResult(testName, errorMessage);
	}

	public String getMessage() {
		return result;
	}

	public ResultType getResultType() {
		return resultType;
	}

	protected UnitTestResult(String testName, String resultMessage) {
		super(testName);
		result = "[" + resultType + "] " + testName + ": " + resultMessage;
	}

	@Override
	public boolean add(TestResult test) {
		return false;
	}

	@Override
	public void setTiempoEjecucion(double tiempo) {
		tiempoEjecucion = tiempo;
		result = result + " (" + tiempoEjecucion + " ms)";
	}

	public void setCollectionResultCadenaDeNombres(String contenedora) {}

	public String getCollectionResultCadenaDeNombres() {
		return null;
	}

	public void registrarResultadoEnReporte(TestReport report) {
		report.registrarUnitTestResult(resultType, result);
	}

	@Override
	public Element toXMLElement() {
		Element element = new Element("testcase");
		element.setAttribute("name", testName);
		element.setAttribute("status", status());
		element.setAttribute("time", String.valueOf(tiempoEjecucion));
		if (resultType == ResultType.Error) {
			Element error = new Element("error");
			error.setAttribute(new Attribute("message", getMessage()));
			element.addContent(error);

		} else if (resultType != ResultType.Ok) {
			Element failure = new Element("failure");
			failure.setAttribute(new Attribute("message", getMessage()));
			element.addContent(failure);

		}
		
		return element;
	}

	private String status() {
		return (resultType == ResultType.Ok)?"OK":(resultType == ResultType.Fail)?"Fail":"Error";
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