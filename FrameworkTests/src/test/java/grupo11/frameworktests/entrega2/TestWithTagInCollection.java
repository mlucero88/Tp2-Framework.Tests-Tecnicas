package grupo11.frameworktests.entrega2;

import grupo11.frameworktests.GenericTest;
import grupo11.frameworktests.GenericTest.TagType;
import grupo11.frameworktests.RunTags;
import grupo11.frameworktests.RunTemplate;
import grupo11.frameworktests.TestCollection;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestWithTagInCollection {

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {

	}

	@Test
	public void testTagsInCollection() {
		// Armamos la estructura
		TestCollection testSuite1 = new TS1("TS1");
		GenericTest test1 = new T1("T1");
		GenericTest test2 = new T2("T2");
		GenericTest test3 = new T3("T3");

		// Agrego el TAG a T1 y T3
		test1.addTag(TagType.SLOW);
		test3.addTag(TagType.SLOW);

		testSuite1.add(test1);
		testSuite1.add(test2);
		testSuite1.add(test3);

		Collection<TagType> tags = new ArrayList<TagType>();
		tags.add(TagType.SLOW);
		RunTemplate runMethod = new RunTags(tags);
		testSuite1.setRunMethod(runMethod);

		testSuite1.run();

		// Poner asserts....
	}
}