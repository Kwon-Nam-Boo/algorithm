package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	
	private static int R;
	private static int C;
	private static int max;
	private static int count;
	private static String[][] map;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static Set<String> alpha;
	private static boolean[] visited;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().split("");			//equal 주의
		}
		
		alpha = new HashSet<>();
		max =0;
		count =0;
		alpha.add(map[0][0]);
		dfs(new Pair(0,0));
		System.out.println(max);
	}	
	/*public static void dfs(Pair p) {
		count++;
		max = Math.max(max, count);
		
		
		for (int i = 0; i < dir.length; i++) {
			int a = p.x + dir[i][0];
			int b = p.y + dir[i][1];
			if(isIn(a,b) && !alpha.contains(map[a][b])) {
				alpha.add(map[a][b]);
				dfs(new Pair(a,b));
				alpha.remove(map[a][b]);
				count--;
			}
		}
	}*/
	public static void dfs(Pair p) {
		count++;
		max = Math.max(max, count);
		
		
		for (int i = 0; i < dir.length; i++) {
			int a = p.x + dir[i][0];
			int b = p.y + dir[i][1];
			int tmp =map[a][b].charAt(0)-65;
			if(isIn(a,b) && !visited[tmp]) {
				alpha.add(map[a][b]);
				dfs(new Pair(a,b));
				alpha.remove(map[a][b]);
				count--;
			}
		}
	}
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < R && c < C;
	}
	

}
