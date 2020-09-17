package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1949_T_등산로_조성 {

	private static int K;
	private static int N;
	private static int max;
	
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			int top = 0;
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					top = Math.max(top, map[r][c]);
				}
			}
			
			max = 1;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == top) {
						dfs(r,c,1,map[r][c],false);
					}
				}
			}
			sb.append(max).append("\n");
			
			
		}
		System.out.println(sb);
	}

	public static void dfs(int r, int c ,int len,int before,boolean use) {
		max = Math.max(max, len);
		
		visited[r][c] = true;
		
		for (int i = 0; i < dir.length; i++) {
			int dr = dir[i][0] + r;
			int dc = dir[i][1] + c;
			
			// 이동 할 수 있는 범위 안에서
			if(isIn(dr,dc) && !visited[dr][dc]) {
				//깍은 적이 없다면?
				if(!use) {
					// 이전 값보다 이동된 값이 작다면?
					if(map[dr][dc] < before) {
						dfs(dr, dc, len+1, map[dr][dc], false);
					}else if(map[dr][dc] - K < before ){
						dfs(dr, dc, len+1, before-1, true);
					}
				}else{	// 이미 깎았다면
					if(map[dr][dc] < before) {
						dfs(dr, dc, len+1, map[dr][dc], true);
					}
				}
				
			}
			
		}
		visited[r][c] = false;
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r< N && c<N;
	}

}
