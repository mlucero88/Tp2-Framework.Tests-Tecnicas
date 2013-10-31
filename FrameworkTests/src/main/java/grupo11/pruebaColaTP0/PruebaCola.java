package grupo11.pruebaColaTP0;
import grupo11.frameworktests.*;

public class PruebaCola {
	
	public static void main(String[] args) {
		TestCollection tests = new TestCollection();
		/* TODO aca huele a un patron builder para no hacer esto por cada
		 * test que quiera hacer */
			UnitTest unTest = new TestColaVacia("TestColaVacia");
		    tests.addUnitTest(unTest);
		    tests.runAll();
		    tests.showTestResults();
		    
	}

}
