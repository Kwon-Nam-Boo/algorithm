package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14716_현수막 {
	
	private static int R;
	private static int C;
	private static int[][] map;
	private static boolean[][] visited;
	public static int[][] dir= {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int count=0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(!visited[r][c] && map[r][c]==1) {		// 방문한 적이 없고
					bfs(new Pair(r,c));
					count++;
				}
			}
		}
		System.out.println(count);
	}
	public static void bfs(Pair start) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(start);
		
		visited[start.x][start.y]=true;
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int a = dir[i][0] + tmp.x;
				int b = dir[i][1] + tmp.y;
				if(isIn(a,b) && !visited[a][b] && map[a][b]==1) {
					queue.offer(new Pair(a,b));
					visited[a][b]=true;
				}
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
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r< R && c< C;
	}
}
