package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;
import org.jdom.Element;

/* Clase contenedora de UnitTest, encargada de ejecutar cada test unitario y
 * generar el reporte con el resultado de la corrida */

public class TestCollection extends GenericTest {
	private Collection<GenericTest> tests;
	private RunTemplate runMethod;
	private String nombreContenedora;
	double timeTotal;
	int countTests, countError, countFailures;

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
				//updateCounts(result);
				results.add(result);
			}
		}
		results.update();
		tearDown();
		timeTotal = (System.currentTimeMillis() - timeStartTest);
		/* TODO: Como agregarlo a resultado */
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


	@Override
	public Element toXMLElement() {
//		update();
		Element element = new Element("testsuite");
		element.setAttribute("name", getName());
		element.setAttribute("package", nombreContenedora);
		element.setAttribute("tests", String.valueOf(tests.size()));
		element.setAttribute("failures", String.valueOf(countFailures()));
		element.setAttribute("errors", String.valueOf(countErrors()));
		element.setAttribute("time", String.valueOf(timeTotal));
		
		for (GenericTest test : tests) {
			element.addContent(test.toXMLElement());
		}
		return element;
	}
	
	@Override
	public int countTests() {
		return countTests;
	}

	@Override
	public int countErrors() {
		return countError;
	}

	@Override
	public int countFailures() {
		return countFailures;
	}
	
	private void updateCounts(TestResult component) {
		countTests += component.countTests();
		countError += component.countErrors();
		countFailures += component.countFailures();
	}
}
