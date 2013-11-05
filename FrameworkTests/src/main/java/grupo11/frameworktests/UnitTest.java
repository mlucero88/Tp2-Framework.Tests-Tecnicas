package grupo11.frameworktests;

import junit.framework.AssertionFailedError;

/* Clase abstracta de la cual el cliente hereda para crear su test unitario. El
 * cliente debe implementar el metodo "test" con el comportamiento que desea
 * testear */

public abstract class UnitTest extends GenericTest{

	public UnitTest(String testName) {
		super(testName);
	}

	/* Metodo que tiene el comportamiento a testear. Es llamado por "run" */
	public abstract void test();

	@Override
	public void setUp(){
		
	}

	@Override
	public void tearDown(){
		
	}
	
	@Override
	public void add(GenericTest test){
		
	}
	
	@Override
	public TestResult run() {
		try {
			setUp();
			test();
			tearDown();
		}
		catch (AssertionError error) {
			return TestResult.createFailedResult(nombre, error.getMessage());
		}
		//TODO: Buscar jerarquia de error de excepciones para capturarlas.
		
		return TestResult.createSuccessfulResult(nombre);
	}
}