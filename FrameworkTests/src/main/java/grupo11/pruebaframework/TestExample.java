package grupo11.pruebaframework;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;

/* Clase auxiliar para testear el framework hasta tener los tests unitarios de
 * junit */

public class TestExample extends UnitTest {

	public TestExample(String testName) {
		super(testName);
	}

	@Override
	
	/* TODO Aca estan las pruebas para cada validate y de cada tipo. Son todas
	 * fallidas. Comentar y descomentar para probar cada cosa.
	 * Mas o menos asi tendrian que ser los tests unitarios que probarian
	 * nuestro framework... Probar tambien algun caso que de que el validate
	 * sea verdadero...
	 */
	public void test() {
		// Objetos
//		DummyClass expected = new DummyClass("string", 25, 'M');
//		DummyClass actual = new DummyClass("strong", 25, 'M');
		
		// Strings
		String expected = "Hola que tal";
		String actual = "Hola que tool";
		
		// Booleanos
//		boolean expected = true;
//		boolean actual = false;
		
		// byte
//		byte expected = 10;
//		byte actual = 9;

		// short
//		short expected = 10;
//		short actual = 9;
		
		// long
//		long expected = 100000000L;
//		long actual = 9000000000L;
		
		// int
//		int expected = 10;
//		int actual = 9;
		
		// float
//		float expected = 10.1;
//		float actual = 9.2;
		
		// double
//		double expected = 10.123;
//		double actual = 9.12314;
		
		// char
//		char expected = 'a';
//		char actual = 'A';

		/* TODO hay alguna forma de sacar Validation. ? */

		Validation.validateEquals(expected, actual);
		
//		Validation.validateTrue(false);
//		Validation.validateFalse(true);
		
//		DummyClass objNull = null;
//		Validation.validateNull(objNull);

//		DummyClass objNoNull = new DummyClass("asd", 0, 'a');
//		Validation.validateNull(objNoNull);
	}
}