package Grupo11.FrameworkTests;

import static org.junit.Assert.*;
import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;

import org.junit.Before;
import org.junit.Test;

public class TestingUnitTest {
	private UnitTest unTest;
	
	@Before
	public void setUp() throws Exception {
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

}
