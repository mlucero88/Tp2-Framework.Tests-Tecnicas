package grupo11.frameworktests;

import java.util.Collection;

public abstract class GenericTest {
	protected String nombre;
	
	protected GenericTest(String unNombre){
		nombre = unNombre;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected abstract TestResult run();
	protected void add(GenericTest test){
		NameRegister.getInstancia().registerName(test.getNombre());
	}
	protected abstract void setUp();
	protected abstract void tearDown();
}
