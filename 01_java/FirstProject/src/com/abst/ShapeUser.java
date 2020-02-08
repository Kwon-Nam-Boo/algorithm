package com.abst;

public class ShapeUser {

	public static void main(String[] args) {
		Shape[] s = new Shape[3];		// 추상 클래스 타입 배열을 생성하는 것
		
		s[0] = new Circle(8);
		s[1] = new Rect(6,3);
		s[2] = new Rect(10,2);
		
		for(Shape value:s) {
			System.out.println(value.getClass().getSimpleName());
			System.out.println("area: "+value.getArea());
			System.out.println("circum: "+value.getCircum());
			System.out.println("----------------");
		}
	}

}
