package grupo11.frameworktests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// Clase Test que prueba los metodos de la clase ReportTest

public class TestingReportTest {
	private TestCollection unosTests;
	private UnitTest unTest;

	@Before
	public void setUp() {
		unosTests = new TestCollection("SoyUnSuite");
		unTest = new UnitTest("soyUnTest") {
			@Override
			public void test() {
				String expected = "pruebo un test";
				String actual = "pruebo un test";
				Validation.validateEquals(expected, actual);
			}
		};
		unosTests.add(unTest);
	}

	@After
	public void tearDown() {
		NameRegister.getInstance().clear();
		Fixture.getInstance().clear();
	}

	@Test
	public void testAddTestResult() {
		unosTests.add(unTest);
		TestCollectionResult resultados = unosTests.run();
		int esperado = resultados.getTestsResults().size();
		int actual = 1;
		assertEquals(actual, esperado);
	}

	@Test
	public void testShowAll() {
		TestCollectionResult resultados = unosTests.run();
		TestReport report = new TestReport(resultados);
		report.generarReporteEnArchivo();
		report.showAll();

		// Me traigo el arrayList de resultados mostrados por pantalla
		ArrayList<TestResult> results =
				(ArrayList<TestResult>) resultados.getTestsResults();

		// Me guardo el mensaje arrojado por el run que se muestra por pantalla
		String esperado = "[Ok] soyUnTest: ";
		String actual = results.get(0).getMessage();
		assertEquals(esperado, actual);
	}
}