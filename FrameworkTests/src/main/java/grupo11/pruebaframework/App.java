package grupo11.pruebaframework;

import grupo11.frameworktests.TestCollection;

public class App {
	public static void main(String[] args) {
		TestCollection tests = new TestCollection();
/****************************************************************/
		/* TODO aca huele a un patron builder para no hacer esto por cada
		 * test que quiera hacer */
		TestExample unTest = new TestExample("Test Unitario 1");
		tests.addUnitTest(unTest);
/****************************************************************/
		tests.runAll();
		tests.showTestResults();
	}
}