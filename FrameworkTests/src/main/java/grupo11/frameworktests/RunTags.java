package grupo11.frameworktests;

import grupo11.frameworktests.GenericTest.TagType;

import java.util.Collection;

public class RunTags extends RunTemplate{

	public RunTags(Collection<TagType> tags) {
		super(null, tags);
	}

	@Override
	public TestResult run(GenericTest test) {
		TestResult results = null;
		if(!test.isSkippable() && test.getTags().containsAll(tags)){
			results = test.run(); 
		}
		return results;
	}

}
