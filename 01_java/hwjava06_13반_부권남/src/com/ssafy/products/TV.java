package com.ssafy.products;

public class TV extends Product {
	
	String brand;
	int tvSize;
	
	public TV(int id, String name, int price, int num,String brand, int tvSize) {
		super(id, name, price, num);
		// TODO Auto-generated constructor stub
		this.brand = brand;
		this.tvSize = tvSize;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getTvSize() {
		return tvSize;
	}

	public void setTvSize(int tvSize) {
		this.tvSize = tvSize;
	}

	@Override
	public String toString() {
		return super.toString() + ", brand=" + brand + ", tvSize=" + tvSize;
	}
	

}
