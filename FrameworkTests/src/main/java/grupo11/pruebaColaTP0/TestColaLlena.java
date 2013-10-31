package grupo11.pruebaColaTP0;

import grupo11.frameworktests.*;


public class TestColaLlena extends UnitTest {
	
	private Cola colaDePrueba;
	
	public TestColaLlena (String testName) {
        super(testName);	
        colaDePrueba = new Cola();
	}

	public void test() {
		 int elem = 4;
	     colaDePrueba.add(elem);
		 Validation.validateFalse(colaDePrueba.isEmpty());
	}
}
 