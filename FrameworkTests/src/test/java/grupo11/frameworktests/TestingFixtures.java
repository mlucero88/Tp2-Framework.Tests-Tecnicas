package grupo11.frameworktests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

public class TestingFixtures {
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
	public void setUp() {
		String varMain = "VAR_MAIN";
		Fixture.getInstance().addVariable("VarMain", varMain);
	}

	@After
	public void tearDown() {
		NameRegister.getInstance().clear();
		Fixture.getInstance().clear();
	}

	@Test
	public void testExistsFalse() {
		assertFalse(Fixture.getInstance().existsVariable("VarSetupTC0"));
		assertFalse(Fixture.getInstance().existsVariable("VarTeardownTC0"));
		assertFalse(Fixture.getInstance().existsVariable("VarSetupTC1"));
		assertFalse(Fixture.getInstance().existsVariable("VarTeardownTC1"));
		assertFalse(Fixture.getInstance().existsVariable("VarSetupUT1"));
		assertFalse(Fixture.getInstance().existsVariable("VarTeardownUT1"));
		assertFalse(Fixture.getInstance().existsVariable("VarSetupUT2"));
		assertFalse(Fixture.getInstance().existsVariable("VarTeardownUT2"));
		assertFalse(Fixture.getInstance().existsVariable("VarSetupUT2Bis"));
		assertFalse(Fixture.getInstance().existsVariable("VarTeardownUT2Bis"));
	}

	@Test
	public void testExistsTrue() {
		/* Prueba del agregado de variables al fixture */
		testsNivel0.run(null, null);

		assertTrue(Fixture.getInstance().existsVariable("VarMain"));
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
	public void testValues() {
		/* Prueba algunos valores del fixture */
		testsNivel0.run(null, null);
		
		assertEquals("VAR_MAIN", Fixture.getInstance().getVariable("VarMain"));
		assertEquals("setupUnitTestNivel2",
				Fixture.getInstance().getVariable("VarSetupUT2"));
		assertEquals("teardownTestCollectionNivel1", Fixture.getInstance()
				.getVariable("VarTeardownTC1"));
	}

	@Test
	public void testRemove() {
		assertTrue(Fixture.getInstance().existsVariable("VarMain"));
		Fixture.getInstance().removeVariable("VarMain");
		assertFalse(Fixture.getInstance().existsVariable("VarMain"));
	}
	
	@Test
	public void testAddDuplicate() {
		assertTrue(Fixture.getInstance().existsVariable("VarMain"));
		String newStr = "NEW_MAIN";
		Fixture.getInstance().addVariable("VarMain", newStr);
		assertEquals("NEW_MAIN", Fixture.getInstance().getVariable("VarMain"));
	}
}