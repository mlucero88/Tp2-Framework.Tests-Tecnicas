package grupo11.frameworktests;

public abstract class GenericTest {
	private String name;

	protected GenericTest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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