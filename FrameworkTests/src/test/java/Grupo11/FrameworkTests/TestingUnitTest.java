package Grupo11.FrameworkTests;

import static org.junit.Assert.*;
import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;

import org.junit.Before;
import org.junit.Test;

//Clase Test que prueba los metodos de la clase UnitTest

public class TestingUnitTest {
	private UnitTest unTest;
	
	@Before
	public void setUp() {
		//Seteo un test que utilizare para probar los metodos de la case.
		unTest = new UnitTest("soyUnTest") {
			
			@Override
			public void test() {
				String expected = "pruebo un test";
				String actual = "pruebo un test";
				
				Validation.validateEquals(expected, actual);
			}
		};

	}

	@Test
	public void testUnitTest() {
		String actual = unTest.getName();
		String esperado = "soyUnTest";
		
		assertEquals(esperado, actual);
	}

}
