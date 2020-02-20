package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9663_N_Queen {
	
	private static int N;
	private static int count;
	private static int[][] map;
	private static int[] map2;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 
		 map = new int[N][N];
		 map2 = new int[N];
		 //Arrays.fill(map2, -1);
		 //dfs(0);
		 dfs2(0);
		 System.out.println(count);
		 
	}
/*	public static void dfs(int r) {
		if(r == N) {
			for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println();
			return;
		}else {
			for (int c = 0; c < N; c++) {
				if(isPromising(r,c)) {					// 가능하다면!
					map[r][c] = 1;
					dfs(r+1);						// 다음줄로 넘어간다.
					map[r][c] = 0;
				}
			}
		}
		
	}
	
	public static boolean isPromising(int r, int c) {
		for (int i = r-1, j=1; i >= 0; i--,j++) {
			if(c-j >=0 && map[i][c-j]==1) {
				return false;
			}
			if(c+j <N && map[i][c+j]==1) {
				return false;
			}
			if(map[i][c]==1) {
				return false;
			}
		}
		return true;
	}*/
	
	public static void dfs2(int r) {				/// r 은 놓을 퀸 	row은 index와 비슷,
		if(r == N) {
			//System.out.println(Arrays.toString(map2));
			count++;
			//System.out.println();
			return;
		}else{
			for (int c = 0; c < N; c++) {
				if(isPromising(r, c)) {					// 가능하다면!
					map2[r] = c;
					dfs2(r+1);						// 다음줄로 넘어간다.
				}
			}
		}
		
	}
	
	public static boolean isPromising(int row, int c) {
		for (int i = row-1; i >= 0; i--) {
			if(map2[i] == c) {
				return false;
			}
			if((row -i) == Math.abs(c- map2[i])) {
				return false;
			}
		}
		return true;
	}

}
