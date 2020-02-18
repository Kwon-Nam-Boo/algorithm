package com.abst;

public class Meatball extends Sandwich {
	int calorie = 480;
	int sugar = 12;
	int protein = 21;
	int fat = 7;
	int natrium = 1000;
	
	@Override
	void make() {
		System.out.println("Add 4 meat ball!");
		System.out.println("Add 2 cheeze!");
		System.out.println("Add Amazing source!");
		System.out.println("Well Done!");
		System.out.println();
	}

	@Override
	void nutrition() {
		System.out.println("natrium is " + natrium + "mg");
		System.out.println("sugar is " + sugar+"g");
		System.out.println("protein is " + protein+"g");
		System.out.println("fat is " + fat+"g");
		System.out.println();
	}

	@Override
	void calorie() {
		System.out.println("calorie is " + calorie +"kcal");
		System.out.println();
	}

}
