package grupo11.frameworktests.setupclasses;

import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.TestCollection;

// Padre: -
// Hijos: UnitTestNivel1 y TestCollectionNivel1

public class TestCollectionNivel0 extends TestCollection {
	public TestCollectionNivel0(String name) {
		super(name);
	}

	@Override
	protected void setUp() {
		String str = "setupTestCollectionNivel0";
		Fixture.getInstance().addVariable("VarSetupTC0", str);
	}

	@Override
	protected void tearDown() {
		String str = "teardownTestCollectionNivel0";
		Fixture.getInstance().addVariable("VarTeardownTC0", str);
	}
}