package grupo11.frameworktests;

import grupo11.frameworktests.grupo13classes.XMLWriter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;

/* Clase contenedora de UnitTest, encargada de ejecutar cada test unitario y
 * generar el reporte con el resultado de la corrida */

public class TestCollection extends GenericTest {
	//private List<GenericTest> tests;
	private HashMap<String, GenericTest> tests = new HashMap<String, GenericTest>();
	private RunTemplate runMethod;
	private String nombreContenedora;
	private String storeTo = null;
	private boolean storeMode = false;
	private boolean recoverMode = false;


	double timeTotal;
	int countTests, countError, countFailures;

	public static TestCollection createTestCollection(Element e) {
		TestCollection temp = new TestCollection();
		temp.fromXmlElement(e);
		return temp;
	}
	
	private void fromXmlElement(Element e) {
		setName(e.getAttributeValue("name"));
		Attribute attrPackageName = e.getAttribute("package");
		if (attrPackageName != null) {
			setTestCollectionContenedora(attrPackageName.getValue());
		}
		
		setTimeTotal(Double.parseDouble(e.getAttributeValue("time")));
		setCountTests(Integer.parseInt(e.getAttributeValue("tests")));
		setCountFailures(Integer.parseInt(e.getAttributeValue("failures")));
		setCountError(Integer.parseInt(e.getAttributeValue("errors")));
		List<Element> list = XMLWriter.castList(Element.class, e.getChildren("testsuite"));
		for (Element e2 : list) {
			add(TestCollection.createTestCollection(e2));
		}
		list = XMLWriter.castList(Element.class, e.getChildren("testcase"));
		for (Element e2 : list) {
			if (e2 == null) {
				System.out.println("hay nulos");
				continue;
			}
			GenericTest unitTest = UnitTest.createUnitTest(e2);
			tests.put(unitTest.getName(), unitTest);
		}
	}

	public void setCountTests(int countTests) {
		this.countTests = countTests;
	}
	
	public TestCollection() {
		super();
		//tests = new ArrayList<GenericTest>();
		runMethod = new RunAll();
	}

	public TestCollection(String name) {
		super(name);
		//tests = new ArrayList<GenericTest>();
		runMethod = new RunAll();
	}

	public void setRunMethod(RunTemplate runMethod) {
		this.runMethod = runMethod;
	}

	@Override
	final public boolean add(GenericTest test) {
		UnitTest testOld;
		if (NameRegister.getInstance().registerName(test.getName())) {
			tests.put(test.getName(), test);
			return true;
		} else {
			testOld = (UnitTest) getTest(test.getName());
			if (testOld.isOK()) {
				testOld.setSkippable();
			} else {
				tests.remove(testOld);
				tests.put(test.getName(), test);
			}
			return false;
		}
	}
	
	private GenericTest getTest(String nameTest) {
		if (tests.containsKey(nameTest)) {
			return tests.get(nameTest);
		} 
		return null;
	}

	@Override
	/*
	 * Utiliza el patron Template Method para las distintas formas de correr los
	 * tests
	 */
	final public TestCollectionResult run() {
		double timeStartTest = System.currentTimeMillis();
		recoverTestsFromStore();
		setUp();
		String contenedoraYCollectionActual;
		if (nombreContenedora == null) {
			contenedoraYCollectionActual = getName();
		} else {
			contenedoraYCollectionActual = nombreContenedora + "." + getName();
		}
		System.out.println(" ");
		System.out.println(contenedoraYCollectionActual);
		System.out
				.println("------------------------------------------------------------------------------------------------");
		TestCollectionResult results = new TestCollectionResult(getName());
		Iterator<String> keySetIterator = tests.keySet().iterator();
		while (keySetIterator.hasNext()) {
			GenericTest test = tests.get(keySetIterator.next());
			if (test.runnable()) {
				test.setTestCollectionContenedora(contenedoraYCollectionActual);
				TestResult result = runMethod.run(test);
				if (result != null) {
					updateCounts(result);
					results.add(result);
				}
			}
		}
//		for (GenericTest test : tests) {
//			if (test.runnable()) {
//				test.setTestCollectionContenedora(contenedoraYCollectionActual);
//				TestResult result = runMethod.run(test);
//				if (result != null) {
//					updateCounts(result);
//					results.add(result);
//				}
//			}
//		}

		results.update();
		tearDown();
		store();
		timeTotal = System.currentTimeMillis() - timeStartTest;
		results.setTiempoEjecucion(timeTotal);
		System.out
				.println("------------------------------------------------------------------------------------------------");
		System.out.println(results.getMessage());
		System.out.println(" ");
		results.setCollectionResultCadenaDeNombres(contenedoraYCollectionActual);
		return results;
	}
//	
//
//	private String testSuitesToString() {
//		Iterator<String> keySetIterator = tests.keySet().iterator();
//		while (keySetIterator.hasNext()) {
//			GenericTest test = tests.get(keySetIterator.next());
//		}
//	}


	private void recoverTestsFromStore() {
		if ((storeTo != null) && recoverMode) {
			XMLWriter writer = new XMLWriter();
			writer.setFilePath(storeTo);
			List<Element> storedSuites = writer.getElements();
			for (Element e : storedSuites) {
				TestCollection temp = createTestCollection(e);
				if (temp.getName().equals(getName())) {
					fromXmlElement(e);
				}
				
			}
		}
	}
	
	public void storeMode() {
		this.storeMode = true;
	}

	public void recoverMode() {
		this.recoverMode = true;
	}

	private void store() {
		if ((storeTo != null) && storeMode) {
			XMLWriter writer = new XMLWriter(toXMLElement());
			writer.setFilePath(storeTo);
			writer.produceResult();
		}
	}

	/*
	 * Retorna la cantidad de tests. Tanto un UnitTest como una test collection
	 * cuenta como un solo test
	 */
	public int getTestsCount() {
		return tests.size();
	}

	public HashMap<String, GenericTest> getTests() {
		return tests;
	}

	/* Metodos redefinibles por el usuario */
	@Override
	protected void setUp() {
	}

	@Override
	protected void tearDown() {
	}

	public void setTestCollectionContenedora(String nombreContenedora) {
		this.nombreContenedora = nombreContenedora;
	}

	public String getTestCollectionContenedora() {
		return nombreContenedora;
	}

	@Override
	public Element toXMLElement() {
		Element element = new Element("testsuite");
		element.setAttribute("name", getName());
		if (nombreContenedora != null) {
			element.setAttribute("package", nombreContenedora);
		}
		element.setAttribute("tests", String.valueOf(tests.size()));
		element.setAttribute("failures", String.valueOf(countFailures()));
		element.setAttribute("errors", String.valueOf(countErrors()));
		element.setAttribute("time", String.valueOf(timeTotal));
		Iterator<String> keySetIterator = tests.keySet().iterator();
		while (keySetIterator.hasNext()) {
			GenericTest test = tests.get(keySetIterator.next());
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

	public void setStore(String storeName) {
		storeTo = storeName;

	}

	public void setTimeTotal(double timeTotal) {
		this.timeTotal = timeTotal;
	}

	public void setCountError(int countError) {
		this.countError = countError;
	}

	public void setCountFailures(int countFailures) {
		this.countFailures = countFailures;
	}
}
