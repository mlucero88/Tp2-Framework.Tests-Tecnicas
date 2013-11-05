package grupo11.frameworktests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

// Clase Test que prueba los metodos de la clase UnitTest

public class TestingUnitTest {
	private UnitTest unTest;

	@Before
	public void setUp() {
		// Seteo un test que utilizare para probar los metodos de la clase
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
		String actual = unTest.getNombre();
		String esperado = "soyUnTest";
		assertEquals(esperado, actual);
	}
	
	@Test
	public void ValidarSetUpDeLosUnitCase(){
		UnitTest tesito = new UnitTest("unTesito") {
			
			@Override
			public void test() {
				String actual = getNombre();
				String esperado = "SoyUnTest";
				assertEquals(esperado, actual);

			}

			@Override
			public void setUp(){
				setNombre("SoyUnTest");
			}
		};
		tesito.run();
		assertEquals("SoyUnTest", tesito.getNombre());
	}

}