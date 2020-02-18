package com.inter;

public class ICircle implements IShape{
	int r;
	
	public ICircle(int r) {
		this.r = r;
	}

	@Override
	public double getArea() {
		
		return Math.PI*r*r;
	}

	@Override
	public double getCircum() {
		
		return 2*Math.PI*r;
	}
	
}
