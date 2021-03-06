package com.exception;


public class ArrayTest {
	public static void main(String[] args) {
		int data[] = {10,20,30};
		
		for (int i = 0; i <= data.length; i++) {
			try {
				System.out.println(data[i]);	// 예외가 발생하는 부분
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("잘못된 배열의 인덱스 접근");
				System.out.println("oops.. sorry!");
				System.out.println(e.getMessage());
			}
			
		}
		
		System.out.println("done...");
	}
}
