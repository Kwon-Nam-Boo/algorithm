package com.array;

public class ArrayTest {
	public static void main(String[] args) {
		
		int cnt= 88;
		System.out.println(cnt);		// 초기화 작업 필요
		
		int[] a = new int[100];
		double[] point = new double[200];
		boolean[] flag = new boolean[500];
		String[] name = new String[30];
		
		System.out.println(a[28]);
		System.out.println(point[189]);
		System.out.println(flag[326]);
		System.out.println(name[16]);
		
		/*point[0] = 2.19;
		point[1] = 3.11;
		point[2] = 22.9;*/
		
		/*for (int i = 0; i < point.length; i++) {
			System.out.println(point[i]);
		}
		*/
		int[] score; 			//배열의 선언
		score = new int[3];		//배열의 생성, 크기 지정
		
		score[0]= 90;			//배열 사용
		score[1]= 30;
		score[2]= 100;
		
		/*System.out.println(score[0]);	// 배열 사용
		System.out.println(score[1]);
		System.out.println(score[2]);*/
		
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}
	}
}
