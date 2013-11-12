package grupo11.frameworktests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.After;
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

	@After
	public void tearDown() {
		NameRegister.getInstance().clear();
		Fixture.getInstance().clear();
	}

	@Test
	public void agregarUnTestaLaCollection() {
		UnitTest unaPrueba = new UnitTest("SoyUnaPrueba") {
			@Override
			protected void test() {}
		};

		unTestCollection.add(unaPrueba);

		int esperado = 1;
		int actual = unTestCollection.getTestsCount();

		assertEquals(esperado, actual);
	}

	@Test
	public void agregarUnTestCollectionaLaCollection() {
		TestCollection dosSuiteTests =
				new TestCollection("SoyOtroTestCollection");

		unTestCollection.add(dosSuiteTests);

		int esperado = 1;
		int actual = unTestCollection.getTestsCount();
		assertEquals(esperado, actual);
	}

	@Test
	public void correrLosTestdeLaCollectionTest() {
		unTestCollection.add(unTest);
		TestCollectionResult results = unTestCollection.run();
		int esperado = 1;
		int actual = results.getTestsResults().size();
		assertEquals(esperado, actual);
	}

	@Test
	public void ValidarUnSetUpDeCollectionConDosUnitCase() {
		UnitTest priPrueba = new UnitTest("1era Prueba") {
			@Override
			protected void test() {
				Validation.validateTrue(true);
			}
		};
		UnitTest secPrueba = new UnitTest("2da Prueba") {
			@Override
			protected void test() {
				Validation.validateTrue(true);
			}
		};
		unTestCollection.add(priPrueba);
		unTestCollection.add(secPrueba);
		unTestCollection.run();

		int esperado = 2;
		int actual = unTestCollection.getTestsCount();

		assertEquals(esperado, actual);
	}

	@Test
	public void mostrarResultadoDeUnTestDeLaCollection() {
		unTestCollection.add(unTest);
		TestCollectionResult resultados = unTestCollection.run();

		// Me traigo el arrayList de resultados mostrados por pantalla
		ArrayList<TestResult> arrayResultado =
				(ArrayList<TestResult>) resultados.getTestsResults();

		// Me guardo el mensaje arrojado por el run que se muestra por pantalla
		String actual = arrayResultado.get(0).getMessage();

		assertEquals("[Ok] soyUnTest: ", actual);
	}

	@Test
	public void UnicidadNombreDeTest() {
		unTestCollection.add(dosTest);
		// Pongo el mismo nombre a los Test y trato de agregarlos

		boolean actual = unTestCollection.add(dosTest);

		assertFalse(actual);
	}

	// @Test
	// public void SaltearUnTest() {
	// unTest.setSkip(true);
	//
	// unTestCollection.add(unTest);
	// unTestCollection.add(dosTest);
	//
	// TestCollectionResult resultados = unTestCollection.run();
	// int esperado = resultados.getTestsResults().size();
	//
	// assertEquals(esperado, 1);
	// }
}