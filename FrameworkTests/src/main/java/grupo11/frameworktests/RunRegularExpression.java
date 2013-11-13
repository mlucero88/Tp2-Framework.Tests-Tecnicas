package grupo11.frameworktests;

public class RunRegularExpression extends RunTemplate {

	public RunRegularExpression(String regExp) {
		super(regExp, null);
	}

	public TestResult run(GenericTest test) {
		TestResult result = null;
		if ((!test.isSkippable()) && test.getName().matches(regExp)) {
			result = test.run();
		}
		return result;
	}
}