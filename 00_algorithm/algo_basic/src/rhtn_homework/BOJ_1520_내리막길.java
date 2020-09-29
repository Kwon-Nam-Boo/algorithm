package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520_내리막길 {

	private static StringBuilder sb = new StringBuilder();
	private static int R,C;
	private static int[][] dist = {{1,0},{0,1},{0,-1},{-1,0}};
	private static int[][] DP;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		DP = new int[R][C];
		for (int[] d :DP) {
			Arrays.fill(d, -1);
		}
		
		System.out.println(dfs(0,0));
	}
	public static int dfs(int r, int c) {
		if(R-1 == r && C-1 ==c) {
			return 1;
		}
		// 방문 처리를 하는 셈이다(이미 들린 곳은 어차피 따로 업데이트가 될 것이기 때문에, 안간곳만 간다)
		if(DP[r][c] ==- 1) {
			// 0 으로 시작
			DP[r][c] = 0;
			for (int i = 0; i < dist.length; i++) {
				int nr = dist[i][0] + r;
				int nc = dist[i][1] + c;
				if(isIn(nr,nc) && map[nr][nc]< map[r][c]) {
					DP[r][c] = DP[r][c] + dfs(nr,nc);
				}
			}
		}
		return DP[r][c];
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < R && c < C;
	}
}
