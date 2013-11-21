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

public class TestPersistence {
	
	private TestCollection initialTestCollection1;
	private TestCollection initialTestCollection2;
	private TestCollection testCollection1RecoveredFromStore;
	private UnitTest failingUnitTest;
	private TestCollection testCollection2RecoveredFromStore;
	
	@Before
	public void setup() {
		NameRegister.getInstance().clear();
		initialTestCollection1 = new TestCollection("TestDeCola1");
		UnitTest test1 = new TestColaVacia("TestColaVacia");
		initialTestCollection1.add(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		initialTestCollection1.add(test2);
		failingUnitTest = new TestColaLlenaQueFalla("TestColaLlenaQueFalla");
		initialTestCollection1.add(failingUnitTest);
		initialTestCollection1.setStore("unStoreCualquiera10");
		initialTestCollection1.storeMode();
		initialTestCollection1.run();
		
		NameRegister.getInstance().clear();
		initialTestCollection2 = new TestCollection("TestDeCola2");
		UnitTest test21 = new TestColaVacia("TestColaVacia");
		initialTestCollection2.add(test21);
		UnitTest test22 = new TestColaLlena("TestColaLlena");
		initialTestCollection2.add(test22);
		UnitTest failingUnitTest2 = new TestColaLlenaQueFalla("TestColaLlenaQueFalla");
		initialTestCollection2.add(failingUnitTest2);
		initialTestCollection2.setStore("unStoreCualquiera10");
		initialTestCollection2.storeMode();
		initialTestCollection2.run();
		
		NameRegister.getInstance().clear();
		testCollection1RecoveredFromStore = new TestCollection("TestDeCola1");
		testCollection1RecoveredFromStore.setStore("unStoreCualquiera10");
		testCollection1RecoveredFromStore.recoverMode();
		testCollection1RecoveredFromStore.recover();
		testCollection1RecoveredFromStore.run();
		
		NameRegister.getInstance().clear();
		testCollection2RecoveredFromStore = new TestCollection("TestDeCola1");
		testCollection2RecoveredFromStore.setStore("unStoreCualquiera10");
		testCollection2RecoveredFromStore.recoverMode();
		testCollection2RecoveredFromStore.recover();
		testCollection2RecoveredFromStore.run();
	}

	@Test
	public void recoveredFromXmlTestHasSameCountTestsThatBefore() {

		Assert.assertEquals(initialTestCollection1.countTests(), testCollection1RecoveredFromStore.countTests());

	}
	
	@Test
	public void recoveredFromXmlTestHasSameCountFailuresThatBefore() {

		Assert.assertEquals(initialTestCollection1.countFailures(), testCollection1RecoveredFromStore.countFailures());

	}
	
	@Test
	public void recoveredFromXmlTestHasSameCountErrorsThatBefore() {

		Assert.assertEquals(initialTestCollection1.countErrors(), testCollection1RecoveredFromStore.countErrors());

	}
	
	@Test
	public void runningRecoveredFromXmlContainsTestAlreadyExecuted() {

		Assert.assertTrue(testCollection1RecoveredFromStore.getTests().containsKey("TestColaVacia"));

	}
	
	@Test
	public void recoveredFromXmlTestIsSkippedWhenPassedBefore() {
		
		UnitTest unitTest = (UnitTest)testCollection1RecoveredFromStore.getTests().get("TestColaVacia");
		Assert.assertTrue(unitTest.isSkippable());

	}
	
	@Test
	public void recoveredFromXmlTestIsntSkippedWhenFailedBefore() {
		
		UnitTest unitTest = (UnitTest)testCollection1RecoveredFromStore.getTests().get("TestColaLlenaQueFalla");
		Assert.assertFalse(unitTest.isSkippable());
	}
	
	
	@Test
	public void testsFailAAsExpected() {
		
		Assert.assertFalse(failingUnitTest.isOK());
	}
	
	@Test
	public void twoCollectionsCanBeSavedToAndRecoveredFromTheSameStore() {
		
		Assert.assertEquals(initialTestCollection1.countTests(), testCollection1RecoveredFromStore.countTests());
		Assert.assertEquals(initialTestCollection2.countTests(), testCollection2RecoveredFromStore.countTests());
	}
	
	@Test
	public void recoveredTestWasCorrectedThenHasOneFailureLess() {
		TestCollection tc1 = new TestCollection("TestDeCola1");
		UnitTest test1 = new TestColaVacia("TestColaVacia");
		tc1.add(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		tc1.add(test2);
		UnitTest test3 = new TestColaLlenaQueFalla("TestColaLlenaQueFalla");
		tc1.add(test3);
		tc1.setStore("unStoreDePrueba");
		tc1.storeMode();
		tc1.run();
		
		//Levanto los tests haciendo que el test que fallo ahora pase
		
		NameRegister.getInstance().clear();
		TestCollection tc2 = new TestCollection("TestDeCola1");
		//fuerzo que TestColaLlenaQueFalla pase instanciando otro UnitTest con el mismo nombre
		UnitTest failedTestThatWasCorrected = new TestColaLlena("TestColaLlenaQueFalla");
		
		tc2.setStore("unStoreDePrueba");
		tc2.recoverMode();
		tc2.recover();
		tc2.add(failedTestThatWasCorrected);
		tc2.run();
		
		Assert.assertEquals(tc1.countFailures() - 1, tc2.countFailures());
	}

}
