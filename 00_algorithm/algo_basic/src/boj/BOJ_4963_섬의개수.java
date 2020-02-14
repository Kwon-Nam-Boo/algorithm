package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	
	private static int N;
	private static int M;
	private static int[][] map;
	private static int[][] visited;															// 방문
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};	// 방향

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N ==0 && M ==0) break;
			map = new int[M][N];
			visited = new int[M][N];
			for (int r = 0; r < M; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 
			int count=0;
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if(visited[r][c] == 0 && map[r][c] ==1) {								// 방문한적이 없고 섬이면
						bfs(r,c);															// bfs를 돌린다
						count++;
					}
				}
			}
			System.out.println(count);														// 돌린 횟수 == 섬 횟수
		}
	}
	//
	public static void bfs(int x, int y) {													// bfs 탐색
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(x,y));
		visited[x][y] =1;
		
		while(queue.size()!=0) {
			Pair tmp = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int a = tmp.x + dir[i][0];
				int b = tmp.y + dir[i][1];
				if(isIn(a,b) && visited[a][b] == 0 && map[a][b] ==1) {
					queue.offer(new Pair(a,b));
					visited[a][b] =1;
				}
				
			}
		}
		
		
	}
	 public static class Pair{
		 int x;
		 int y;
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		 
	 }
	 public static boolean isIn(int r, int c) {
		 return r>=0 && c>=0 && r< M && c<N;
	 }
}
