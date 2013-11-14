package grupo11.frameworktests;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class XMLWriter {

	File fileReport = null; 
	FileWriter writer= null;
	PrintWriter printWriter = null;
	
	public XMLWriter(String filePath){
		fileReport =  new File(filePath);
		try{
			writer = new FileWriter(fileReport);
			printWriter = new PrintWriter(writer);
		} catch (Exception e) {
			System.out.println("Error al crear archivo XML");
		}
	}
	
	public void closeSaveReportXML(){
		try{
			writer.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
