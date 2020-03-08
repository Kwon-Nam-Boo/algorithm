package com.ssafy.product;

public class TV extends Product {
	
	private String brand;
	private int tvSize;
	
	public TV(int id, String name, int price, int num,String brand, int tvSize) {
		super(id, name, price, num);
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
