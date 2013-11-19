package grupo11.frameworktests.grupo13classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class XMLWriter {

	XMLOutputter xmlOutput = new XMLOutputter();
	String filePath;
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = "TestResult" + filePath + ".xml";
	}

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
			xmlOutput.output(doc, new FileWriter(getFilePath()));
		} catch (IOException io) {
			System.out.println("No se pudo crear " + getFilePath() + ", " + io.getMessage());
		}

	}

	public List<Element> getElements() {
		loadDoc();
		Element rootNode = doc.getRootElement();
		return castList(Element.class, rootNode.getChildren("testsuite"));
	}

	private void loadDoc() {
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			doc = saxBuilder.build(new File(getFilePath()));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
		List<T> r = new ArrayList<T>(c.size());
		for (Object o : c)
			r.add(clazz.cast(o));
		return r;
	}

}
