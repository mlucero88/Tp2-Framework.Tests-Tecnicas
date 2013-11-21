package grupo11.queue.tests;

import grupo11.frameworktests.NameRegister;
import grupo11.frameworktests.RunTags;
import grupo11.frameworktests.RunTemplate;
import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.TestCollectionResult;
import grupo11.frameworktests.TestReport;
import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.GenericTest.TagType;

public class PruebaColaTags {

	public static void main(String[] args) {
		TestCollection tests = new TestCollection("TestDeCola1");

		UnitTest test1 = new TestColaVacia("TestColaVacia");
		tests.add(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		tests.add(test2);
		UnitTest test3 = new TestSize("TestSize");
		tests.add(test3);
		// Agrego TAGS
		test1.addTag(TagType.SLOW);
		test3.addTag(TagType.SLOW);

		RunTemplate runMethod = new RunTags(TagType.SLOW);
		tests.setRunMethod(runMethod);
		tests.setStore("unStoreCualquiera10");
		tests.storeMode();
		
		
		TestCollectionResult results = (TestCollectionResult) tests.run();
		NameRegister.getInstance().clear();
		TestCollection tests2 = new TestCollection("TestDeCola1");
		tests2.setStore("unStoreCualquiera10");
		tests2.recoverMode();
		tests2.recover();
		tests2.run();

		TestReport report = new TestReport(results);
		report.generarReporteEnArchivo();
		report.mostrarEstadisticasPorPantalla();

	}
}
