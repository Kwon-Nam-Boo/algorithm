package com.exception;


class Car{
	int num =1234;
}
public class ExceptionTest {
	public static void main(String[] args) {
		int result = 0;
		int a =13, b=0;
		Car c = null;
		
		try {
			result = a/b;
			System.out.println(c.num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("언제나");
		}
		
		
		
		
		/*try {
			result = a/b;
			System.out.println(c.num);
			
		}catch(ArithmeticException e) {
			result = 9999;
		}catch(NullPointerException n) {
			c = new Car();
		}
		System.out.println(c.num);
		System.out.println(result);*/
		
	}
}
