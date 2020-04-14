package com.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EmployeeDomTest {
	public static void main(String[] args) throws Exception{
		
		File file = new File("src/xml/employees.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//DocumentBuilder : dom parser
		DocumentBuilder parser = factory.newDocumentBuilder();
		// 파싱된 문서의 꼭대기(전체) /
		Document doc = parser.parse(file);
		// 핸들러 불 필요..
		
		// 루트 element --> employees
		Element root = doc.getDocumentElement();
		
		System.out.println("root element: " + root.getNodeName());
		NodeList list = doc.getElementsByTagName("Employee");
		List<Employee> elist = new ArrayList<Employee>();
		
		
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);	// Employee 1개 
			
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element ele = (Element) node;
				
				String id = ele.getAttribute("id");
				String name = ele.getElementsByTagName("name").item(0).getTextContent();
				String age = ele.getElementsByTagName("age").item(0).getTextContent();
				String gender = ele.getElementsByTagName("gender").item(0).getTextContent();
				String role = ele.getElementsByTagName("role").item(0).getTextContent();
				
				Employee emp = new Employee();
				emp.setAge(Integer.parseInt(age));
				emp.setGender(gender);
				emp.setId(Integer.parseInt(id));
				emp.setName(name);
				emp.setRole(role);
				
				elist.add(emp);
			}
		}
		for (Employee e : elist) {
			System.out.println(e);
		}
	}
}
