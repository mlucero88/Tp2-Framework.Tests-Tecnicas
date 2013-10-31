package grupo11.frameworktests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

// Clase Test que prueba los metodos de la clase ReportTest

public class TestingReportTest {
	private TestCollection unosTests;
	private UnitTest unTest;

	@Before
	public void setUp() {
		unosTests = new TestCollection();
		unTest = new UnitTest("soyUnTest") {
			@Override
			public void test() {
				String expected = "pruebo un test";
				String actual = "pruebo un test";
				Validation.validateEquals(expected, actual);
			}
		};
		unosTests.addUnitTest(unTest);
	}

	@Test
	public void testAddTestResult() {
		unosTests.runAll();
		int esperado = unosTests.getReport().getResults().size();
		int actual = 1;
		assertEquals(actual, esperado);
	}

	@Test
	public void testClear() {
		unosTests.runAll();
		unosTests.getReport().clear();
		int esperado = unosTests.getReport().getResults().size();
		int actual = 0;
		assertEquals(actual, esperado);
	}

	@Test
	public void testShowAll() {
		unosTests.runAll();
		unosTests.getReport().showAll();

		// Me traigo el arrayList de resultados mostrados por pantalla
		ArrayList<TestResult> resultados =
				(ArrayList<TestResult>) unosTests.getReport().getResults();

		// Me guardo el mensaje arrojado por el run que se muestra por pantalla
		String esperado = "TEST: soyUnTest - RESULT: Succeeded";
		String actual = resultados.get(0).getMessage();
		assertEquals(actual, esperado);
	}
}