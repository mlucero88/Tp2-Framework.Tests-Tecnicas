package Grupo11.FrameworkTests;

import static org.junit.Assert.*;
import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.TestReport;
import grupo11.frameworktests.TestResult;
import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

//Clase Test que prueba los metodos de la clase TestCollection

public class TestingTestCollection{

	private TestCollection someTests;
	private UnitTest unTest;
	
	@Before
	public void setUp(){
		//Seteo un test y la Collection que alberga todos los test que utilizare para probar los metodos de la case.
		someTests = new TestCollection();
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
	public void agregarUnTestaLaCollection(){

		someTests.addUnitTest(unTest);

		int esperado = 1;
		int actual = someTests.getTests().size();
				
		assertEquals(actual, esperado);
	}
	
	@Test
	public void correrLosTestdeLaCollectionTest(){
	
		someTests.addUnitTest(unTest);
		someTests.runAll();
		
		int esperado = 1;
		int actual = someTests.getReport().getResults().size();
		
		assertEquals(actual, esperado );
	}
	
	@Test
	public void mostrarResultadoDeUnTestDeLaCollection(){

		someTests.addUnitTest(unTest);
		someTests.runAll();
		someTests.showTestResults();
	
		//Me traigo el arrayList de resultados mostrados por pantalla
		ArrayList<TestResult> resultados = (ArrayList<TestResult>) someTests.getReport().getResults();
		
		//Me guardo el mensaje arrojado por el run que se muestra por pantalla
		String esperado = "TEST: soyUnTest - RESULT: Succeeded";
		String actual = resultados.get(0).getMessage();
		
		assertEquals(actual, esperado);
	}
}