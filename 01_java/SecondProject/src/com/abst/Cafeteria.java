package com.abst;

public class Cafeteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sandwich[] sand = new Sandwich[2];
		sand[0] = new Meatball();
		sand[1] = new Ham();
		
		for(Sandwich value: sand) {
			value.make();
			value.nutrition();
			value.calorie();
			System.out.println("-------------------");
		}
		
	}

}
