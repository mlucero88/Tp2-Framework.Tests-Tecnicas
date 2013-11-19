package grupo11.frameworktests;

import grupo11.frameworktests.GenericTest.TagType;

import java.util.Collection;

/* Ejecucion de tests cumpliendo criterios de existencia de tags y coincidencias
 * de una regular expression */
public class RunTagsWithRegExp extends RunTemplate {

	public RunTagsWithRegExp(String regExp, Collection<TagType> tags) {
		super(regExp, tags);
	}

	public RunTagsWithRegExp(String regExp, TagType tag) {
		super(regExp, null);
		tags.add(tag);
	}

	@Override
	public TestResult run(GenericTest test) {
		TestResult result = null;
		if (test.getName().matches(regExp) && containsTag(test.getTags())) {
			result = test.run();
		}
		return result;
	}
}