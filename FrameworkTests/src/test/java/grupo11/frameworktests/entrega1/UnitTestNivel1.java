package grupo11.frameworktests.entrega1;

import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.UnitTest;

// Padre: TestCollectionNivel0
// Hijos: -

public class UnitTestNivel1 extends UnitTest {
	public UnitTestNivel1(String testName) {
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