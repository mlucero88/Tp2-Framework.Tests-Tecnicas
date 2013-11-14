package grupo11.frameworktests.entrega2;

import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.UnitTest;

public class T8 extends UnitTest {
	public final static String FIXTURE_SETUP_VAR_NAME = "setupT8";
	public final static Object FIXTURE_SETUP_VAR_VALUE = new Integer(8);
	public final static String FIXTURE_TEARDOWN_VAR_NAME = "teardownT8";
	public final static Object FIXTURE_TEARDOWN_VAR_VALUE = new Boolean(true);
	public final static String FIXTURE_TEST_VAR_NAME = "testT8";
	public final static Object FIXTURE_TEST_VAR_VALUE = new String("testingT8");

	public T8(String testName) {
		super(testName);
	}

	@Override
	protected void test() {
		Object variable = FIXTURE_TEST_VAR_VALUE;
		Fixture.getInstance().addVariable(FIXTURE_TEST_VAR_NAME, variable);
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