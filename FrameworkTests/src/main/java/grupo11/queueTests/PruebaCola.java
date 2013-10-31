package grupo11.queueTests;

import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.UnitTest;

public class PruebaCola {

	public static void main(String[] args) {
		TestCollection tests = new TestCollection();

		UnitTest test1 = new TestColaVacia("TestColaVacia");
		tests.addUnitTest(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		tests.addUnitTest(test2);
		UnitTest test3 = new TestSize("TestSize");
		tests.addUnitTest(test3);
		UnitTest test4 = new TestTopConColaLlena("TestTopConColaLlena");
		tests.addUnitTest(test4);
		UnitTest test5 = new TestTopConColaVacia("TestTopConColaVacia");
		tests.addUnitTest(test5);
		UnitTest test6 = new TestRemoveConColaVacia("TestRemoveConColaVacia");
		tests.addUnitTest(test6);
		UnitTest test7 = new TestRemoveConColaLlena("TestRemoveConColaLlena");
		tests.addUnitTest(test7);
		UnitTest test8 = new TestLlenarYVaciarCola("TestLlenarYVaciarCola");
		tests.addUnitTest(test8);

		tests.runAll();
		tests.showTestResults();
	}
}