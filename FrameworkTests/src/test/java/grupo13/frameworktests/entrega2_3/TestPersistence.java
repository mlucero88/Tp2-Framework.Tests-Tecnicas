package grupo13.frameworktests.entrega2_3;

import grupo11.frameworktests.NameRegister;
import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.UnitTest;
import grupo11.queue.tests.TestColaLlena;
import grupo11.queue.tests.TestColaVacia;

import org.junit.Assert;
import org.junit.Test;

public class TestPersistence {

	@Test
	public void recoveredFromXmlTestHasSameCountTestsThatBefore() {
		TestCollection tests = new TestCollection("TestDeCola1");
		UnitTest test1 = new TestColaVacia("TestColaVacia");
		tests.add(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		tests.add(test2);
		tests.setStore("unStoreCualquiera");
		tests.storeMode();
		tests.run();
		NameRegister.getInstance().clear();
		TestCollection tests2 = new TestCollection("TestDeCola1");
		tests2.setStore("unStoreCualquiera");
		tests2.recoverMode();
		tests2.run();
		Assert.assertEquals(tests.countTests(), tests2.countTests());

	}
	
	@Test
	public void recoveredFromXmlTestHasSameCountFailuresThatBefore() {
		TestCollection tests = new TestCollection("TestDeCola1");
		UnitTest test1 = new TestColaVacia("TestColaVacia");
		tests.add(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		tests.add(test2);
		tests.setStore("unStoreCualquiera");
		tests.storeMode();
		tests.run();
		NameRegister.getInstance().clear();
		TestCollection tests2 = new TestCollection("TestDeCola1");
		tests2.setStore("unStoreCualquiera");
		tests2.recoverMode();
		tests2.run();
		Assert.assertEquals(tests.countFailures(), tests2.countFailures());

	}
	
	@Test
	public void recoveredFromXmlTestHasSameCountErrorsThatBefore() {
		TestCollection tests = new TestCollection("TestDeCola1");
		UnitTest test1 = new TestColaVacia("TestColaVacia");
		tests.add(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		tests.add(test2);
		tests.setStore("unStoreCualquiera");
		tests.storeMode();
		tests.run();
		NameRegister.getInstance().clear();
		TestCollection tests2 = new TestCollection("TestDeCola1");
		tests2.setStore("unStoreCualquiera");
		tests2.recoverMode();
		tests2.run();
		Assert.assertEquals(tests.countErrors(), tests2.countErrors());

	}
	
	@Test
	public void runningRecoveredFromXmlSkipsTestsAlreadyPassed() {
		TestCollection tests = new TestCollection("TestDeCola1");
		UnitTest test1 = new TestColaVacia("TestColaVacia");
		tests.add(test1);
		tests.setStore("unStoreCualquiera");
		tests.storeMode();
		tests.run();
		NameRegister.getInstance().clear();
		TestCollection tests2 = new TestCollection("TestDeCola1");
		tests2.setStore("unStoreCualquiera");
		tests2.recoverMode();
		tests2.run();
		UnitTest recoveredTest = (UnitTest) tests2.getTests().get(0);
		Assert.assertTrue(recoveredTest.isSkippable());

	}

}
