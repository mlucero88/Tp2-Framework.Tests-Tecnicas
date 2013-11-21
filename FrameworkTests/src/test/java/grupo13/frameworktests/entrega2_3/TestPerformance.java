package grupo13.frameworktests.entrega2_3;

import static org.junit.Assert.assertTrue;
import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.GenericTest;
import grupo11.frameworktests.NameRegister;
import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.TestCollectionResult;
import grupo11.frameworktests.entrega2.T2;
import grupo11.frameworktests.entrega2.T3;
import grupo11.frameworktests.entrega2.TS1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestPerformance {
	public final static int TEST_PERFORMANCE_TIME_MS = 50 ;

	
	private double expectedTime;

	@Before
	public void setUp() {
		expectedTime =TEST_PERFORMANCE_TIME_MS;
	}

	@After
	public void tearDown() {
		NameRegister.getInstance().clear();
		Fixture.getInstance().clear();
	}

	@Test
	public void testPerformanceFailingBecauseIsSlow() {
/*SLOW test, con restriccion de tiempo. Tiene que fallar. */
		TestCollection testSuite1 = new TS1("TS1");
		GenericTest test1 = new SlowTest("SlowTest");
		test1.setMaxTime(expectedTime);
		GenericTest test2 = new T2("T2");
		GenericTest test3 = new T3("T3");
		testSuite1.add(test1);
		testSuite1.add(test2);
		testSuite1.add(test3);
		TestCollectionResult result = testSuite1.run();

/* Caso
Test de performance fallido.
T1 (sin fallas o errores) que dura X + 1 con límite de X tiempo.
Correr T1
T1 debería ser fallido por tardar más tiempo.*/
		
		assertTrue("T1 deberia tardar mas del tiempo esperado", result.countErrors() == 1 );

	}
	
	
	@Test
	public void testPerformanceSlowTestPassNoTimeAssigned() {
/*SLOW test, pero sin restriccion de tiempo. Tiene que pasar. */
		TestCollection testSuite1 = new TS1("TS1");
		GenericTest test1 = new SlowTest("SlowTest");
		GenericTest test2 = new T2("T2");
		GenericTest test3 = new T3("T3");
		testSuite1.add(test1);
		testSuite1.add(test2);
		testSuite1.add(test3);
		TestCollectionResult result = testSuite1.run();
		assertTrue("T1 deberia pasar, no hay restriccion de tiempo", result.countErrors() == 0 );
	}
	
	

	 @Test
	 public void testPerformancePassBecauseIsFast() {
/*FAST test, con restriccion de tiempo. Tiene que pasar. */
			TestCollection testSuite1 = new TS1("TS1");
			GenericTest test1 = new FastTest("FastTest");
			testSuite1.add(test1);
			test1.setMaxTime(0);
			TestCollectionResult result = testSuite1.run();

	/* Caso
Test de performance exitoso.
T1 (sin fallas o errores) que dura X con límite de X + 1 tiempo.
Correr T1
T1 debería ser exitoso.*/
			
			assertTrue("T1 deberia pasar, no hay restriccion de tiempo", result.countErrors() == 0 );
	 }
	
	
}