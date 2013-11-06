package grupo11.frameworktests.setupclasses;

import grupo11.frameworktests.UnitTest;

// Padre: TestCollectionNivel0
// Hijos: -

public class UnitTestNivel1 extends UnitTest {
	/* Strings de prueba de acceso al fixture */
	protected String setUpUnitTestNivel1;
	protected String tearDownUnitTestNivel1;

	private static final String SETUP_STRING = "setUpUnitTestNivel1";
	private static final String TEARDOWN_STRING = "tearDownUnitTestNivel1";

	public UnitTestNivel1(String testName) {
		super(testName);
	}

	@Override
	protected void test() {
		System.out.println("Testing UnitTestNivel1...");
	}

	@Override
	protected void setUp() {
		System.out.println(SETUP_STRING);
		setUpUnitTestNivel1 = SETUP_STRING;
	}

	@Override
	protected void tearDown() {
		System.out.println(TEARDOWN_STRING);
		tearDownUnitTestNivel1 = TEARDOWN_STRING;
	}
}