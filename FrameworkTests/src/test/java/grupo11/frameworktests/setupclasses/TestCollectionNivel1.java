package grupo11.frameworktests.setupclasses;

import grupo11.frameworktests.TestCollection;

// Padre: TestCollectionNivel0
// Hijos: UnitTestNivel2 y UnitTestNivel2Bis

public class TestCollectionNivel1 extends TestCollection {
	/* Strings de prueba de acceso al fixture */
	protected String setupTestCollectionNivel1;
	protected String tearDownTestCollectionNivel1;

	private static final String SETUP_STRING = "setupTestCollectionNivel1";
	private static final String TEARDOWN_STRING =
			"tearDownTestCollectionNivel1";

	public TestCollectionNivel1(String name) {
		super(name);
	}

	@Override
	protected void setUp() {
		System.out.println(SETUP_STRING);
		setupTestCollectionNivel1 = SETUP_STRING;
	}

	@Override
	protected void tearDown() {
		System.out.println(TEARDOWN_STRING);
		tearDownTestCollectionNivel1 = TEARDOWN_STRING;
	}
}