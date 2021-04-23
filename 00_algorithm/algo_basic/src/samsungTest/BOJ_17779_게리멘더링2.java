package samsungTest;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_17779_게리멘더링2 {
	
	private static int N,a1,a2,a3,a4,a5, ans;
	private static int[][] map;
	private static int[][] area;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		area = new int[N][N];
		ans = Integer.MAX_VALUE;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 1; c < N-1; c++) {
				
				for (int i = 1; i < N; i++) {
					for (int j = 1; j < N; j++) {
						if(!isSquare(r,c,i,j)) break;
						makeSquare(r,c,i,j);
					}
				}
				
			}
		}
		System.out.println(ans); 

	}

	private static void makeSquare(int r, int c, int d1, int d2) {
		area = new int[N][N];
		//System.out.println(r + " " + c +" " + d1 + " " + d2);
		for (int i = 0; i <=d1; i++) {
			area[r+i][c-i] = 5;
			for (int j = c -i; j <=c; j++) {
				area[r+i][j] = 5;
			}
		}
		for (int i = 0; i <=d2; i++) {
			area[r+i][c+i] = 5;
			for (int j = c; j <= c+ i; j++) {
				area[r+i][j] = 5;
			}
		}
		for (int i = 0; i <=d2; i++) {
			area[r+i+d1][c-d1+i] = 5;
			for (int j = c-d1+i; j <= c+ d2-d1; j++) {
				area[r+d1+i][j] = 5;
			}
		}
		for (int i = 0; i <=d1; i++) {
			area[r+d2+i][c+d2-i] = 5;
			for (int j = c +d2-d1; j <=c + d2 -i; j++) {
				area[r+d2+i][j] = 5;
			}
		}
		a1 = 0;
		a2 = 0;
		a3 = 0;
		a4 = 0;
		a5 = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(area[i][j] == 5) {
					a5+=map[i][j];
					continue;
				}
				if(i>=0 && i< r+d1 && j >=0 && j <= c) a1+= map[i][j];
				else if(i>=0 && i<= r+d2 && j > c && j < N) a2+= map[i][j];
				else if(i >= r+d1 && i < N && j >=0 && j < c-d1+d2) a3+= map[i][j];
				else if(i > r+d2 && i < N && j >= c-d1+d2 && j < N) a4+= map[i][j];
			}
		}

		int max = Math.max(a1,a2);
		max = Math.max(max,a3);
		max = Math.max(max,a4);
		max = Math.max(max,a5);
		
		int min = Math.min(a1,a2);
		
		min = Math.min(min,a3);
		min = Math.min(min,a4);
		min = Math.min(min,a5);
		
		ans = Math.min(max-min, ans);
	}
	
	private static boolean isSquare(int r,int c,int i,int j) {
		return c-i>=0 && c+ j< N && r+j+i<N;
	}
	
}
