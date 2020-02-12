package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {
	
	private static int R;
	private static int C;
	private static boolean[][] visited;
	private static int[][] map;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int[][] tmp;
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean [R][C];
		
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
	
	public static void bfs(int r, int c) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r,c));
		visited[r][c]=true;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int a = p.x + dir[i][0];
				int b = p.y + dir[i][1];
				if(isIn(a,b) && )
			}
		}
		
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r< R && c< C;
	}


}
