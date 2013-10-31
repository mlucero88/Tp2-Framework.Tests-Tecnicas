package grupo11.pruebaColaTP0;


import grupo11.frameworktests.*;

public class TestRemoveConColaLlena extends UnitTest {
	
	private Cola colaDePrueba;
	
	public TestRemoveConColaLlena (String testName) {
        super(testName);	
        colaDePrueba = new Cola();
	}

	public void test() {
		agregarElementos (3);
		colaDePrueba.remove();
		Validation.validateEquals (colaDePrueba.size(), 2);
	}
	
	private void agregarElementos(int cantidad){
        for (int i = 1; i <= cantidad ; i++){
            colaDePrueba.add(new Integer(i));
        }
    }
	
}

