package com.ssafy.step01.recursive;

import java.util.Arrays;
import java.util.Scanner;

public class H04_Dicetest {
	
	static int N,M,number[],totalCnt;
	static boolean visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		M =sc.nextInt();
		number = new int[N];
		visited = new boolean[7];
		switch(M) {
			case 1:		// 1. 중복순열
				dice1(0);
				System.out.println(totalCnt);
				break;
			case 2:		// 2. 순열
				dice2(0);
				System.out.println(totalCnt);
				break;
			case 3:		// 3. 중복조합
				dice3(0,1);
				System.out.println(totalCnt);
				break;
			case 4:		// 4. 조합
				dice4(0,1);
				System.out.println(totalCnt);
				break;
		}
	}
	
	private static void dice1(int cnt) {
		if(cnt ==N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			number[cnt] = i;
			dice1(cnt+1);
		}
	}
	private static void dice2(int cnt) {
		if(cnt ==N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			if(!visited[i]) {
				visited[i] =true;
				number[cnt] = i;
				dice2(cnt+1);
				visited[i] = false;
			}
		}
	}
	private static void dice3(int cnt, int cur) {
		if(cnt ==N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for (int i = cur; i <= 6; i++) {
			number[cnt] = i;
			dice3(cnt+1,i);
		}
	}
	private static void dice4(int cnt, int cur) {
		if(cnt ==N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for (int i = cur; i <= 6; i++) {
			number[cnt] = i;
			dice4(cnt+1,i+1);
		}
	}


}
