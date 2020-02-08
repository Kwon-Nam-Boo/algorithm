package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class BuildingBuild {

	public static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,1},{-1,1},{1,-1}};	// 8방향
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			int N = sc.nextInt();
			
			char[][] arr = new char[N][N];
			int[][] building = new int[N][N];
			
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr.length; c++) {
					arr[r][c]= sc.next().charAt(0);
					
				}
			}
			int max = 2;
			for (int r = 0; r < building.length; r++) {
				for (int c = 0; c < building.length; c++) {
					for (int j = 0; j < dir.length; j++) {
						int nr = r + dir[j][0];						// (dir)방향으로 이동한 r,c의 값이
						int nc = c + dir[j][1];
						if(isIn(arr,nc,nr)) {						// 배열 범위를 벗어나지 않으면 실행,벗어나면 실행 x 
							
							if(findG(arr, nr,nc)) {					//  G가 주변에 있으면 현재 빌등은 2층으로 확정
								building[r][c] = 2;
								break;
							}
						}
					}
					if(building[r][c]==0) {							// G가 없으면 빌딩의 모든 행과 열의 건물을 카운트
						int count =0;
						for (int a = 0; a < building.length; a++) {
							if(arr[r][a] == 'B') count++;
						}
						count--;
						for (int a = 0; a < building.length; a++) {
							if(arr[a][c] == 'B') count++;
						}
					
						building[r][c]=count;						// 현재 빌딩의  높이
						
					}
					max = Integer.max(max, building[r][c]);			// 최대 높이 찾기
				}
				
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	public static boolean isIn(char[][] arr, int row, int col) {			// row와 col이 배열 범위 안에 있는가..?
		return 0<=row && 0<=col && row< arr.length && col<arr[0].length;
	}
	public static boolean findG(char[][] arr,int row, int col) {			// 현재 row와 col이 G 인가 ..?
		if(arr[row][col]=='G')
			return true;
		return false;
	}
}
