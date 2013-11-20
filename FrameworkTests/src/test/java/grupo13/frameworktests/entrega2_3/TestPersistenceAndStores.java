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

public class TestPersistenceAndStores {
	
	TestCollection initialTestCollection1;
	TestCollection initialTestCollection2;
	TestCollection testCollectionRecoveredFromStore1;
	UnitTest failingUnitTest;
	TestCollection testCollectionRecoveredFromStore2;
	
	@Before
	public void setup() {
		initialTestCollection1 = new TestCollection("TestDeCola1");
		UnitTest test1 = new TestColaVacia("TestColaVacia");
		initialTestCollection1.add(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		initialTestCollection1.add(test2);
		failingUnitTest = new TestColaLlenaQueFalla("TestColaLlenaQueFalla");
		initialTestCollection1.add(failingUnitTest);
		initialTestCollection1.setStore("unStoreCualquiera");
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
		initialTestCollection2.setStore("unStoreCualquiera");
		initialTestCollection2.storeMode();
		initialTestCollection2.run();
		NameRegister.getInstance().clear();
		testCollectionRecoveredFromStore1 = new TestCollection("TestDeCola1");
		testCollectionRecoveredFromStore1.setStore("unStoreCualquiera");
		testCollectionRecoveredFromStore1.recoverMode();
		testCollectionRecoveredFromStore1.run();

		NameRegister.getInstance().clear();
		testCollectionRecoveredFromStore2 = new TestCollection("TestDeCola1");
		testCollectionRecoveredFromStore2.setStore("unStoreCualquiera");
		testCollectionRecoveredFromStore2.recoverMode();
		testCollectionRecoveredFromStore2.run();
	}

	@Test
	public void recoveredFromXmlTestHasSameCountTestsThatBefore() {

		Assert.assertEquals(initialTestCollection1.countTests(), testCollectionRecoveredFromStore1.countTests());

	}
	
	@Test
	public void recoveredFromXmlTestHasSameCountFailuresThatBefore() {

		Assert.assertEquals(initialTestCollection1.countFailures(), testCollectionRecoveredFromStore1.countFailures());

	}
	
	@Test
	public void recoveredFromXmlTestHasSameCountErrorsThatBefore() {

		Assert.assertEquals(initialTestCollection1.countErrors(), testCollectionRecoveredFromStore1.countErrors());

	}
	
	@Test
	public void runningRecoveredFromXmlContainsTestAlreadyExecuted() {

		Assert.assertTrue(testCollectionRecoveredFromStore1.getTests().containsKey("TestColaVacia"));

	}
	
	@Test
	public void recoveredFromXmlTestIsSkippedWhenPassedBefore() {
		
		UnitTest unitTest = (UnitTest)testCollectionRecoveredFromStore1.getTests().get("TestColaVacia");
		Assert.assertTrue(unitTest.isSkippable());

	}
	
	@Test
	public void recoveredFromXmlTestIsntSkippedWhenFailedBefore() {
		
		UnitTest unitTest = (UnitTest)testCollectionRecoveredFromStore1.getTests().get("TestColaLlenaQueFalla");
		Assert.assertFalse(unitTest.isSkippable());

	}
	
	
	@Test
	public void testsFailAAsExpected() {
		
		Assert.assertFalse(failingUnitTest.isOK());

	}
	
	@Test
	public void twoCollectionsCanBesavedAndRecoveredFromTheSameStore() {
		
		Assert.assertEquals(initialTestCollection1.countTests(), testCollectionRecoveredFromStore1.countTests());
		Assert.assertEquals(initialTestCollection2.countTests(), testCollectionRecoveredFromStore2.countTests());

	}

}
