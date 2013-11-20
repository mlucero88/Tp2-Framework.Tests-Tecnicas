package grupo13;

import grupo11.frameworktests.entrega1.TestingFixtures;
import grupo11.frameworktests.entrega1.TestingReportTest;
import grupo11.frameworktests.entrega1.TestingTestCollection;
import grupo11.frameworktests.entrega1.TestingUnitTest;
import grupo11.frameworktests.entrega1.TestingValidationTest;
import grupo11.frameworktests.entrega2.TestWithTagInCollection;
import grupo13.frameworktests.entrega2_3.TestPerformance;
import grupo13.frameworktests.entrega2_3.TestPersistenceAndStores;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestWithTagInCollection.class, TestingFixtures.class, TestingReportTest.class,
		TestingTestCollection.class, TestingUnitTest.class, TestingValidationTest.class, TestPerformance.class,
		TestPersistenceAndStores.class })
public class AllJUnitTests {

}
