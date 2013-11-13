package grupo11.frameworktests;

import static org.junit.Assert.assertEquals;
import grupo11.frameworktests.GenericTest.TagType;

import java.util.Collection;

import org.junit.After;
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

	@After
	public void tearDown() {
		NameRegister.getInstance().clear();
		Fixture.getInstance().clear();
	}

	@Test
	public void testUnitTest() {
		String actual = unTest.getName();
		String esperado = "soyUnTest";
		assertEquals(esperado, actual);
	}

	@Test
	public void AgregarUnTagAlUnitTest() {
		unTest.addTag(TagType.SLOW);
		TagType actual = TagType.SLOW;
		Collection<TagType> esperados = unTest.getTags();
		assertEquals(esperados.iterator().next(), actual);
	}

	@Test
	public void AgregarMasTagAlUnitTest() {
		unTest.addTag(TagType.SLOW);
		unTest.addTag(TagType.INTERNET);
		int actual = 2;
		int esperado = unTest.getTags().size();
		assertEquals(esperado, actual);
	}
}