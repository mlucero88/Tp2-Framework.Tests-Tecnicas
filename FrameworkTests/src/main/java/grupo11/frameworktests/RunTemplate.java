package grupo11.frameworktests;

import grupo11.frameworktests.GenericTest.TagType;

import java.util.Collection;

public abstract class RunTemplate {
	protected String regExp;
	protected Collection<TagType> tags;

	public RunTemplate(String regExp, Collection<TagType> tags) {
		this.regExp = regExp;
		this.tags = tags;
	}

	public void setRegularExpression(String regExp) {
		this.regExp = regExp;
	}

	public void setTagsSelection(Collection<TagType> tags) {
		this.tags = tags;
	}

	public abstract TestResult run(GenericTest test);
}
