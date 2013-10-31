package grupo11.pruebaColaTP0;

import grupo11.frameworktests.*;

public class TestTop extends UnitTest {
	
	private Cola colaDePrueba;
	
	public TestTop (String testName) {
        super(testName);	
        colaDePrueba = new Cola();
	}

	public void test() {
		 agregarElementos (3);
	     int tope = (Integer) colaDePrueba.top();
	     Validation.validateEquals(tope, 1);
	}
	
	
	private void agregarElementos(int cantidad){
		for (int i = 1; i <= cantidad ; i++){
			this.colaDePrueba.add(new Integer(i));
	    }
	}
}