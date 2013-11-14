package grupo11.frameworktests;

public class RunAll extends RunTemplate {

	public RunAll() {
		super();
	}

	public TestResult run(GenericTest test) {
		return test.run();
	}
}