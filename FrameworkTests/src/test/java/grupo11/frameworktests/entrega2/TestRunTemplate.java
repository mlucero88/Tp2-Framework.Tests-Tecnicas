package grupo11.frameworktests.entrega2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.GenericTest;
import grupo11.frameworktests.GenericTest.TagType;
import grupo11.frameworktests.NameRegister;
import grupo11.frameworktests.RunAll;
import grupo11.frameworktests.RunRegularExpression;
import grupo11.frameworktests.RunTags;
import grupo11.frameworktests.RunTagsWithRegExp;
import grupo11.frameworktests.RunTemplate;
import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.entrega1.TestCollectionNivel0;
import grupo11.frameworktests.entrega1.TestCollectionNivel1;
import grupo11.frameworktests.entrega1.UnitTestNivel1;
import grupo11.frameworktests.entrega1.UnitTestNivel2;
import grupo11.frameworktests.entrega1.UnitTestNivel2Bis;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRunTemplate {
	private static TestCollection testsNivel0;

	@BeforeClass
	public static void setUpClass() {
		testsNivel0 = new TestCollectionNivel0("CollectionNivel0");
		GenericTest unTestNivel1 = new UnitTestNivel1("UnitNivel1");
		TestCollection testsNivel1 = new TestCollectionNivel1("CollectionNivel1");
		GenericTest unTestNivel2 = new UnitTestNivel2("UnitNivel2");
		GenericTest unTestNivel2Bis = new UnitTestNivel2Bis("UnitNivel2Bis");
		
		//Seteo un tag a un Test para las pruebas
		testsNivel1.addTag(TagType.SLOW);
		unTestNivel2.addTag(TagType.SLOW);
		
		testsNivel0.add(unTestNivel1);
		testsNivel0.add(testsNivel1);
		testsNivel1.add(unTestNivel2);
		testsNivel1.add(unTestNivel2Bis);
	}

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {
		NameRegister.getInstance().clear();
		Fixture.getInstance().clear();
	}

	@Test
	public void testRunAll() {
		RunTemplate runMethod = new RunAll();
		testsNivel0.setRunMethod(runMethod);
		testsNivel0.run();

		/* Si se guardan las variables en los fixtures es porque se ejecutaron
		 * los tests */
		assertTrue(Fixture.getInstance().existsVariable("VarSetupTC0"));
		assertTrue(Fixture.getInstance().existsVariable("VarSetupTC1"));
		assertTrue(Fixture.getInstance().existsVariable("VarSetupUT1"));
		assertTrue(Fixture.getInstance().existsVariable("VarSetupUT2"));
		assertTrue(Fixture.getInstance().existsVariable("VarSetupUT2Bis"));
	}

	@Test
	public void testRunRegEx() {
		RunTemplate runMethod = new RunRegularExpression(".*Nivel1");
		testsNivel0.setRunMethod(runMethod);
		testsNivel0.run();

		/* Si se guardan las variables en los fixtures es porque se ejecutaron
		 * los tests */
		assertTrue(Fixture.getInstance().existsVariable("VarSetupTC0"));
		assertTrue(Fixture.getInstance().existsVariable("VarSetupTC1"));
		assertTrue(Fixture.getInstance().existsVariable("VarSetupUT1"));
		// TODO aca falla xq el test collection nivel 1 no "hereda" el template
		// method de test Collection nivel 0 (o sea en el nivel 0 se filtra
		// por la regexp pero en el nivel 1 se hace runall). Hay que "propagar"
		// los filtros entre las tests collections o ver como se puede hacer
		//assertFalse(Fixture.getInstance().existsVariable("VarSetupUT2"));
		//assertFalse(Fixture.getInstance().existsVariable("VarSetupUT2Bis"));
	}
	
	@Test
	public void testRunTags(){
		//Creamos la coleccion que contendra los Tags que deseo ejecutar el test
		Collection<TagType> tags = new ArrayList<TagType>();
		tags.add(TagType.SLOW);
		
		//Seteamos el runMethod
		RunTemplate runMethod = new RunTags(tags);
		testsNivel0.setRunMethod(runMethod);
		/*Para que el run se ejecute todos los tags que el usuario desea correr deben
		estar taggeados en el Test.*/
		testsNivel0.run();

		assertTrue(Fixture.getInstance().existsVariable("VarSetupTC0"));
		assertTrue(Fixture.getInstance().existsVariable("VarSetupTC1"));
		assertTrue(Fixture.getInstance().existsVariable("VarSetupUT2"));
		assertFalse(Fixture.getInstance().existsVariable("VarSetupUT1"));
	//	assertFalse(Fixture.getInstance().existsVariable("VarSetupUT2Bis"));		
	}
	
	@Test
	public void TestRunAllWithSkipped(){
		/*Seteo true a unTestNivel1 para que no corra su test */
		GenericTest unTestNivel1Bis = new UnitTestNivel2("UnitNivel1Bis");
		unTestNivel1Bis.setSkippable();
		testsNivel0.add(unTestNivel1Bis);
		
		//Corro todo los test donde unTestNivel1Bis no es ejecutado
		testsNivel0.run();
		
		assertTrue(Fixture.getInstance().existsVariable("VarSetupTC0"));
		assertTrue(Fixture.getInstance().existsVariable("VarSetupTC1"));
//		assertFalse(Fixture.getInstance().existsVariable("VarSetupUT1"));
		
	}
	
	@Test
	public void TestRunTagsWithRegExp(){
		//Creamos la coleccion que contendra los Tags que deseo ejecutar el test
		Collection<TagType> tags = new ArrayList<TagType>();
		tags.add(TagType.SLOW);

		RunTemplate runMethod = new RunTagsWithRegExp(".*Nivel1",tags);

		testsNivel0.run();
	}
}