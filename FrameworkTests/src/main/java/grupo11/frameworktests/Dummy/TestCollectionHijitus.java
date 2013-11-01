package grupo11.frameworktests.Dummy;

import grupo11.frameworktests.TestCollection;

public class TestCollectionHijitus extends TestCollection {

	public TestCollectionHijitus(String nombre) {
		super(nombre);
	}
	
	@Override
	public void setUp(){
		String setUpHijitus = "soySetUpTestCollectionHijitus";
	}

	@Override
	public void tearDown(){
		String tearDownHijitus = "soyTearDownTestCollectionHijitus";
	}

}
