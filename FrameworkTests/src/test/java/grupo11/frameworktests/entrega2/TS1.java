package grupo11.frameworktests.entrega2;

import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.TestCollection;

public class TS1 extends TestCollection {
	public final static String FIXTURE_SETUP_VAR_NAME = "setupTS1";
	public final static Object FIXTURE_SETUP_VAR_VALUE = new Integer(-1);
	public final static String FIXTURE_TEARDOWN_VAR_NAME = "teardownTS1";
	public final static Object FIXTURE_TEARDOWN_VAR_VALUE = new Boolean(false);

	public TS1(String name) {
		super(name);
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