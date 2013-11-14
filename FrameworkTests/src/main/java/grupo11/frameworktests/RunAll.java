package grupo11.frameworktests;

/* Ejecucion de todos los tests */
public class RunAll extends RunTemplate {

	public RunAll() {
		super();
	}

	public TestResult run(GenericTest test) {
		return test.run();
	}
}