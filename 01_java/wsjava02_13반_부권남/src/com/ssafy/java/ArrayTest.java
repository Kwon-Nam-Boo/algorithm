package com.ssafy.java;

import java.util.Scanner;

public class ArrayTest {
	
	public static void main(String[] args) {
		int[] nums = new int[1000];
		Scanner sc = new Scanner(System.in);
		
		int sum =0;
		for (int i = 0; i < 10; i++) {
				nums[i] = sc.nextInt();
				sum +=nums[i];
		}
		int min = nums[0];
		for (int i = 0; i < 10; i++) {
			if(min > nums[i])
				min = nums[i];
		}
		System.out.println("배열의합: " + sum);
		System.out.println("배열의 평균: "+ sum /10);
		System.out.println("배열의 최소값: " + min);
	}
}
