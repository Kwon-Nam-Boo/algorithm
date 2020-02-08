package com.array;

import java.util.Arrays;

public class ArrayDirection2 {
	static int N; // 배열의 크기

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] data = {
				{1,-2,3,4,5,6,7,8},
				{1,2,3,-4,5,6,7,8},
				{1,2,3,4,5,-6,7,8},
				{1,2,3,4,5,6,7,-8},
				{-1,2,3,4,5,6,7,8},
				{1,2,-3,4,5,6,7,8},
				{1,2,3,4,-5,6,7,8},
				{1,2,3,4,5,6,-7,8},
				
		};
		N =data.length;
		int[][] result = new int[N][N];
		
		int[] dx = {-1,1,0,0,1,1,-1,-1};							// 8방향
		int[] dy = {0,0,-1,1,-1,1,-1,1};
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int sum =0;
				for (int i = 0; i < 8; i++) {
					int nr = r + dx[i];
					int nc = c + dy[i];
					if(isIn(data,nr,nc) && data[nr][nc] >=0)		// 음수 예외 추가
						sum+=data[nr][nc];
				}
				result[r][c] = sum;
			}
		}
		System.out.println(Arrays.deepToString(result));
	}
	public static boolean isIn(int[][] data , int r, int c) {
		return r>=0 && c>=0 && r < N && c<N;
	}
	

}
