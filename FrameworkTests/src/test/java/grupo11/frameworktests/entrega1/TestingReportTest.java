package grupo11.frameworktests.entrega1;

import static org.junit.Assert.assertEquals;
import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.NameRegister;
import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.TestCollectionResult;
import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;

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

}