package com.ssafy;

import java.util.Arrays;

public class test {
	
	public static void main(String[] args) {
		
		int[][] a = new int[2][];
		a[0] = new int[] {1,2,3};
		a[1] = a[0];
		System.out.println(Arrays.toString(a[0])+" : "+ Arrays.toString(a[1]));
		a[0] = new int[1];
		System.out.println(Arrays.toString(a[0])+" : "+ Arrays.toString(a[1]));
		
		
	}
}
