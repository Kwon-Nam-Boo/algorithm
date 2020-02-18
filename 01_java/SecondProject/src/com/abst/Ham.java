package com.abst;

public class Ham extends Sandwich {

	int calorie = 290;
	int sugar = 8;
	int protein = 18;
	int fat = 1;
	int natrium = 800;
	
	@Override
	void make() {
		System.out.println("Add 4 Ham slice!");
		System.out.println("Add 2 cheeze!");
		System.out.println("Add mayo score!");
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
