package grupo11.frameworktests;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/* Clase utilitaria para escribir en un archivo el reporte de los tests */
public class ReportWriter {
	
	File fileReport = null; 
	FileWriter writer= null;
	PrintWriter printWriter = null;
	private final static String SUBRAYADO_TESTSUITE = "---------------------------------------";
	private final static String SUBRAYADO_SUMMARY = "=======================================";
	private final static String ENCABEZADO_SUMMARY = "[failure] Summary";
	
	
	public ReportWriter(String filePath){
		fileReport =  new File(filePath);
		try{
			writer = new FileWriter(fileReport);
			printWriter = new PrintWriter(writer);
		} catch (Exception e) {
			System.out.println("Error al crear archivo");
		}
	}
	
	public void writeResult(String result){
		printWriter.println(result);
	}
	
	public void closeSaveReport(){
		try{
			writer.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public void writeEncabezadoSummary (){
		printWriter.println(" ");
		printWriter.println(ENCABEZADO_SUMMARY);
		printWriter.println(SUBRAYADO_SUMMARY);
	}
	
	public void writeLineaEnBlanco (){
		printWriter.println (" ");
	}
	
	public void writeEncabezadoTestSuite (String nombreTestSuite){
		printWriter.println("Inicio: " + nombreTestSuite);
		printWriter.println(SUBRAYADO_TESTSUITE);
	}
	
	public void writeMarcaFinTestSuite (String nombreTestSuite){
		printWriter.println("Fin: " + nombreTestSuite);
		printWriter.println(SUBRAYADO_TESTSUITE);
	}
	
	public void writeDivisionTestSuite (){
		printWriter.println(SUBRAYADO_TESTSUITE);
		printWriter.println(" ");
	}

}
