package com.ssafy;

public class Bus extends Car {
	
	int seat; 
	public Bus() {
		this(null,null,0,0);
	}

	public Bus(String num, String model, int price, int seat) {
		super(num, model, price);
		this.seat = seat;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString()+ " Bus [seat=" + seat + "]";
	}

	
	
}
