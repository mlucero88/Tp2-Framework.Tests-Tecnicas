package grupo11.queue.tests;

import grupo11.frameworktests.TestCollection;
import grupo11.frameworktests.TestCollectionResult;
import grupo11.frameworktests.TestReport;
import grupo11.frameworktests.UnitTest;
import grupo11.frameworktests.UnitTestResult;
import grupo11.frameworktests.XMLWriter;

public class PruebaCola {

	public static void main(String[] args) {
		TestCollection tests = new TestCollection("TestDeCola1");

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
		
		// esto lo saco porque no sirve
//		TestCollectionResult Raiz = new TestCollectionResult("TestDeCola2");
//		UnitTestResult item1 = UnitTestResult.createSuccessfulResult("1");
//		Raiz.add(item1);
//		UnitTestResult item2 = UnitTestResult.createFailedResult("2", "fatal fail");
//		Raiz.add(item2);
//		UnitTestResult item3 = UnitTestResult.createSuccessfulResult("3");
//		Raiz.add(item3);
//		
//		TestCollectionResult padreInz = new TestCollectionResult("TestDeCola1");
//		
//		UnitTestResult item4 = UnitTestResult.createSuccessfulResult("1_1");
//		padreInz.add(item4);
//		UnitTestResult item5 = UnitTestResult.createFailedResult("1_2", "fatal fail");
//		padreInz.add(item5);
//		UnitTestResult item6 = UnitTestResult.createErrorResult("1_3","fatal error");
//		padreInz.add(item6);
//		
//		Raiz.add(padreInz);
		
		
		//tests.addRunOld(Raiz);
		
		
		
		/*mod0568 end*/
		
		TestCollectionResult results = (TestCollectionResult) tests.run();
		
		XMLWriter xmlWriter = new XMLWriter(results.toXMLElement());
		xmlWriter.produceResult();
		TestReport report = new TestReport(results);
		report.generarReporteEnArchivo();
		report.mostrarEstadisticasPorPantalla();
		
		// ---------- apartir de aca se testea lo tuyo Erik
		
		TestCollection testsDeNuevo = new TestCollection("TestDeCola1");
		
		UnitTest testQueNotieneQueCorrer = new TestLlenarYVaciarCola("TestLlenarYVaciarCola2");
		testsDeNuevo.add(testQueNotieneQueCorrer);
		
		UnitTest testQuetieneQueCorrer = new TestColaLlenaQueFalla("TestColaLlenaQueFalla");
		testsDeNuevo.add(testQuetieneQueCorrer);
		
		// ---------- Erik aca te seteo por parametro el objeto que necesitas.. es un TestCollectionResult
		
		//tests.addRunOld(Raiz); esto lo cambié por un setter y te puse un ejemplo a continuacion
		//lo que tenes q hacer es .. dentro del run te fijas si tiene un run previo y ahi haces eso
		// de filtrar cual ejecutar 
		
		testsDeNuevo.setPreviousRun(results);
		
		TestCollectionResult results2 = (TestCollectionResult) tests.run();
		
		XMLWriter xmlWriter2 = new XMLWriter(results2.toXMLElement());
		xmlWriter2.produceResult();
		report = new TestReport(results);
		report.generarReporteEnArchivo();
		report.mostrarEstadisticasPorPantalla();
	}
}