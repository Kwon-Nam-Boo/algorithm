package com.basic;

public class DataTypeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HelloWorld some;
		
		String name ="tommy";		//문자열, 참조형
		
		//기본형
		boolean flag =true;		// 논리 리터럴..?
		
		byte b =120;	//-128 ~127
		b+=1;
		// b = b + 1	오류)	큰타입 데이터 -> 작은타입 데이터로 하려고 해서
		b= (byte) (b + 1) ;		//원하는 타입 형변환
		
		short s = 3000;
		s = (short)(s+10);
								//정수 리터럴(값)
		int i = 12345;			
		char c = 97;
		c = 'A' + 2;
		
		//float f = 3.14;		실수형 리터럴은 무조건 8byte를 인식하기 떄문에 오류남 f를 붙이거나 double을쓰면 됨
		float f = 3.14f;
		
		double d =6.98;			//실수 리터럴(값)
		
		System.out.println("flag:" + flag);
		System.out.println("b:" + b);
		System.out.println("s:" + s);
		System.out.println("c:"+ c);
		System.out.println("f:" + f);
		System.out.println("d:" + d);

	}

}
