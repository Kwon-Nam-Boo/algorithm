package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17069_파이프_옮기기_2 {
	
	private static int N,ans;
	private static int[][] map;

	private static long[][][] dp;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		dp = new long[N][N][3];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기값		--> 시작값, type 0(오른쪽)
		dp[0][1][0] = 1;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(r == 0 && c == 0) continue;
				if(r == 0 && c == 1) continue;
				
				// 해당 위치가 빈칸이어야한다
				if(map[r][c] == 0) {
					if(isIn(r,c-1)) {	// 오른칸으로 갈수 있는경우
						dp[r][c][0] = dp[r][c-1][0] + dp[r][c-1][2];
					}
					if(isIn(r-1,c)) {	// 아래 칸으로 갈수 있는 경우
						dp[r][c][1] = dp[r-1][c][1] + dp[r-1][c][2];
					}
					if(isIn(r-1,c-1) && map[r-1][c] == 0 && map[r][c-1] == 0) {	//대각선인 경우는 오른, 아래도 빈칸이어야한다
						dp[r][c][2] = dp[r-1][c-1][0] + dp[r-1][c-1][1] + dp[r-1][c-1][2];
					}
				}
			}
		}
		/*for (int[][] a : dp) {
			for (int[] b : a) {
				System.out.println(Arrays.toString(b));
			}
			System.out.println();
		}*/					
		// 각 경우의 마지막 값을 더해주면 된다 
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<=N && c<=N;
	}
}
