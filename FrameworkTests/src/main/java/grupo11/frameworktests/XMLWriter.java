package grupo11.frameworktests;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class XMLWriter {

	XMLOutputter xmlOutput;
	String filePath;
	Document doc;

	public XMLWriter(Element element) {
		filePath = "TestsReport.xml";
		xmlOutput = new XMLOutputter();
		Element rootElement = new Element("testsuites");
		doc = new Document(rootElement);
		doc.setRootElement(rootElement);
		doc.getRootElement().addContent(element);
		xmlOutput.setFormat(Format.getPrettyFormat());

	}

	public void produceResult() {
		try {
			xmlOutput.output(doc, new FileWriter(filePath));
		} catch (IOException io) {
			System.out.println("No se pudo crear "+filePath+", "+io.getMessage());
		}

	}

}
