package grupo11.frameworktests.setupclasses;

import grupo11.frameworktests.UnitTest;

// Padre: TestCollectionNivel1
// Hijos: -

public class UnitTestNivel2Bis extends UnitTest {
	/* Strings de prueba de acceso al fixture */
	protected String setUpUnitTestNivel2Bis;
	protected String tearDownUnitTestNivel2Bis;

	private static final String SETUP_STRING = "setUpUnitTestNivel2Bis";
	private static final String TEARDOWN_STRING = "tearDownUnitTestNivel2Bis";

	public UnitTestNivel2Bis(String testName) {
		super(testName);
	}

	@Override
	protected void test() {
		System.out.println("Testing UnitTestNivel2Bis...");
	}

	@Override
	protected void setUp() {
		System.out.println(SETUP_STRING);
		setUpUnitTestNivel2Bis = SETUP_STRING;
	}

	@Override
	protected void tearDown() {
		System.out.println(TEARDOWN_STRING);
		tearDownUnitTestNivel2Bis = TEARDOWN_STRING;
	}
}