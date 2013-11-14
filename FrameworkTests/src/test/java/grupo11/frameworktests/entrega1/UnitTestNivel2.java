package grupo11.frameworktests.entrega1;

import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.UnitTest;

// Padre: TestCollectionNivel1
// Hijos: -

public class UnitTestNivel2 extends UnitTest {
	public UnitTestNivel2(String testName) {
		super(testName);
	}

	@Override
	protected void test() {
		String str = "testUnitTestNivel2";
		Fixture.getInstance().addVariable("VarTestUT2", str);
	}

	@Override
	protected void setUp() {
		String str = "setupUnitTestNivel2";
		Fixture.getInstance().addVariable("VarSetupUT2", str);
	}

	@Override
	protected void tearDown() {
		String str = "teardownUnitTestNivel2";
		Fixture.getInstance().addVariable("VarTeardownUT2", str);
	}
}