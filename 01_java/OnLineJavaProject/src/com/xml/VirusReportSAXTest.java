package com.xml;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class VirusReportSAXTest {

	public static void main(String[] args) throws Exception{
		File file = new File("src/xml/virus-report.xml");
		
		//saxparer 만들어줌 객체생성하느게 아니라 그냥 받아옴
		// 팩토리가 먼저 필요하고 그걸 통해 파서를 만듬
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		// parsing 방법이 들어있다.
		VirusReportSAXHandler handler = new VirusReportSAXHandler();
		
		// 파서로 파싱함
		parser.parse(file,handler);
		
		VirusReport report = handler.getVirusReport();
		System.out.println(report);
	}

}
