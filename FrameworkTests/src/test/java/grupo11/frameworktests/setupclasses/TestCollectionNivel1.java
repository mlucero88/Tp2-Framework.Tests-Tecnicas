package grupo11.frameworktests.setupclasses;

import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.TestCollection;

// Padre: TestCollectionNivel0
// Hijos: UnitTestNivel2 y UnitTestNivel2Bis

public class TestCollectionNivel1 extends TestCollection {
	public TestCollectionNivel1(String name) {
		super(name);
	}

	@Override
	protected void setUp() {
		String str = "setupTestCollectionNivel1";
		Fixture.getInstance().addVariable("VarSetupTC1", str);
	}

	@Override
	protected void tearDown() {
		String str = "teardownTestCollectionNivel1";
		Fixture.getInstance().addVariable("VarTeardownTC1", str);
	}
}