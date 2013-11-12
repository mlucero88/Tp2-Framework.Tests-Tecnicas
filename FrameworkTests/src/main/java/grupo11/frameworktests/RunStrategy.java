package grupo11.frameworktests;

import grupo11.frameworktests.GenericTest.TagType;

import java.util.Collection;

public interface RunStrategy {
	public TestCollectionResult run(Collection<GenericTest> tests,
			String testName, String regExp, Collection<TagType> tagTypes);
}
