package com.computer;

public abstract class Parts {
	private String maker;
	private int price;
	
	//public Parts(){}
	
	public Parts(String maker, int price) {
		this.maker = maker;
		this.price = price;
	}

	public void info() {
		System.out.println("maker: " + maker);
		System.out.println("price: " + price);
		System.out.println("------------------------");
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
