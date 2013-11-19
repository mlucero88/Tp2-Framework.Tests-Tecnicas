package grupo11.frameworktests.entrega2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import grupo11.frameworktests.Fixture;
import grupo11.frameworktests.GenericTest;
import grupo11.frameworktests.GenericTest.TagType;
import grupo11.frameworktests.NameRegister;
import grupo11.frameworktests.RunTags;
import grupo11.frameworktests.RunTagsWithRegExp;
import grupo11.frameworktests.RunTemplate;
import grupo11.frameworktests.TestCollection;

import java.util.Collection;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestWithTagInCollection {

	@Before
	public void setUp() {}

	@After
	public void tearDown() {
		NameRegister.getInstance().clear();
		Fixture.getInstance().clear();
	}

	@Test
	public void testCaso1() {
		// Armamos la estructura
		TestCollection testSuite1 = new TS1("TS1");
		GenericTest test1 = new T1("T1");
		GenericTest test2 = new T2("T2");
		GenericTest test3 = new T3("T3");
		testSuite1.add(test1);
		testSuite1.add(test2);
		testSuite1.add(test3);

		// Agrego TAGS
		test1.addTag(TagType.SLOW);
		test3.addTag(TagType.SLOW);

		RunTemplate runMethod = new RunTags(TagType.SLOW);
		testSuite1.setRunMethod(runMethod);

		testSuite1.run();

		/* Si existen los nombres, en el fixture, de las variables que se
		 * generan al correr un test, entonces dicho test se ejecuto */
		assertTrue(Fixture.getInstance().existsVariable(
				T1.FIXTURE_TEST_VAR_NAME));
		assertFalse(Fixture.getInstance().existsVariable(
				T2.FIXTURE_TEST_VAR_NAME));
		assertTrue(Fixture.getInstance().existsVariable(
				T3.FIXTURE_TEST_VAR_NAME));
	}

	 @Test
	 public void testCaso2() {
	 // Armamos la estructura
	 TestCollection testSuite1 = new TS1("TS1");
	 GenericTest test1 = new T1("T1");
	 GenericTest test2 = new T2("T2");
	 GenericTest test3 = new T3("T3");
	 testSuite1.add(test1);
	 testSuite1.add(test2);
	 testSuite1.add(test3);
	
	 // Agrego TAGS
	 test1.addTag(TagType.SLOW);
	 test3.addTag(TagType.SLOW);
	
	 // Skips
	 test1.setSkippable();
	
	 RunTemplate runMethod = new RunTags(TagType.SLOW);
	 testSuite1.setRunMethod(runMethod);
	
	 testSuite1.run();
	
	 /* Si existen los nombres, en el fixture, de las variables que se
	 * generan al correr un test, entonces dicho test se ejecuto */
	 assertFalse(Fixture.getInstance().existsVariable(
	 T1.FIXTURE_TEST_VAR_NAME));
	 assertFalse(Fixture.getInstance().existsVariable(
	 T2.FIXTURE_TEST_VAR_NAME));
	 assertTrue(Fixture.getInstance().existsVariable(
	 T3.FIXTURE_TEST_VAR_NAME));
	 }
	
	 @Test
	 public void testCaso3() {
	 // Armamos la estructura
	 TestCollection testSuite1 = new TS1("TS1");
	 GenericTest test1 = new T1("T1");
	 GenericTest test2 = new T2("T2");
	 GenericTest test3 = new T3("T3");
	 GenericTest test4 = new T4("T4");
	 GenericTest test5 = new T5("T5");
	 GenericTest test6 = new T6("T6");
	 testSuite1.add(test1);
	 testSuite1.add(test2);
	 testSuite1.add(test3);
	 testSuite1.add(test4);
	 testSuite1.add(test5);
	 testSuite1.add(test6);
	
	 // Agrego TAGS
	 test1.addTag(TagType.SLOW);
	 test1.addTag(TagType.DB);
	 test2.addTag(TagType.SLOW);
	 test3.addTag(TagType.DB);
	 test4.addTag(TagType.FAST);
	 test5.addTag(TagType.SMOKE);
	
	 Collection<TagType> tags = new TreeSet<TagType>();
	 tags.add(TagType.DB);
	 tags.add(TagType.FAST);
	 tags.add(TagType.SMOKE);
	
	 RunTemplate runMethod = new RunTags(tags);
	 testSuite1.setRunMethod(runMethod);
	
	 testSuite1.run();
	
	 /* Si existen los nombres, en el fixture, de las variables que se
	 * generan al correr un test, entonces dicho test se ejecuto */
	 assertTrue(Fixture.getInstance().existsVariable(
	 T1.FIXTURE_TEST_VAR_NAME));
	 // assertFalse(Fixture.getInstance().existsVariable(
	 // T2.FIXTURE_TEST_VAR_NAME));
	 assertTrue(Fixture.getInstance().existsVariable(
	 T3.FIXTURE_TEST_VAR_NAME));
	 assertTrue(Fixture.getInstance().existsVariable(
	 T4.FIXTURE_TEST_VAR_NAME));
	 assertTrue(Fixture.getInstance().existsVariable(
	 T5.FIXTURE_TEST_VAR_NAME));
	 assertFalse(Fixture.getInstance().existsVariable(
				T6.FIXTURE_TEST_VAR_NAME));
	}

	@Test
	public void testCaso4() {
		// Armamos la estructura
		TestCollection testSuite1 = new TS1("TS1");
		GenericTest test1 = new T1("T1");
		GenericTest test2 = new T2("T2");
		GenericTest test3 = new T3("T3");
		GenericTest test4 = new T4("no correr T4");
		testSuite1.add(test1);
		testSuite1.add(test2);
		testSuite1.add(test3);
		testSuite1.add(test4);

		// Agrego TAGS
		test1.addTag(TagType.SLOW);
		test2.addTag(TagType.FAST);
		test3.addTag(TagType.SLOW);
		test4.addTag(TagType.SLOW);

		RunTemplate runMethod =
				new RunTagsWithRegExp("^[^(no correr)].*", TagType.SLOW);
		testSuite1.setRunMethod(runMethod);

		testSuite1.run();

		/* Si existen los nombres, en el fixture, de las variables que se
		 * generan al correr un test, entonces dicho test se ejecuto */
		assertTrue(Fixture.getInstance().existsVariable(
				T1.FIXTURE_TEST_VAR_NAME));
		assertFalse(Fixture.getInstance().existsVariable(
				T2.FIXTURE_TEST_VAR_NAME));
		assertTrue(Fixture.getInstance().existsVariable(
				T3.FIXTURE_TEST_VAR_NAME));
		assertFalse(Fixture.getInstance().existsVariable(
				T4.FIXTURE_TEST_VAR_NAME));
	}

	@Test
	public void testCaso5() {
		// Armamos la estructura
		TestCollection testSuite1 = new TS1("TS1");
		GenericTest test1 = new T1("T1");
		GenericTest test2 = new T2("T2");
		GenericTest test3 = new T3("T3");
		GenericTest test4 = new T4("T4 mysql_test1");
		GenericTest test5 = new T5("T5 mysql_test2");
		GenericTest test6 = new T5("T6 mysql_test3");
		testSuite1.add(test1);
		testSuite1.add(test2);
		testSuite1.add(test3);
		testSuite1.add(test4);
		testSuite1.add(test5);
		testSuite1.add(test6);

		// Agrego TAGS
		test1.addTag(TagType.DB);
		test2.addTag(TagType.DB);
		test3.addTag(TagType.SLOW);
		test4.addTag(TagType.DB);
		test5.addTag(TagType.DB);

		RunTemplate runMethod = new RunTagsWithRegExp(".*mysql.*", TagType.DB);
		testSuite1.setRunMethod(runMethod);

		testSuite1.run();

		/* Si existen los nombres, en el fixture, de las variables que se
		 * generan al correr un test, entonces dicho test se ejecuto */
		assertFalse(Fixture.getInstance().existsVariable(
				T1.FIXTURE_TEST_VAR_NAME));
		assertFalse(Fixture.getInstance().existsVariable(
				T2.FIXTURE_TEST_VAR_NAME));
		assertFalse(Fixture.getInstance().existsVariable(
				T3.FIXTURE_TEST_VAR_NAME));
		assertTrue(Fixture.getInstance().existsVariable(
				T4.FIXTURE_TEST_VAR_NAME));
		assertTrue(Fixture.getInstance().existsVariable(
				T5.FIXTURE_TEST_VAR_NAME));
		assertFalse(Fixture.getInstance().existsVariable(
				T6.FIXTURE_TEST_VAR_NAME));
	}

	@Test
	public void testCaso6() {
		// Armamos la estructura
		TestCollection testSuite1 = new TS1("TS1");
		GenericTest test1 = new T1("T1");
		GenericTest test2 = new T2("T2");
		GenericTest test3 = new T3("T3");
		testSuite1.add(test1);
		testSuite1.add(test2);
		testSuite1.add(test3);

		testSuite1.run();

		// Poner asserts....
	}

	@Test
	public void testCaso7() {
		// Armamos la estructura
		TestCollection testSuite1 = new TS1("TS1");
		GenericTest test1 = new T1("T1");
		GenericTest test2 = new T2("T2");
		GenericTest test3 = new T3("T3");
		testSuite1.add(test1);
		testSuite1.add(test2);
		testSuite1.add(test3);

		testSuite1.run();

		// Poner asserts....
	}
}