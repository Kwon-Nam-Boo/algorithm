package com.ssafy;

public class Truck extends Car {
	int ton;

	public Truck() {
		this(null,null,0,0);
	}

	public Truck(String num, String model, int price,int ton) {
		super(num, model, price);
		this.ton = ton;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + " Truck [ton=" + ton + "]";
	}


}
