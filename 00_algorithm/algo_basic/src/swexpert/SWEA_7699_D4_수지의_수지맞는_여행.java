package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7699_D4_수지의_수지맞는_여행 {
	
	private static int R;
	private static int C;
	private static int max;
	private static String[][] map;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			st = new StringTokenizer(br.readLine());
			R= Integer.parseInt(st.nextToken());
			C= Integer.parseInt(st.nextToken());
			map = new String[R][C];
			visited = new boolean['Z' -'A'+1];
			for (int r = 0; r < R; r++) {
				map[r] = br.readLine().split("");
			}
			
			max =1;
			visited[map[0][0].charAt(0) -'A'] =true;
			dfs(new Pair(0,0),1);
			visited[map[0][0].charAt(0) -'A'] =false;
			sb.append(max).append("\n");
		}
		System.out.println(sb);
		
	}
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static boolean isIn(int r , int c) {
		return r>=0 && c>=0 && r< R && c < C; 
	}
	
	public static void dfs(Pair p, int r) {
		if(max==26) return;
		max = Math.max(max, r);
		
		for (int i = 0; i < dir.length; i++) {
			int a = dir[i][0] + p.x;
			int b = dir[i][1] + p.y;
			if(isIn(a,b) && !visited[map[a][b].charAt(0) - 'A']) {		// 방문한적없고 처음보는 알파벳이라면
				visited[map[a][b].charAt(0) - 'A'] =true;
				dfs(new Pair(a,b), r+1);
				visited[map[a][b].charAt(0) - 'A'] =false;
				
			}
		}
	}

}
