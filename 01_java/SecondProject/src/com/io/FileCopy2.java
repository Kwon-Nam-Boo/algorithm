package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) throws Exception {
		FileInputStream fis;
		FileOutputStream fos;
		
		fis = new FileInputStream("src\\com\\io\\FileCopy.java");	//원본파일
		fos = new FileOutputStream("src\\com\\io\\FileCopy2.java");	//복사파일
		
		for (int i = 0; (i = fis.read())!= -1;) {
			fos.write(i);
		}
		fis.close();
		fos.close();

		System.out.println("file copied..");
	}
}
