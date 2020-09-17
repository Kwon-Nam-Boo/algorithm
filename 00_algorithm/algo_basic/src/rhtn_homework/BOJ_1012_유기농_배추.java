package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농_배추 {

	private static StringBuilder sb = new StringBuilder();
	private static int M,N,K,cnt;
	private static int[][] map;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static boolean[][] visited; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < TC; t++) {
			st = new StringTokenizer(br.readLine());
			// 가로 , 세로, 배추
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int b = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				
				map[a][b]=1;
			}
			
			int cnt=0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(!visited[r][c] && map[r][c]==1) {
						bfs(r,c);
						++cnt;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int r, int c) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r,c));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int px = dir[i][0] + p.x;
				int py = dir[i][1] + p.y;
				if(isIn(px,py) && !visited[px][py] && map[px][py]==1) {
					queue.offer(new Pair(px,py));
					visited[px][py] = true;
				}
			}
		}
		
	}
	
	public static class Pair{
		int x,y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
}
