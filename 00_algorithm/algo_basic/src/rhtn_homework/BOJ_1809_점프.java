package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1809_점프 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		long[][] dp = new long[n][n];
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int len = map[i][j];
				if(len == 0 || dp[i][j] == 0) {
					continue;
				}
				int down = i+ len;
				int right = j+ len;
				
				if(down < n) {
					dp[down][j]+=dp[i][j];
				}
				if(right < n) {
					dp[i][right]+=dp[i][j];
				}
			}
		}
		
		
//		for (int i = 0; i < dp.length; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}	
		System.out.println(dp[n-1][n-1]);
	}
	
	public static class Pair {
		int r, c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + "]";
		}
		
		
	}
}
