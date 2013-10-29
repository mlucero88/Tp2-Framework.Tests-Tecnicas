package Grupo11.FrameworkTests;

/* Clase abstracta de un test unitario de la cual el cliente hereda para crear
 * su test unitario. El cliente debe implementar el metodo "test" con el
 * comportamiento que desea testear */

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
		/* TODO implementar y sacar el system.out */
		System.out.println(name + ": corriendo");
		return true;
	}
}