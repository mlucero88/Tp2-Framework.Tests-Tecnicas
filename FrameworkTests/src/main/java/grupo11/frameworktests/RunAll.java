package grupo11.frameworktests;

public class RunAll extends RunTemplate {

	public RunAll() {
		super(null, null);
	}

	public TestResult run(GenericTest test) {
		return test.run();
	}
}