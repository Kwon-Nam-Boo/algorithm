package com.xml;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class WeatherSAXParser {
	private static List<Weather> list;
	
	public WeatherSAXParser(){
		SAXParser parser = null;
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			
			WeatherSAXHandler handler = new WeatherSAXHandler();
			URL url = new URL("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108");
			InputSource is = new InputSource(url.openStream());
			is.setEncoding("utf-8");
			parser.parse(is, handler);
			list = handler.getList();
		} catch (SAXParseException spe) {
			System.out.println(spe.getLineNumber() + " line");
			System.out.println(spe.getMessage());
			System.exit(0);
		} catch (SAXException se) {
			System.out.println(se.getMessage());
			System.exit(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	
	
	public static void main(String[] args) {
		WeatherSAXParser parse = new WeatherSAXParser();
	
		for (Weather weather : list) {
			System.out.println(weather);
		}
	}
}
