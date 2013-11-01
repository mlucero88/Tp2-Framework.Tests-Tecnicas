package grupo11.frameworktests;

public class TestCollectionHijo extends TestCollection {

	public TestCollectionHijo(String nombre) {
		super(nombre);
	}
	
	@Override
	public void setUp(){
		System.out.println("SoyTuHijo");
	}
}
