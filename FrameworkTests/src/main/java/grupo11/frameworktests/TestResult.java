package grupo11.frameworktests;

/* Clase que almacena el resultado de un UnitTest */

class TestResult {
	//private final static String MESSAGE_SUCCESSFUL = "OK";
	//private final static String MESSAGE_FAILURE = "Fail";
	//private final static String MESSAGE_ERROR = "Error";
	private String result;
	public enum ResultType {Ok, Fail, Error}
	private static ResultType resultType;

	static TestResult createSuccessfulResult(String testName) {
		resultType = (ResultType.Ok);
		return new TestResult("[" + resultType + "] " + testName);
	}

	static TestResult createFailedResult(String testName, String failureMessage) {
		resultType = (ResultType.Fail);
		return new TestResult("[" + resultType + "] " + testName);
	}

	static TestResult createErrorResult(String testName, String errorMessage) {
		resultType = (ResultType.Error);
		return new TestResult("[" + resultType + "] " + testName);
	}

	public String getMessage() {
		return result;
	}
	
	public ResultType getResultType (){
		return resultType;
	}

	protected TestResult(String resultMessage) {
		result = resultMessage;
	}
}