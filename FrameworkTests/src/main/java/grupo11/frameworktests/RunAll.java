package grupo11.frameworktests;

import grupo11.frameworktests.GenericTest.TagType;

import java.util.Collection;

public class RunAll implements RunStrategy {

	public RunAll() {}

	@Override
	public TestCollectionResult run(Collection<GenericTest> tests,
			String testName, String regExp, Collection<TagType> tagTypes) {
		TestCollectionResult results = new TestCollectionResult(testName);
		for (GenericTest test : tests) {
			if (!test.isSkip()) {
				TestResult result = test.run(null, null);
				results.add(result);
			}
		}
		return results;
	}
}