package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
	
	private static int N;
	private static int max =Integer.MIN_VALUE;
	private static int[][] area;
	private static boolean[][] visited;
	
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				area[r][c] = Integer.parseInt(st.nextToken());
				max = Math.max(max, area[r][c]);
			}
		}
		
		int n = 0;
		int result = 0;
		while(true) {
			int count =0;
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(area[r][c] > n && !visited[r][c]) {
						bfs(r,c,n);
						count++;
					}
				}
			}
			result = Math.max(result,count);
			
			n++;
			if(max == n) {
				break;
			}
		}
		System.out.println(result);
		
	}
	public static void bfs(int r, int c, int n) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r,c));
		visited[r][c] =true;
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int a = tmp.x + dir[i][0];
				int b = tmp.y + dir[i][1];
				if(isIn(a,b) && area[a][b] > n &&!visited[a][b]) {
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
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r< N && c< N;
	}

}
