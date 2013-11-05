package grupo11.frameworktests.Dummy;

import static org.junit.Assert.*;
import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.UnitTest;

import org.junit.Test;

public class TestFixtures {

	@Test
	public void test() {
		TestCollection tests = new TestCollectionHijitus("HijitusCollection");
		UnitTest unTest = new UnitTestHijitus("HijitusTest");
		
		tests.add(unTest);
		tests.runSelection("H.*");
		tests.showTestResults();
		
		
	}

}
