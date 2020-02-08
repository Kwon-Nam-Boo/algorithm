package com.ssafy.products;


public class Refrigerator extends Product {
	
	int refSize;

	public Refrigerator(int id, String name, int price, int num,int refSize) {
		super(id, name, price, num);
		this.refSize = refSize;
	}

	public int getRefSize() {
		return refSize;
	}

	public void setRefSize(int refSize) {
		this.refSize = refSize;
	}

	@Override
	public String toString() {
		return super.toString() + ", refSize=" + refSize;
	}
	
}
