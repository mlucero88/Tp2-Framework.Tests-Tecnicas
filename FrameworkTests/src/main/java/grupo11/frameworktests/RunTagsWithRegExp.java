package grupo11.frameworktests;

import grupo11.frameworktests.GenericTest.TagType;

import java.util.Collection;

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
		if (test.getTags().containsAll(tags) && test.getName().matches(regExp)) {
			result = test.run();
		}
		return result;
	}
}