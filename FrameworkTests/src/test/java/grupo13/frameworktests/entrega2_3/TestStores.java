package grupo13.frameworktests.entrega2_3;

import grupo11.frameworktests.NameRegister;
import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.UnitTest;
import grupo11.queue.tests.TestColaLlena;
import grupo11.queue.tests.TestColaLlenaQueFalla;
import grupo11.queue.tests.TestColaVacia;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStores {
	
	private TestCollection initialTestCollection1;
	private TestCollection testCollection1RecoveredFromStore;
	
	@Before
	public void setup() {
		NameRegister.getInstance().clear();
		initialTestCollection1 = new TestCollection("TestDeCola1");
		UnitTest test1 = new TestColaVacia("TestColaVacia");
		initialTestCollection1.add(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		initialTestCollection1.add(test2);
		UnitTest test3 = new TestColaLlenaQueFalla("TestColaLlenaQueFalla");
		initialTestCollection1.add(test3);
		initialTestCollection1.setStore("unStoreDePrueba");
		initialTestCollection1.storeMode();
		initialTestCollection1.run();
		
		//Levanto los tests del store haciendo que el test que fallo ahora pase
		
		NameRegister.getInstance().clear();
		testCollection1RecoveredFromStore = new TestCollection("TestDeCola1");
		//fuerzo que TestColaLlenaQueFalla pase instanciando otro UnitTest con el mismo nombre
		UnitTest failedTestThatWasCorrected = new TestColaLlena("TestColaLlenaQueFalla");
		
		testCollection1RecoveredFromStore.setStore("unStoreDePrueba");
		testCollection1RecoveredFromStore.recoverMode();
		testCollection1RecoveredFromStore.recover();
		testCollection1RecoveredFromStore.add(failedTestThatWasCorrected);
		testCollection1RecoveredFromStore.run();
	}

	@Test
	public void recoveredTestWasCorrectedThenHasOneFailureLess() {

		Assert.assertEquals(initialTestCollection1.countFailures() - 1, testCollection1RecoveredFromStore.countFailures());
	}
	
	@Test
	public void previousTestFailsAndCorrectedPasses() {
		
		UnitTest unitTest1 = (UnitTest)initialTestCollection1.getTests().get("TestColaLlenaQueFalla");
		UnitTest unitTest2 = (UnitTest)testCollection1RecoveredFromStore.getTests().get("TestColaLlenaQueFalla");
		Assert.assertFalse(unitTest1.isOK());
		Assert.assertTrue(unitTest2.isOK());
	}

}
