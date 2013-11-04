package grupo11.frameworktests;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

// Clase Test que prueba los metodos de la clase TestCollection

public class TestingTestCollection {
	private TestCollection unSuiteTests;
	private UnitTest unTest;
	private UnitTest dosTest;

	@Before
	public void setUp() {
		// Seteo un test y la Collection que alberga todos los test que
		// utilizare para probar los metodos de la clase
		unSuiteTests = new TestCollection("soyUnSuite");
		unTest = new UnitTest("soyUnTest") {
			@Override
			public void test() {
				String expected = "pruebo un test";
				String actual = "pruebo un test";
				Validation.validateEquals(expected, actual);
			}
		};
		dosTest = new UnitTest("soyUnTest") {
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
		unSuiteTests.addUnitTest(unTest);
		int esperado = 1;
		int actual = unSuiteTests.getTests().size();
		assertEquals(actual, esperado);
	}

	@Test
	public void correrLosTestdeLaCollectionTest() {
		unSuiteTests.addUnitTest(unTest);
		unSuiteTests.runAll();
		int esperado = 1;
		int actual = unSuiteTests.getReport().getResults().size();
		assertEquals(actual, esperado);
	}

	@Test
	public void mostrarResultadoDeUnTestDeLaCollection() {
		unSuiteTests.addUnitTest(unTest);
		unSuiteTests.runAll();
		unSuiteTests.showTestResults();

		// Me traigo el arrayList de resultados mostrados por pantalla
		ArrayList<TestResult> resultados =
				(ArrayList<TestResult>) unSuiteTests.getReport().getResults();

		// Me guardo el mensaje arrojado por el run que se muestra por pantalla
		String esperado = "TEST: soyUnTest - RESULT: Succeeded";
		String actual = resultados.get(0).getMessage();
		assertEquals(actual, esperado);
	}
	
	@Test
	public void UnicidadNombreUnitCase() {
		unSuiteTests.addUnitTest(unTest);
		unSuiteTests.addUnitTest(dosTest);
		
		boolean esperado = true;
		
		assertEquals(esperado, unSuiteTests.validarNombre(dosTest.getName()));
	}

	@Test
	public void UnicidadNombreTestCollection() {
		//TODO: Debe haber una estructura superior que almacene 
		//todos los CollectionTest y/o los UnitTest
		
	}
	

}