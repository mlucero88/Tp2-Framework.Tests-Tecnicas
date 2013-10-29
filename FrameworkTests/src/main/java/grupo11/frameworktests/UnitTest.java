package grupo11.frameworktests;

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

	boolean run() {
		try {
			test();
		}
		catch(AssertionError error) {
			logError(error);
			return false;
		}
		return true;
	}
	
	private void logError(AssertionError error) {
		String errorMessage = name + ": " + error.getMessage(); 
		// TODO loguear el mensaje de error en el TestReport o algo en lugar de
		// mostrarlo por pantalla
		System.out.println(errorMessage);
	}
}