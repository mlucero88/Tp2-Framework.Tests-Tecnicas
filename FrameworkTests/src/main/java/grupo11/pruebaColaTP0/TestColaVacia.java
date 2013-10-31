package grupo11.pruebaColaTP0;


import grupo11.frameworktests.*;

public class TestColaVacia extends UnitTest {
	
	private Cola colaDePrueba;
	
	public TestColaVacia (String testName) {
        super(testName);	
        colaDePrueba = new Cola();
	}

	public void test() {
		 Validation.validateTrue(colaDePrueba.isEmpty());
	}
}
