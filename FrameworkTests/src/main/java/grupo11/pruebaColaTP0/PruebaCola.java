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
		UnitTest test3 = new TestSize("TestColaSize");
		tests.addUnitTest(test3);
		 
		tests.runAll();
		tests.showTestResults();
		    
	}

}
