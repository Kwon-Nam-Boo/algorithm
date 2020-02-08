package com.robot;

import java.util.Arrays;
import java.util.Scanner;

public class MazeTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC =sc.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			int N =sc.nextInt();
			
			boolean[][] visited = new boolean[N][N];
			int startR = sc.nextInt()-1;
			int startC = sc.nextInt()-1;
			
			int jump = sc.nextInt();
			
			for (int j = 0; j < jump; j++) {
				int r =sc.nextInt()-1;
				int c =sc.nextInt()-1;
				visited[r][c] = true;
			}
			
			int move =sc.nextInt();
			int[][] moving = new int[move][2];
			
			for (int r = 0; r < move; r++) {
				for (int c = 0; c < 2; c++) {
					moving[r][c] =sc.nextInt();
				}
			}
			
			
			for (int r = 0; r < move; r++) {
				int dir =moving[r][0];				
				int m =moving[r][1];
				
				if(startR-m >= 0 && dir == 1) {
					for (int j = 0; j < m; j++) {
						if(visited[startR][startC] == true) {
							startR = -1;
							startC = -1;
							break;
						}
							startR--;
					}
				}
				else if(startC+m <= N-1 && dir == 2) {
					for (int j = 0; j < m; j++) {
						if(visited[startR][startC] == true) {
							startR = -1;
							startC = -1;
							break;
						}
							startC++;
					}
				}
				else if(startR+m <= N-1 && dir == 3) {
					for (int j = 0; j < m; j++) {
						if(visited[startR][startC] == true) {
							startR = -1;
							startC = -1;
							break;
						}
							startR++;
					}
				}
				else if(startC-m >= 0 && dir == 4) {
					for (int j = 0; j < m; j++) {
						if(visited[startR][startC] == true) {
							startR = -1;
							startC = -1;
							break;
						}
							startC--;
					}
				}
				else {
					startR = -1;
					startC = -1;
					break;
				}
				
			}
			System.out.printf("%d %d",startR+1, startC+1);
			System.out.println();
			
		}
	}

}
