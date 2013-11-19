package grupo1.frameworktests.entrega2_3;

import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.UnitTest;

public class FastTest extends UnitTest {
	public final static String FIXTURE_SETUP_VAR_NAME = "setupFastTest";
	public final static Object FIXTURE_SETUP_VAR_VALUE = new Integer(1);
	public final static String FIXTURE_TEARDOWN_VAR_NAME = "teardownFastTest";
	public final static Object FIXTURE_TEARDOWN_VAR_VALUE = new Boolean(false);
	public final static String FIXTURE_TEST_VAR_NAME = "testFastTest";
	public final static Object FIXTURE_TEST_VAR_VALUE = new String("testingFastTest");

	public FastTest(String testName) {
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