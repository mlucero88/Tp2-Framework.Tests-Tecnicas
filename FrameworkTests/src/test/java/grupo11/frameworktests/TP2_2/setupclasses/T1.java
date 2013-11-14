package grupo11.frameworktests.TP2_2.setupclasses;

import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.UnitTest;

public class T1 extends UnitTest {
	public T1(String testName) {
		super(testName);
	}

	@Override
	protected void test() {
		String str = "testUnitTestNivel1";
		Fixture.getInstance().addVariable("VarTestUT1", str);
	}

	@Override
	protected void setUp() {
		String str = "setupUnitTestNivel1";
		Fixture.getInstance().addVariable("VarSetupUT1", str);
	}

	@Override
	protected void tearDown() {
		String str = "teardownUnitTestNivel1";
		Fixture.getInstance().addVariable("VarTeardownUT1", str);
	}
}