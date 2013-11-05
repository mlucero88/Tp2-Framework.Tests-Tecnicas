package grupo11.queueTests;

import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.UnitTest;

public class PruebaCola {

	public static void main(String[] args) {
		TestCollection tests = new TestCollection("TestDeCola");

		UnitTest test1 = new TestColaVacia("TestColaVacia");
		tests.add(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		tests.add(test2);
		UnitTest test3 = new TestSize("TestSize");
		tests.add(test3);
		UnitTest test4 = new TestTopConColaLlena("TestTopConColaLlena");
		tests.add(test4);
		UnitTest test5 = new TestTopConColaVacia("TestTopConColaVacia");
		tests.add(test5);
		UnitTest test6 = new TestRemoveConColaVacia("TestRemoveConColaVacia");
		tests.add(test6);
		UnitTest test7 = new TestRemoveConColaLlena("TestRemoveConColaLlena");
		tests.add(test7);
		UnitTest test8 = new TestLlenarYVaciarCola("TestLlenarYVaciarCola");
		tests.add(test8);

		tests.run();
		tests.showTestResults();
	}
}