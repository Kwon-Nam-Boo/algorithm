package com.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class VirusReportSAXHandler extends DefaultHandler{
	
	boolean fauthor, fabout, fdate, fyear,fmonth, fday;
	StringBuilder data;
	StringBuilder dateStr = new StringBuilder();
	VirusReport report = new VirusReport();
	
	
	// 태그 중간 텍스트 만났을때
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		data.append(new String(ch,start,length));
	}
	//끝 태그
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(fauthor) {
			report.setAuthor(data.toString());
			fauthor =false;
		}
		else if(fabout) {
			report.setAbout(data.toString());
			fabout =false;
		}
		else if(fyear) {
			dateStr.append(data.toString());
			fyear =false;
		}
		else if(fmonth) {
			dateStr.append(data.toString());
			fmonth =false;
		}
		else if(fday) {
			dateStr.append(data.toString());
			fday =false;
		}
		else if(fdate) {
			report.setDate(dateStr.toString());
			fdate =false;
		}
		
		
	}
	// 시작 태그
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("author")){
			fauthor = true;
		}
		if(qName.equalsIgnoreCase("about")) {
			fabout = true;
		}
		if(qName.equalsIgnoreCase("date")) {
			fdate = true;
		}
		if(qName.equalsIgnoreCase("year")) {
			fyear = true;
		}
		if(qName.equalsIgnoreCase("month")) {
			fmonth = true;
		}
		if(qName.equalsIgnoreCase("day")) {
			fday = true;
		}
		data = new StringBuilder();
	}
	
	public VirusReport getVirusReport() {
		return report;
	}

}
