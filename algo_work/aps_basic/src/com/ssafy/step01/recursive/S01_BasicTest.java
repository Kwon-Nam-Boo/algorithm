package com.ssafy.step01.recursive;

import java.util.Scanner;

public class S01_BasicTest {
	static int N ,totalCnt;
	static int[] input;
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0);
		System.out.println(totalCnt);
	} 
	private static void generateSubset(int cnt) {
		if(cnt == N) {
			totalCnt++;
			for (int i = 0; i < N; i++) {
				System.out.print((isSelected[i]? input[i]:"X") + "\t");
			}
			System.out.println();
			return;
		}
		
		// 현재 원소 선택
		isSelected[cnt] =true;
		generateSubset(cnt+1);
		// 현재 원소 비선택
		isSelected[cnt] =false;
		generateSubset(cnt+1);
	}
}
