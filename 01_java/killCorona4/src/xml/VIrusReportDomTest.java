package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class VIrusReportDomTest {
	public static void main(String[] args) {
		
		File file = new File("./src/xml/virus-report.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			
			Element root = doc.getDocumentElement();
			System.out.println("Root element: " + root.getNodeName());
			
			NodeList childNodes
		}catch(Exception e) {
			
		}
	}
}
