package grupo11.frameworktests;

import grupo11.frameworktests.GenericTest.TagType;

import java.util.Collection;
import java.util.TreeSet;

/* Clase padre del patron Template Method para la funcionalidad del run */
public abstract class RunTemplate {
	protected String regExp;
	protected Collection<TagType> tags;

	public RunTemplate() {
		tags = new TreeSet<TagType>();
	}

	public RunTemplate(String regExp, Collection<TagType> tags) {
		if (regExp == null) {
			this.regExp = ".*";
		}
		else {
			this.regExp = regExp;
		}
		if (tags == null) {
			this.tags = new TreeSet<TagType>();
		}
		else {
			this.tags = tags;
		}
	}

	public void setRegularExpression(String regExp) {
		this.regExp = regExp;
	}

	public void setTagsSelection(Collection<TagType> tags) {
		this.tags = tags;
	}

	boolean containsTag(Collection<TagType> testTags) {
		for (TagType runTag : tags) {
			for (TagType testTag : testTags) {
				if (runTag == testTag) {
					return true;
				}
			}
		}
		return false;
	}

	public abstract TestResult run(GenericTest test);
}