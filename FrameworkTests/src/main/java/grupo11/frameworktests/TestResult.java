package grupo11.frameworktests;

/* Clase que almacena el resultado de un UnitTest */

class TestResult {
	private final static String MESSAGE_SUCCESSFUL = "Succeeded";
	private final static String MESSAGE_FAILURE = "Failed";
	private String result;

	static TestResult createSuccessfulResult(String testName) {
		return new TestResult("TEST: " + testName + " - RESULT: "
				+ MESSAGE_SUCCESSFUL);
	}

	static TestResult createFailedResult(String testName, String errorMessage) {
		return new TestResult("TEST: " + testName + " - RESULT: "
				+ MESSAGE_FAILURE + " - REASON: " + errorMessage);
	}

	public String getMessage() {
		return result;
	}

	private TestResult(String resultMessage) {
		result = resultMessage;
	}
}