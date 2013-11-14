package grupo11.frameworktests.TP2_2.setupclasses;

import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.TestCollection;

public class TS1 extends TestCollection {
	public TS1(String name) {
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