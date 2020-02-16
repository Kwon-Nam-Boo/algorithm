package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2583_영역_구하기 {

	private static int M;
	private static int N;
	private static int K;
	
	private static List<Integer> result = new ArrayList<>();
	private static int count;
	private static int[][] map;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		K = Integer.parseInt(st.nextToken());
		int space = 0;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a =  Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			int m =  Integer.parseInt(st.nextToken());
			int n =  Integer.parseInt(st.nextToken());
			
			for (int r = a; r < m; r++) {
				for (int c = b; c < n; c++) {
					map[r][c]=1;
				}
			}
			count =0;
		
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(!visited[r][c] && map[r][c] == 0) {
					dfs(new Pair(r,c));
					result.add(count);
					space++;
					count=0;
				}
				
			}
		}
		Collections.sort(result);
		sb.append(space).append("\n");
		for (int i = 0; i < space; i++) {
			sb.append(result.get(i)).append(" ");
		}
		System.out.println(sb);
		
		
	}
	public static void dfs(Pair p) {
		
		visited[p.x][p.y] =true;
		count ++;
		for (int i = 0; i < dir.length; i++) {
			int a = p.x + dir[i][0];
			int b = p.y + dir[i][1];
			if(isIn(a,b) && !visited[a][b] && map[a][b] == 0) {
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
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < N  && c < M;
	}

}
