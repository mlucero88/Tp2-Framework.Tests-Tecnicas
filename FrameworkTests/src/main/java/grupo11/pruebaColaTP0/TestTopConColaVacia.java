package grupo11.pruebaColaTP0;

import grupo11.frameworktests.*;

public class TestTopConColaVacia extends UnitTest {
	
	private Cola colaDePrueba;
	
	public TestTopConColaVacia (String testName) {
        super(testName);	
        colaDePrueba = new Cola();
	}

	public void test() {
		try{
			int elem = (Integer) colaDePrueba.top();
	    }
	    catch (AssertionError e){
	    	Validation.validateTrue(true);
	    }
	}
	
}