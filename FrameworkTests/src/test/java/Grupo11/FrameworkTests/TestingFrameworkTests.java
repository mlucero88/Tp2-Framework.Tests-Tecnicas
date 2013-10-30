package Grupo11.FrameworkTests;

import static org.junit.Assert.*;
import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.TestReport;
import grupo11.frameworktests.UnitTest;
import java.util.Collection;
import org.junit.Test;

public class TestingFrameworkTests{
	
	@Test
	public void agregarUnTestaLaCollection(){
		TestCollection someTests = new TestCollection();
		UnitTest unTest = new UnitTest("soyUnTest") {
			
			@Override
			public void test() {
				String expected = "pruebo un test";
				String actual = "pruebo un test";
			}
		};

		someTests.addUnitTest(unTest);
		
		assertEquals(1, someTests.getTests().size());
	}
	
	@Test
	public void correrLosTestdeLaCollectionTest(){
		TestCollection someTests = new TestCollection();
		UnitTest unTest = new UnitTest("soyUnTest") {
			
			@Override
			public void test() {
				String expected = "pruebo un test";
				String actual = "pruebo un test";
			}
		};

		someTests.addUnitTest(unTest);
		someTests.runAll();
		
		assertEquals(1, someTests.getReport().getResults().size());
	}

}
