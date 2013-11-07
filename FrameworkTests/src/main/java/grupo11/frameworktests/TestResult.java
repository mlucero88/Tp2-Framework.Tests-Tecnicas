package grupo11.frameworktests;

/* Clase que almacena el resultado de un UnitTest */

class TestResult {
	private final static String MESSAGE_SUCCESSFUL = "OK";
	private final static String MESSAGE_FAILURE = "Fail";
	private final static String MESSAGE_ERROR = "Error";
	private String result;

	static TestResult createSuccessfulResult(String testName) {
		return new TestResult("[" + MESSAGE_SUCCESSFUL + "] " + testName);
	}

	static TestResult createFailedResult(String testName, String failureMessage) {
		return new TestResult("[" + MESSAGE_FAILURE + "] " + testName);
	}

	static TestResult createErrorResult(String testName, String errorMessage) {
		return new TestResult("[" + MESSAGE_ERROR + "] " + testName);
	}

	public String getMessage() {
		return result;
	}

	protected TestResult(String resultMessage) {
		result = resultMessage;
	}
}