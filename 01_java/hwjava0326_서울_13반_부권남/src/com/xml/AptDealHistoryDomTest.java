package com.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AptDealHistoryDomTest{
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in); 
		File file = new File("src/xml/AptDealHistory.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//DocumentBuilder : dom parser
		DocumentBuilder parser = factory.newDocumentBuilder();
		// 파싱된 문서의 꼭대기(전체) /
		Document doc = parser.parse(file);
		// 핸들러 불 필요..
		
		// 루트 element --> employees
		Element root = doc.getDocumentElement();
		//System.out.println("root element: " + root.getNodeName());
		
		String input = sc.nextLine();
		
		NodeList list = doc.getElementsByTagName("item");
		List<Apt> alist = new ArrayList<Apt>();
		
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);	// Employee 1개 
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element ele = (Element) node;
				
				String name = ele.getElementsByTagName("아파트").item(0).getTextContent();
				if(!name.contains(input)) {
					continue;
				}
				String beob = ele.getElementsByTagName("법정동").item(0).getTextContent();
				String price = ele.getElementsByTagName("거래금액").item(0).getTextContent();
				
				Apt apt = new Apt();
				apt.setName(name);
				apt.setBeop(beob);
				apt.setPrice(price);
				
				alist.add(apt);
			}
		}
		for (Apt a : alist) {
			System.out.println(a);
		}
	}
}
