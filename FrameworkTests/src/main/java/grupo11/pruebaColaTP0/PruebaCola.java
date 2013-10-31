package grupo11.pruebaColaTP0;
import grupo11.frameworktests.*;

public class PruebaCola {
	
	public static void main(String[] args) {
		TestCollection tests = new TestCollection();
		/* TODO aca huele a un patron builder para no hacer esto por cada
		 * test que quiera hacer */
			
		UnitTest test1 = new TestColaVacia("TestColaVacia");
		tests.addUnitTest(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		tests.addUnitTest(test2);
		UnitTest test3 = new TestSize("TestSize");
		tests.addUnitTest(test3);
		UnitTest test4 = new TestSize("TestTop");
		tests.addUnitTest(test4);
		UnitTest test5 = new TestSize("TestTopConColaVacia");
		tests.addUnitTest(test5);
		 
		tests.runAll();
		tests.showTestResults();
		    
	}

}
