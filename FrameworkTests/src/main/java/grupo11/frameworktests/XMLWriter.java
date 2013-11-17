package grupo11.frameworktests;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class XMLWriter {

	XMLOutputter xmlOutput = new XMLOutputter();
	String filePath = new String("TestsReport.xml");
	Document doc;

	public XMLWriter(Element element) {
		Element rootElement = new Element("testsuites");
		doc = new Document(rootElement);
		doc.setRootElement(rootElement);
		addElement(element);
	}
	
	public void addElement(Element element) {
		doc.getRootElement().addContent(element);
	}

	public void produceResult() {
		try {
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(filePath));
		} catch (IOException io) {
			System.out.println("No se pudo crear "+filePath+", "+io.getMessage());
		}

	}

}
