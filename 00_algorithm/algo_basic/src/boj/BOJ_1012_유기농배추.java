package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	
	private static int R;
	private static int C;
	private static int V;
	private static int count;
	private static int[][] map;
	private static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	private static boolean[][] visited;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < TC; i++) {
			
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			visited = new boolean[R][C];
			/*for (int j = 0; j < R; j++) {
				System.out.println(Arrays.toString(map[j]));
			}*/
			V= Integer.parseInt(st.nextToken());
			
			
			for (int j = 0; j < V; j++) {				// 배추 삽입	
				st = new StringTokenizer(br.readLine());
				int a =Integer.parseInt(st.nextToken());
				int b =Integer.parseInt(st.nextToken());
				map[b][a]=1;
			}
			
			/*for (int j = 0; j < R; j++) {
				System.out.println(Arrays.toString(map[j]));
			}*/
			count =0;
			for (int r = 0; r < R; r++) {				
				for (int c = 0; c < C; c++) {
					if(!visited[r][c] && map[r][c] == 1) {
						dfs(new Pair(r,c));
						count ++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);

	}
	
	public static void dfs(Pair p) {
		// base
		visited[p.x][p.y] = true;
		
		for (int i = 0; i < dir.length; i++) {
			int a = p.x + dir[i][0];
			int b = p.y + dir[i][1];
			if(a>=0 && b>=0 && a < R && b < C && !visited[a][b] && map[a][b] ==1) {
				dfs(new Pair(a,b));
			}
			
		}
		
	}
	
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
}
