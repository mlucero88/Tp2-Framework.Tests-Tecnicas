package grupo11.frameworktests;

import junit.framework.AssertionFailedError;

/* Clase abstracta de la cual el cliente hereda para crear su test unitario. El
 * cliente debe implementar el metodo "test" con el comportamiento que desea
 * testear */

public abstract class UnitTest {
	private String name;

	public UnitTest(String testName) {
		name = testName;
	}

	public String getName() {
		return name;
	}

	/* Metodo que tiene el comportamiento a testear. Es llamado por "run" */
	public abstract void test();

	//Metodo vacio que el usuario podra redefinir en caso que lo requiera
	public void setUp(){
		
	}

	//Metodo vacio que el usuario podra redefinir en caso que lo requiera
	public void tearDown(){
		
	}
	
	TestResult run() {
		try {
			setUp();
			test();
			tearDown();
		}
		catch (AssertionError error) {
			return TestResult.createFailedResult(name, error.getMessage());
		}
		//TODO: Buscar jerarquia de error de excepciones para capturarlas.
		
		return TestResult.createSuccessfulResult(name);
	}
}