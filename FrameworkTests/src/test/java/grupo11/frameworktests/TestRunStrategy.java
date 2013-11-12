package grupo11.frameworktests;

import static org.junit.Assert.assertTrue;
import grupo11.frameworktests.setupclasses.TestCollectionNivel0;
import grupo11.frameworktests.setupclasses.TestCollectionNivel1;
import grupo11.frameworktests.setupclasses.UnitTestNivel1;
import grupo11.frameworktests.setupclasses.UnitTestNivel2;
import grupo11.frameworktests.setupclasses.UnitTestNivel2Bis;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRunStrategy {
	private static TestCollection testsNivel0;

	@BeforeClass
	public static void setUpClass() {
		testsNivel0 = new TestCollectionNivel0("CollectionNivel0");
		GenericTest unTestNivel1 = new UnitTestNivel1("UnitNivel1");
		GenericTest testsNivel1 = new TestCollectionNivel1("CollectionNivel1");
		GenericTest unTestNivel2 = new UnitTestNivel2("UnitNivel2");
		GenericTest unTestNivel2Bis = new UnitTestNivel2Bis("UnitNivel2Bis");

		testsNivel0.add(unTestNivel1);
		testsNivel0.add(testsNivel1);
		testsNivel1.add(unTestNivel2);
		testsNivel1.add(unTestNivel2Bis);
	}

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {
		NameRegister.getInstance().clear();
		Fixture.getInstance().clear();
	}

	@Test
	public void testRunAll() {
		RunStrategy strategy = new RunAll();
		testsNivel0.setRunStrategy(strategy);
		testsNivel0.run(null, null);

		/* Si se guardan las variables en los fixtures es porque se ejecutaron
		 * los tests */
		assertTrue(Fixture.getInstance().existsVariable("VarSetupTC0"));
		assertTrue(Fixture.getInstance().existsVariable("VarTeardownTC0"));
		assertTrue(Fixture.getInstance().existsVariable("VarSetupTC1"));
		assertTrue(Fixture.getInstance().existsVariable("VarTeardownTC1"));
		assertTrue(Fixture.getInstance().existsVariable("VarSetupUT1"));
		assertTrue(Fixture.getInstance().existsVariable("VarTeardownUT1"));
		assertTrue(Fixture.getInstance().existsVariable("VarSetupUT2"));
		assertTrue(Fixture.getInstance().existsVariable("VarTeardownUT2"));
		assertTrue(Fixture.getInstance().existsVariable("VarSetupUT2Bis"));
		assertTrue(Fixture.getInstance().existsVariable("VarTeardownUT2Bis"));
	}

	@Test
	public void testRunRegEx() {
		RunStrategy strategy = new RunAll();
		testsNivel0.setRunStrategy(strategy);
		testsNivel0.run(".*Nivel1.*", null);

		/* Si se guardan las variables en los fixtures es porque se ejecutaron
		 * los tests */
//		assertTrue(Fixture.getInstance().existsVariable("VarSetupTC0"));
//		assertTrue(Fixture.getInstance().existsVariable("VarTeardownTC0"));
//		assertTrue(Fixture.getInstance().existsVariable("VarSetupTC1"));
//		assertTrue(Fixture.getInstance().existsVariable("VarTeardownTC1"));
//		assertTrue(Fixture.getInstance().existsVariable("VarSetupUT1"));
//		assertTrue(Fixture.getInstance().existsVariable("VarTeardownUT1"));
//		assertTrue(Fixture.getInstance().existsVariable("VarSetupUT2"));
//		assertTrue(Fixture.getInstance().existsVariable("VarTeardownUT2"));
//		assertTrue(Fixture.getInstance().existsVariable("VarSetupUT2Bis"));
//		assertTrue(Fixture.getInstance().existsVariable("VarTeardownUT2Bis"));
	}
}