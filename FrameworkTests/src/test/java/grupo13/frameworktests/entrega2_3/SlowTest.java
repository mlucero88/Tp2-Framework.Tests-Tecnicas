package grupo13.frameworktests.entrega2_3;

import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.UnitTest;

public class SlowTest extends UnitTest {
	public final static String FIXTURE_SETUP_VAR_NAME = "setupSlowTest";
	public final static Object FIXTURE_SETUP_VAR_VALUE = new Integer(1);
	public final static String FIXTURE_TEARDOWN_VAR_NAME = "teardownSlowTest";
	public final static Object FIXTURE_TEARDOWN_VAR_VALUE = new Boolean(false);
	public final static String FIXTURE_TEST_VAR_NAME = "testSlowTest";
	public final static Object FIXTURE_TEST_VAR_VALUE = new String("testingSlowTest");

	public SlowTest(String testName) {
		super(testName);
	}

	@Override
	protected void test() {
		for (int i = 0; i < 1000000000; ++i) {}
		for (int i = 0; i < 1000000000; ++i) {}
		for (int i = 0; i < 1000000000; ++i) {}

		Object variable = FIXTURE_TEST_VAR_VALUE;
		Fixture.getInstance().addVariable(FIXTURE_TEST_VAR_NAME, variable);
		/* Ciclo para que el test arroje resultados de tiempo mas notorios */
		for (int i = 0; i < 1000000000; ++i) {}
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