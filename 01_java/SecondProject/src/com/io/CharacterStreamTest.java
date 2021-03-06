package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class CharacterStreamTest {
	public static void main(String[] args) throws Exception{
		File f = File.createTempFile("sample", "txt");
		
		
		//파일에서 쓰기
		FileWriter fw = new FileWriter(f);				// character stream 종류 (2byte 글자 한개를 코드값에 담아 전송)  node stream
		BufferedWriter bw = new BufferedWriter(fw); 	// process stream (버퍼가 내장된 파이프)
		
		bw.write("안녕하세요");
		bw.newLine();									// 줄바꿈
		bw.write("빨리");
		bw.newLine();
		bw.write("집에");
		bw.newLine();
		bw.write("가고");
		bw.newLine();
		bw.write("싶다");
		bw.newLine();
		bw.close();
		fw.close();
		
		// 파일에서 읽어오기
		FileReader fr = new FileReader(f);				// node stream
		//BufferedReader br = new BufferedReader(fr);		// process stream
		
		// system.in은 바이트 스트림
		// buffered는 char 단위
		// InputstreamReader는 바이트를 char로 종류를 바꿔준다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (String str;(str = br.readLine()) != null; ) {
			System.out.println(str);
		}
		
	}
}
