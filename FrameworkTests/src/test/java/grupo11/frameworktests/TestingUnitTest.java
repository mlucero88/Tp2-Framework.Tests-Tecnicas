package grupo11.frameworktests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import grupo11.frameworktests.GenericTest.TagType;

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
		String actual = unTest.getName();
		String esperado = "soyUnTest";
		assertEquals(esperado, actual);
	}

	@Test
	public void ValidarSetUpDeLosUnitCase() {
		UnitTest tesito = new UnitTest("unTesito") {

			@Override
			public void test() {
				String actual = getName();
				assertEquals("SoyUnTest", actual);

			}

			@Override
			public void setUp() {
				setName("SoyUnTest");
			}
		};
		tesito.setUp();
		tesito.run();

		assertEquals("SoyUnTest", tesito.getName());
	}
	
	@Test
	public void AgregarUnTagAlUnitTest(){
		unTest.addTagType((TagType.SLOW));
		TagType actual = (TagType.SLOW);
		
		ArrayList<TagType> esperados = (ArrayList<TagType>) unTest.getTagType();
		
		assertEquals(esperados.get(0), actual);
	}

	@Test
	public void AgregarMasTagAlUnitTest(){
		
		unTest.addTagType(TagType.SLOW);
		unTest.addTagType(TagType.INTERNET);
		
		int actual = 2;
		int esperado = unTest.getTagType().size();
				
		assertEquals(esperado, actual);
	}
}