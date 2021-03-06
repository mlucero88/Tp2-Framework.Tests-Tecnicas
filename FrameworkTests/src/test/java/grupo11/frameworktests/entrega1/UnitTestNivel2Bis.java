package grupo11.frameworktests.entrega1;

import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.UnitTest;

// Padre: TestCollectionNivel1
// Hijos: -

public class UnitTestNivel2Bis extends UnitTest {
	public UnitTestNivel2Bis(String testName) {
		super(testName);
	}

	@Override
	protected void test() {
		String str = "testUnitTestNivel2Bis";
		Fixture.getInstance().addVariable("VarTestUT2Bis", str);
	}

	@Override
	protected void setUp() {
		String str = "setupUnitTestNivel2Bis";
		Fixture.getInstance().addVariable("VarSetupUT2Bis", str);
	}

	@Override
	protected void tearDown() {
		String str = "teardownUnitTestNivel2Bis";
		Fixture.getInstance().addVariable("VarTeardownUT2Bis", str);
	}
}