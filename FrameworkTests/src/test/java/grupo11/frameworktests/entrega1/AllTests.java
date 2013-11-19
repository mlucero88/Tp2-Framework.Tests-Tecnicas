package grupo11.frameworktests.entrega1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestingFixtures.class, TestingReportTest.class, TestingTestCollection.class, TestingUnitTest.class,
		TestingValidationTest.class })
public class AllTests {

}
