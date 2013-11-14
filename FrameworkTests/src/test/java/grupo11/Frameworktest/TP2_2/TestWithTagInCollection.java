package grupo11.Frameworktest.TP2_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import grupo11.frameworktests.GenericTest;
import grupo11.frameworktests.RunTags;
import grupo11.frameworktests.RunTemplate;
import grupo11.frameworktests.GenericTest.TagType;
import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.TP2_2.setupclasses.T1;
import grupo11.frameworktests.TP2_2.setupclasses.T2;
import grupo11.frameworktests.TP2_2.setupclasses.T3;
import grupo11.frameworktests.TP2_2.setupclasses.TS1;

import org.junit.Test;

public class TestWithTagInCollection {

	@Test
	public void testTagsInCollection() {
		
		//Armamos la estructura
		TestCollection TS1 = new TS1("TS1");
		GenericTest T1 = new T1("T1");
		GenericTest T2 = new T2("T2");
		GenericTest T3 = new T3("T3");
		
		//Agrego el TAG a T1 y T3
		T1.addTag(TagType.SLOW);
		T3.addTag(TagType.SLOW);
	
		TS1.add(T1);
		TS1.add(T2);
		TS1.add(T3);
		
		Collection<TagType> tags = new ArrayList<TagType>();
		tags.add(TagType.SLOW);
		RunTemplate runMethod = new RunTags(tags);
		TS1.setRunMethod(runMethod);
		
		TS1.run();
		
		//Poner asserts....
		
	}

}
