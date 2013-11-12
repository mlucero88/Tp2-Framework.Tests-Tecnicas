package grupo11.frameworktests;

import java.util.ArrayList;
import java.util.Collection;


public abstract class GenericTest {
	private String name;
	protected enum TagType {DEFAULT, FAST, SLOW, DB, INTERNET};
	private Collection<TagType> tagTypes;
	private boolean skip;

	protected GenericTest(String name) {
		this.name = name;
		this.setSkip(false);
		this.tagTypes = new ArrayList<TagType>();
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}
	
	public Collection<TagType> getTagType() {
		return tagTypes;
	}

	public void addTagType(TagType tagType) {
		tagTypes.add(tagType);
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	/* Metodo redefinible por TestCollection */
	protected abstract boolean add(GenericTest test);

	/* Metodo redefinible cuyo comportamiento depende de si se trata de un
	 * UnitTest o TestCollection, no accedibles por el usuario */
	protected abstract TestResult run();

	/* Metodos redefinibles por el usuario */
	protected abstract void setUp();

	protected abstract void tearDown();

}