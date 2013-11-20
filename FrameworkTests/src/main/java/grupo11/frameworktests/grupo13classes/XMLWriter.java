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

	public XMLWriter() {
//		Element rootElement = new Element("testsuites");
//		doc = new Document(rootElement);
//		doc.setRootElement(rootElement);
	}

//	public XMLWriter(Element element) {
//		Element rootElement = new Element("testsuites");
//		doc = new Document(rootElement);
//		doc.setRootElement(rootElement);
//		addElement(element);
//	}

	public void addElement(Element element) {
		doc.getRootElement().addContent(element);
	}

	public void save() {
		try {
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(getFilePath()));
		} catch (IOException io) {
			System.out.println("No se pudo crear " + getFilePath() + ", " + io.getMessage());
		}

	}

	public List<Element> getElements() {
		Element rootNode = doc.getRootElement();
		return castList(Element.class, rootNode.getChildren("testsuite"));
	}
	
	public void remove(Element element) {
		element.getParent().removeContent(element);
	}

	public boolean open() {
		try {
			return openXmlDocument();
		} catch (IOException e) {
			System.out.println(" Error: ha intentado abrir un store inexistente. ");
		}
		return false;

	}

	private boolean openXmlDocument() throws IOException {
		try {
			SAXBuilder saxBuilder = new SAXBuilder();
			doc = saxBuilder.build(new File(getFilePath()));
			return true;
		} catch (JDOMException e) {
			System.out.println(" El store tiene un estado invalido: " + e.getMessage());
			System.out.println(" JDOMException: " + e.getMessage());
			return false;
		}
	}

	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
		List<T> r = new ArrayList<T>(c.size());
		for (Object o : c)
			r.add(clazz.cast(o));
		return r;
	}

	public void createStore() {
		try {
			openXmlDocument();
		} catch (IOException e) {
			Element rootElement = new Element("testsuites");
			doc = new Document(rootElement);
			doc.setRootElement(rootElement);
		}

	}

}
