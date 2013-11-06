package grupo11.frameworktests.setupclasses;

import grupo11.frameworktests.TestCollection;

// Padre: -
// Hijos: UnitTestNivel1 y TestCollectionNivel1

public class TestCollectionNivel0 extends TestCollection {
	/* Strings de prueba de acceso al fixture */
	protected String setupTestCollectionNivel0;
	protected String tearDownTestCollectionNivel0;

	private static final String SETUP_STRING = "setupTestCollectionNivel0";
	private static final String TEARDOWN_STRING =
			"tearDownTestCollectionNivel0";

	public TestCollectionNivel0(String name) {
		super(name);
	}

	@Override
	protected void setUp() {
		System.out.println(SETUP_STRING);
		setupTestCollectionNivel0 = SETUP_STRING;
	}

	@Override
	protected void tearDown() {
		System.out.println(TEARDOWN_STRING);
		tearDownTestCollectionNivel0 = TEARDOWN_STRING;
	}
}