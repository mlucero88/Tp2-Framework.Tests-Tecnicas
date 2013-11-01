package grupo11.frameworktests.Dummy;

import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.Validation;

public class UnitTestHijitus extends UnitTest {

	public UnitTestHijitus(String testName) {
		super(testName);
	}

	@Override
	public void test() {
		Validation.validateTrue(true);
		//TODO ver como acceder al padre...estatico??
	}
	
	public void setUp(){
		String setUpHijoUnitTest = "setUpHijoUnitTest";
	}

	public void tearDown(){
		String tearDownHijoUnitTest = "tearDownHijoUnitTest";
	}

}
