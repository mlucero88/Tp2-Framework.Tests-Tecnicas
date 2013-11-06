package grupo11.frameworktests.setupclasses;

import grupo11.frameworktests.UnitTest;

// Padre: TestCollectionNivel1
// Hijos: -

public class UnitTestNivel2 extends UnitTest {
	/* Strings de prueba de acceso al fixture */
	protected String setUpUnitTestNivel2;
	protected String tearDownUnitTestNivel2;

	private static final String SETUP_STRING = "setUpUnitTestNivel2";
	private static final String TEARDOWN_STRING = "tearDownUnitTestNivel2";

	public UnitTestNivel2(String testName) {
		super(testName);
	}

	@Override
	protected void test() {
		System.out.println("Testing UnitTestNivel2...");
	}

	@Override
	protected void setUp() {
		System.out.println(SETUP_STRING);
		setUpUnitTestNivel2 = SETUP_STRING;
	}

	@Override
	protected void tearDown() {
		System.out.println(TEARDOWN_STRING);
		tearDownUnitTestNivel2 = TEARDOWN_STRING;
	}
}