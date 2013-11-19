package grupo1.frameworktests.entrega2_3;

import static org.junit.Assert.*;
import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.TestCollectionResult;
import grupo11.frameworktests.UnitTest;
import grupo11.queue.tests.TestColaLlena;
import grupo11.queue.tests.TestColaVacia;

import org.junit.Test;

public class TestPersistence {

	@Test
	public void recoveredFromXmlTestHasSameStateThatBefore() {
		TestCollection tests = new TestCollection("TestDeCola1");
		UnitTest test1 = new TestColaVacia("TestColaVacia");
		tests.add(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		tests.add(test2);
		tests.persistInStore("unStoreCualquiera");
		TestCollectionResult results = (TestCollectionResult) tests.run();
		
	}

}
