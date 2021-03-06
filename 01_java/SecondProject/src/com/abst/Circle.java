package com.abst;

public class Circle extends Shape implements Comparable<Circle>{
	int r;
	
	public Circle(int r) {
		this.r =r;
	}

	@Override
	public double getArea() {
		return 3.14*r*r;
	}

	@Override
	public double getCircum() {
		return 2*3.14*r;
	}

	@Override
	public int compareTo(Circle o) {
		
		return o.r -r;
	}

	@Override
	public String toString() {
		return "Circle [r=" + r + "]";
	}
	
	
}
