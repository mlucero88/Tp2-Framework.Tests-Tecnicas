package grupo11.frameworktests.entrega2;

import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.UnitTest;

public class T4 extends UnitTest {
	public final static String FIXTURE_SETUP_VAR_NAME = "setupU4";
	public final static Object FIXTURE_SETUP_VAR_VALUE = new Integer(4);
	public final static String FIXTURE_TEARDOWN_VAR_NAME = "teardownU4";
	public final static Object FIXTURE_TEARDOWN_VAR_VALUE = new Boolean(true);
	public final static String FIXTURE_TEST_VAR_NAME = "testU4";
	public final static Object FIXTURE_TEST_VAR_VALUE = new String("testingU4");

	public T4(String testName) {
		super(testName);
	}

	@Override
	protected void test() {
		Object variable = FIXTURE_TEST_VAR_VALUE;
		Fixture.getInstance().addVariable(FIXTURE_TEST_VAR_NAME, variable);
		/* Ciclo para que el test arroje resultados de tiempo mas notorios */
		for (int i = 0; i < 1000000; ++i) {}
	}

	@Override
	protected void setUp() {
		Object variable = FIXTURE_SETUP_VAR_VALUE;
		Fixture.getInstance().addVariable(FIXTURE_SETUP_VAR_NAME, variable);
	}

	@Override
	protected void tearDown() {
		Object variable = FIXTURE_TEARDOWN_VAR_VALUE;
		Fixture.getInstance().addVariable(FIXTURE_TEARDOWN_VAR_NAME, variable);
	}
}