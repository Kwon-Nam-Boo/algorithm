package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9282_D4_초콜릿과_건포드 {
	
	private static int R;
	private static int C;
	private static int[][] map;
	private static int[][][][] memo;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			memo = new int[R+1][C+1][R+1][C+1];
			
			for (int[][][] m1 : memo) {						// 초기화
				for (int[][] m2 : m1) {
					for (int[] m3 : m2) {
						Arrays.fill(m3, Integer.MAX_VALUE);
					}
				}
			}
			
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			/*for (int i = 0; i <R; i++) {
				System.out.println(Arrays.toString(map[i]));
			}*/
			
			sb.append(dfs(0,0,R,C)).append("\n");
		}
		System.out.println(sb);
		
	}
	public static int dfs(int r, int c, int h, int w) {		// h,w: 가로세로 길이 
		if(h ==1 && w ==1) {
			return 0;
		}
		if(memo[r][c][h][w]!= Integer.MAX_VALUE) {
			return memo[r][c][h][w];
		}
		int sum = 0;
		for (int i = r; i < r + h ; i++) {
			for (int j = c; j < c+ w; j++) {
				sum+= map[i][j];
			}
		}
		
		for (int i = 1; i < h; i++) {
			memo[r][c][i][w] = dfs(r,c,i,w);
			memo[r+i][c][h-i][w] = dfs(r+i,c,h-i,w);
			memo[r][c][h][w] = Math.min(memo[r][c][h][w], (sum+memo[r][c][i][w]+memo[r+i][c][h-i][w]));
		}
		
		for (int i = 1; i < w; i++) {
			memo[r][c][h][i] = dfs(r,c,h,i);
			memo[r][c+i][h][w-i] = dfs(r,c+i,h,w-i);
			memo[r][c][h][w] = Math.min(memo[r][c][h][w], (sum+memo[r][c][h][i]+memo[r][c+i][h][w-i]));
		}
		return memo[r][c][h][w];
	}

}
