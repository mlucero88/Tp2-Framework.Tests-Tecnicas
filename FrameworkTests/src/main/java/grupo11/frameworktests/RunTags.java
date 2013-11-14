package grupo11.frameworktests;

import grupo11.frameworktests.GenericTest.TagType;

import java.util.Collection;

public class RunTags extends RunTemplate {

	public RunTags(Collection<TagType> tags) {
		super(null, tags);
	}

	public RunTags(TagType tag) {
		super();
		tags.add(tag);
	}

	@Override
	public TestResult run(GenericTest test) {
		TestResult result = null;
		if (containsTag(test.getTags())) {
			result = test.run();
		}
		return result;
	}
}