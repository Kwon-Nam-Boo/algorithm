package com.object;

public class Circle {
	//field
	//
	int r;
	
	//생성자
	public Circle() {
		this(0);
	}
	public Circle(int r) {
		this.r = r;
	}
	
	//method
	double getCircum() {
		return 2*r*Math.PI;
	}
	double getArea() {
		return r*r*Math.PI;
	}
	
}
