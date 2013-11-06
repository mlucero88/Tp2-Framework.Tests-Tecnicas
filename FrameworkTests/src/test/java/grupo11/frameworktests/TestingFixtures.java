package grupo11.frameworktests;

import grupo11.frameworktests.setupclasses.TestCollectionNivel0;
import grupo11.frameworktests.setupclasses.TestCollectionNivel1;
import grupo11.frameworktests.setupclasses.UnitTestNivel1;
import grupo11.frameworktests.setupclasses.UnitTestNivel2;
import grupo11.frameworktests.setupclasses.UnitTestNivel2Bis;

import org.junit.Before;
import org.junit.Test;

public class TestingFixtures {
	private TestCollection testsNivel0;

	@Before
	public void setUp() {
		testsNivel0 = new TestCollectionNivel0("CollectionNivel0");
		GenericTest unTestNivel1 = new UnitTestNivel1("UnitNivel1");
		GenericTest testsNivel1 = new TestCollectionNivel1("CollectionNivel1");
		GenericTest unTestNivel2 = new UnitTestNivel2("UnitNivel2");
		GenericTest unTestNivel2Bis = new UnitTestNivel2Bis("UnitNivel2Bis");

		testsNivel0.add(unTestNivel1);
		testsNivel0.add(testsNivel1);
		testsNivel1.add(unTestNivel2);
		testsNivel1.add(unTestNivel2Bis);
	}

	@Test
	public void test() {
		testsNivel0.run();
	}
}