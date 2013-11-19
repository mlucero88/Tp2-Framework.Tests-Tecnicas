<<<<<<< HEAD
package grupo11.frameworktests;

import java.util.Collection;
import java.util.TreeSet;

import org.jdom.Element;

/* Test generico. Es el "componente" del patron Composite */
public abstract class GenericTest {
	public enum TagType {
		DEFAULT, FAST, SLOW, DB, INTERNET, SMOKE
	};

	private String name;
	private Collection<TagType> tags;
	private boolean skip;

	protected GenericTest(String name) {
		this.name = name;
		skip = false;
		tags = new TreeSet<TagType>();
	}

	public String getName() {
		return name;
	}

	public Collection<TagType> getTags() {
		return tags;
	}

	public void addTag(TagType tag) {
		tags.add(tag);
	}

	public boolean isSkippable() {
		return skip;
	}

	public void setSkippable() {
		skip = true;
	}

	public void setNotSkippable() {
		skip = false;
	}

	public abstract void setTestCollectionContenedora(String nombreContenedora);

	public abstract String getTestCollectionContenedora();

	/* Metodo redefinible por TestCollection */
	protected abstract boolean add(GenericTest test);

	protected abstract TestResult run();

	/* Metodos redefinibles por el usuario */
	protected abstract void setUp();

	protected abstract void tearDown();
	
	public abstract Element toXMLElement();
	
	public abstract int countTests();
	
	public abstract int countErrors();
	
	public abstract int countFailures();
=======
package grupo11.frameworktests;

import java.util.Collection;
import java.util.TreeSet;

/* Test generico. Es el "componente" del patron Composite */
public abstract class GenericTest {
	public enum TagType {
		DEFAULT, FAST, SLOW, DB, INTERNET, SMOKE
	};

	private String name;
	private Collection<TagType> tags;
	private boolean skip;
	private double maxTime;
	
	

	public double getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(double maxTime) {
		this.maxTime = maxTime;
	}

	protected GenericTest(String name) {
		this.name = name;
		skip = false;
		tags = new TreeSet<TagType>();
		maxTime = -1;
	}

	public String getName() {
		return name;
	}

	public Collection<TagType> getTags() {
		return tags;
	}

	public void addTag(TagType tag) {
		tags.add(tag);
	}

	public boolean isSkippable() {
		return skip;
	}

	public void setSkippable() {
		skip = true;
	}

	public void setNotSkippable() {
		skip = false;
	}

	public abstract void setTestCollectionContenedora(String nombreContenedora);

	public abstract String getTestCollectionContenedora();

	/* Metodo redefinible por TestCollection */
	protected abstract boolean add(GenericTest test);

	protected abstract TestResult run();

	/* Metodos redefinibles por el usuario */
	protected abstract void setUp();

	protected abstract void tearDown();
>>>>>>> 93db45ef3d1a9956d4502de525e7f3fdfd806d63
}