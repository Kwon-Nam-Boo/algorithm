package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9663_NQueen {

	private static StringBuilder sb = new StringBuilder();
	private static int N,cnt;
	private static int[][] map;
	private static int[][] dir = {{-1,-1},{-1,0},{-1,1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		cnt =0;
		dfs(0);
		System.out.println(cnt);
	}
	
	
	private static void dfs(int r) {
		if(r == N) {
			cnt++;
			return;
		}
		
		for (int j = 0; j < N; j++) {
			map[r][j] = 1;
			if(check(r,j)) {
				dfs(r+1);
			}
			map[r][j] = 0;
		}
		
		
	}


	public static boolean check(int x, int y) {
		
		for (int i = 0; i < dir.length; i++) {
			int px = dir[i][0] + x;
			int py = dir[i][1] + y;
			while(isIn(px, py)) {
				if(map[px][py] == 1) return false;
				px+=dir[i][0];
				py+=dir[i][1];
			}
		}
		return true;
		
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r< N && c<N;
	}
	
}
