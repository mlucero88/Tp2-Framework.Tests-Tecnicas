package grupo11.frameworktests;

import grupo11.frameworktests.GenericTest.TagType;

import java.util.Collection;

public class RunTagsWithRegExp extends RunTemplate{

	public RunTagsWithRegExp(String regExp, Collection<TagType> tags) {
		super(regExp, tags);
	}

	@Override
	public TestResult run(GenericTest test) {
		TestResult results = null;
		if(!test.isSkippable() && test.getTags().containsAll(tags) &&
				test.getName().matches(regExp)){
			results = test.run(); 
		}
		return results;
	}

}
