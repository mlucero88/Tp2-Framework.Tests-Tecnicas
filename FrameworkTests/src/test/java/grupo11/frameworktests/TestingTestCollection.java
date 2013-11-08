package grupo11.frameworktests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

// Clase Test que prueba los metodos de la clase TestCollection

public class TestingTestCollection {
	private TestCollection unTestCollection;
	private UnitTest unTest;
	private UnitTest dosTest;

	@Before
	public void setUp() {
		// Seteo un test y la Collection que alberga todos los test que
		// utilizare para probar los metodos de la clase
		unTestCollection = new TestCollection("soyUnSuite");
		unTest = new UnitTest("soyUnTest") {
			@Override
			public void test() {
				String expected = "pruebo un test";
				String actual = "pruebo un test";
				Validation.validateEquals(expected, actual);
			}
		};
		dosTest = new UnitTest("soyOtroTest") {
			@Override
			public void test() {
				String expected = "pruebo dos test";
				String actual = "pruebo dos test";
				Validation.validateEquals(expected, actual);
			}
		};

	}

	@Test
	public void agregarUnTestaLaCollection() {
		unTestCollection.add(unTest);
		unTestCollection.add(dosTest);
		
		int esperado = 2;
		int actual = unTestCollection.getTestsCount();

		assertEquals(esperado, actual);
	}

	@Test
	public void agregarUnTestCollectionaLaCollection() {
		TestCollection dosSuiteTests = new TestCollection("SoyOtroTestCollection");
		
		unTestCollection.add(dosSuiteTests);
		int esperado = 2;
		int actual = unTestCollection.getTestsCount();
		assertEquals(esperado, actual);
	}

	@Test
	public void correrLosTestdeLaCollectionTest() {
		unTestCollection.add(unTest);
		unTestCollection.run();
		int esperado = 1;
		int actual = unTestCollection.getReport().getResults().size();
		assertEquals(actual, esperado);
	}

	
	@Test
	public void mostrarResultadoDeUnTestDeLaCollection() {
		unTestCollection.add(unTest);
		unTestCollection.run();
		unTestCollection.saveAndShowTestResults();

		// Me traigo el arrayList de resultados mostrados por pantalla
		ArrayList<TestResult> arrayResultado = (ArrayList<TestResult>) unTestCollection.getReport().getResults();
		
		// Me guardo el mensaje arrojado por el run que se muestra por pantalla
		String actual = arrayResultado.get(0).getMessage();
		
		
		assertEquals("[Ok] " + unTest.getName(), actual);
	}

	@Test
	public void UnicidadNombreDeTest() {
		unTestCollection.add(dosTest);
		//Pongo el mismo nombre a los Test y trato de agregarlos
		unTest.setName("soyOtroTest");
		
		boolean actual = false;
		boolean esperado = unTestCollection.add(dosTest);

		assertEquals(actual, esperado);
	}

}