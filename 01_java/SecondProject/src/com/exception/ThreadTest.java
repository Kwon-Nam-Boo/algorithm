package com.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThreadTest {
	
	public static void main(String[] args) {
		//Thread t = new Thread();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello world!!!");
		
		try {
			FileInputStream fis = new FileInputStream("mystort.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}	
