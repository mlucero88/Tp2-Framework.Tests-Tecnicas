package grupo11.frameworktests;

/* Ejecucion de tests cumpliendo criterios de coincidencias de una regular
 * expression */
public class RunRegularExpression extends RunTemplate {

	public RunRegularExpression(String regExp) {
		super(regExp, null);
	}

	public TestResult run(GenericTest test) {
		TestResult result = null;
		if (test.getName().matches(regExp)) {
			result = test.run();
		}
		return result;
	}
}