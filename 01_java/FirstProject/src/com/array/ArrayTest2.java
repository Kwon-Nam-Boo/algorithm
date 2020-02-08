package com.array;

public class ArrayTest2 {
	public static void main(String[] args) {
		int[] score = {100, 23, 56, 78};
		String[] name = {"rolly", "kim", "queen"};
		double[] point = {2.3, 3.4, 6.77};
		
		System.out.println(score.length);
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}
		
		for(int value: score) {
			System.out.println(value);
		}
		
		for(String value2: name) {
			System.out.println(value2);
		}
		
		for(double value3: point) {
			System.out.println(value3);
		}
		
	}

}
