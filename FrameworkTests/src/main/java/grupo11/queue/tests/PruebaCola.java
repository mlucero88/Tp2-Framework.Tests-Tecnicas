package grupo11.queue.tests;

import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.TestCollectionResult;
import grupo11.frameworktests.TestReport;
import grupo11.frameworktests.UnitTest;

public class PruebaCola {

	public static void main(String[] args) {
		TestCollection tests = new TestCollection("TestDeCola1");
		
		UnitTest test0 = new TestColaLlenaQueFalla("TestColaLlenaQueFalla");
		tests.add(test0);

		UnitTest test1 = new TestColaVacia("TestColaVacia");
		tests.add(test1);
		UnitTest test2 = new TestColaLlena("TestColaLlena");
		tests.add(test2);
		UnitTest test3 = new TestSize("TestSize");
		tests.add(test3);
		UnitTest test4 = new TestTopConColaLlena("TestTopConColaLlena");
		tests.add(test4);
		UnitTest test5 = new TestTopConColaVacia("TestTopConColaVacia");
		tests.add(test5);
		UnitTest test6 = new TestRemoveConColaVacia("TestRemoveConColaVacia");
		tests.add(test6);
		

		
		TestCollection tests2 = new TestCollection("TestDeCola2");
		UnitTest test21 = new TestColaVacia("TestColaVacia2");
		tests2.add(test21);
		UnitTest test22 = new TestColaLlena("TestColaLlena2");
		tests2.add(test22);
		UnitTest test23 = new TestSize("TestSize2");
		tests2.add(test23);
		UnitTest test24 = new TestTopConColaLlena("TestTopConColaLlena2");
		tests2.add(test24);
		UnitTest test25 = new TestTopConColaVacia("TestTopConColaVacia2");
		tests2.add(test25);
		UnitTest test26 = new TestRemoveConColaVacia("TestRemoveConColaVacia2");
		tests2.add(test26);
		UnitTest test27 = new TestRemoveConColaLlena("TestRemoveConColaLlena2");
		tests2.add(test27);
		UnitTest test28 = new TestLlenarYVaciarCola("TestLlenarYVaciarCola2");
		tests2.add(test28);
		
		UnitTest test29 = new TestColaLlenaQueFalla("TestColaLlenaQueFalla");
		tests2.add(test29);
		
		tests.add(tests2);
		
		UnitTest test7 = new TestRemoveConColaLlena("TestRemoveConColaLlena");
		tests.add(test7);
		UnitTest test8 = new TestLlenarYVaciarCola("TestLlenarYVaciarCola");
		tests.add(test8);
		
		tests.setStore("Hola");
		tests.storeMode();
		
		
		
		TestCollectionResult results = (TestCollectionResult) tests.run();
		if (test0.isOK()) {
			System.out.println("aldsfhads");
		}
		
		TestReport report = new TestReport(results);
		report.generarReporteEnArchivo();
		report.mostrarEstadisticasPorPantalla();
		
	}
}