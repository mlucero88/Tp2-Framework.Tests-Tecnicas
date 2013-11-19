package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;

/* Clase contenedora de UnitTest, encargada de ejecutar cada test unitario y
 * generar el reporte con el resultado de la corrida */

public class TestCollection extends GenericTest {
	private Collection<GenericTest> tests;
	private RunTemplate runMethod;
	private String nombreContenedora;
	private TestCollectionResult previousRun;

	public TestCollection(String name) {
		super(name);
		tests = new ArrayList<GenericTest>();
		// Construye con un template "RunAll" por defecto
		runMethod = new RunAll();
	};

	public void setRunMethod(RunTemplate runMethod) {
		this.runMethod = runMethod;
	}

	@Override
	final public boolean add(GenericTest test) {
		UnitTest testOld;
		if (NameRegister.getInstance().registerName(test.getName())) {
			tests.add(test);
			return true;
		}
		else{
			testOld = (UnitTest) getTest(test.getName());
			if(testOld.isOK()){
				testOld.setSkippable();
			}
			else{
				tests.remove(testOld);
				tests.add(test);
			}
			return false;
		}
	}
	
	private GenericTest getTest(String nameTest){
		for(GenericTest test : tests){
			if(test.getName().equals(nameTest)){
				return test;
			}
		}
		return null;
	}
	

	@Override
	/* Utiliza el patron Template Method para las distintas formas de correr
	 * los tests */
	final public TestCollectionResult run() {
		double timeStartTest = System.currentTimeMillis();
		setUp();
		String contenedoraYCollectionActual;
		if (nombreContenedora == null) {
			contenedoraYCollectionActual = getName();
		}
		else {
			contenedoraYCollectionActual = nombreContenedora + "." + getName();
		}
		System.out.println(" ");
		System.out.println(contenedoraYCollectionActual);
		System.out
				.println("------------------------------------------------------------------------------------------------");
		TestCollectionResult results = new TestCollectionResult(getName());
		for (GenericTest test : tests) {
			if (!test.isSkippable()) {
				test.setTestCollectionContenedora(contenedoraYCollectionActual);
				TestResult result = runMethod.run(test);
				results.add(result);
			}
		}
		results.update();
		tearDown();
		double timeTotal = (System.currentTimeMillis() - timeStartTest);
		results.setTiempoEjecucion(timeTotal);
		System.out
				.println("------------------------------------------------------------------------------------------------");
		System.out.println(results.getMessage());
		System.out.println(" ");
		results.setCollectionResultCadenaDeNombres(contenedoraYCollectionActual);
		return results;
	}

	/* Retorna la cantidad de tests. Tanto un UnitTest como una test collection
	 * cuenta como un solo test */
	public int getTestsCount() {
		return tests.size();
	}

	public Collection<GenericTest> getTests() {
		return tests;
	}

	/* Metodos redefinibles por el usuario */
	@Override
	protected void setUp() {}

	@Override
	protected void tearDown() {}

	public void setTestCollectionContenedora(String nombreContenedora) {
		this.nombreContenedora = nombreContenedora;
	}

	public String getTestCollectionContenedora() {
		return nombreContenedora;
	}

	public void setPreviousRun(TestCollectionResult results) {
		previousRun = results;	
	}
}
