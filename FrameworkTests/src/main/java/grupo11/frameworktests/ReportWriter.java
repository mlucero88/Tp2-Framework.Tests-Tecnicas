package grupo11.frameworktests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ReportWriter {
	
	File fileReport = null; 
	FileWriter writer= null;
	BufferedWriter buffer = null;
	PrintWriter printWriter = null;
	
	public ReportWriter(String filePath){
		fileReport =  new File(filePath);
		try{
			writer = new FileWriter(fileReport,true);
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
	
	

}
