package com.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLStreamTest {

	public static void main(String[] args) {
		try {
		//	URL url = new URL("https://www.naver.com");
			URL url = new URL("https://www.daum.net/");
			InputStream in = url.openStream();			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String m = "";
			while((m = br.readLine()) != null)
				System.out.println(br.readLine());
		} catch (Exception e) {
			
		}
	}
}
