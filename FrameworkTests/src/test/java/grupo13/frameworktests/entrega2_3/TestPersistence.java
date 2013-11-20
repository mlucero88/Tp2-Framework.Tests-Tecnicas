package grupo13.frameworktests.entrega2_3;

import grupo11.frameworktests.NameRegister;
import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.UnitTest;
import grupo11.queue.tests.TestColaLlena;
import grupo11.queue.tests.TestColaVacia;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPersistence {
	
	TestCollection initialTestCollection;
	TestCollection testCollectionRecoveredFromStore;
	
	@Before
	public void setup() {
		initialTestCollection = new TestCollection("TestDeCola1");
		UnitTest test1 = new TestColaVacia("TestColaVacia");
		initialTestCollection.add(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		initialTestCollection.add(test2);
		initialTestCollection.setStore("unStoreCualquiera");
		initialTestCollection.storeMode();
		initialTestCollection.run();
		NameRegister.getInstance().clear();
		testCollectionRecoveredFromStore = new TestCollection("TestDeCola1");
		testCollectionRecoveredFromStore.setStore("unStoreCualquiera");
		testCollectionRecoveredFromStore.recoverMode();
		testCollectionRecoveredFromStore.run();
	}

	@Test
	public void recoveredFromXmlTestHasSameCountTestsThatBefore() {

		Assert.assertEquals(initialTestCollection.countTests(), testCollectionRecoveredFromStore.countTests());

	}
	
	@Test
	public void recoveredFromXmlTestHasSameCountFailuresThatBefore() {

		Assert.assertEquals(initialTestCollection.countFailures(), testCollectionRecoveredFromStore.countFailures());

	}
	
	@Test
	public void recoveredFromXmlTestHasSameCountErrorsThatBefore() {

		Assert.assertEquals(initialTestCollection.countErrors(), testCollectionRecoveredFromStore.countErrors());

	}
	
	@Test
	public void runningRecoveredFromXmlConteinsTestAlreadyExecuted() {

		Assert.assertTrue(testCollectionRecoveredFromStore.getTests().containsKey("TestColaVacia"));

	}

}
