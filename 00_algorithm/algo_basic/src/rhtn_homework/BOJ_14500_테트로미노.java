package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {

	private static int N, M;
	private static int[][] map;
	private static int[][] dir = {{-1,0}, {1,0}, {0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				dfs(r,c,0);
			}
		}
	}

	private static void dfs(int r, int c, int d) {
		if(d == 4) {
			
		}
		for (int i = 0; i < dir.length; i++) {
			int nr = dir[i][0]  + r;
			int nc = dir[i][1]  + c;
			
		}
	}
	
}
