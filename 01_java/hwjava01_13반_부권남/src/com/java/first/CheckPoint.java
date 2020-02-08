package com.java.first;

import java.util.Scanner;

public class CheckPoint {
	public static void main(String[] args) {
		int weight, height, fat;
		
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		weight = sc.nextInt();
		
		fat =  weight + 100 - height;
		if(fat>0) {
			System.out.println("비만수치는 " + fat +"입니다");
			System.out.println("당신은 비만이군요");
		}
			
	}
}
