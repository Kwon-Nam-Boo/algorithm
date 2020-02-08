package com.array;

public class ArrayTest3 {
	public static void main(String[] args) {
		int[][] sc = new int[3][3];
		
		sc[0][1] = 100;
		sc[1][2] = 23;
		sc[2][0] = 77;
		
		
		for(int i = 0;i< sc.length;i++) {
			for(int j = 0; j< sc[i].length ; j++) {
				System.out.print(sc[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
