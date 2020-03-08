package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
	
	private static int N;
	private static int M;
	private static int[][] map;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for (int r = 0; r < N; r++) {
			String[] src = br.readLine().split("");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(src[c]);
			}
		}
		bfs();
	}
	
	public static void bfs() {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(0,0,1,1));
		visited[0][0][1] =true;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			// 정답 조건
			if(p.x == N-1 && p.y == M-1) {
				System.out.println(p.c);
				return;
			}
			for (int i = 0; i < dir.length; i++) {
				int a = p.x + dir[i][0];
				int b = p.y + dir[i][1];
				if(a>=0 && b>=0 && a<N && b<M && !visited[a][b][p.w]) {
					if(map[a][b] == 0) {								// 평소대로 bfs
						queue.offer(new Pair(a,b,p.w,p.c+1));
						visited[a][b][p.w] = true;
					}
					else if(map[a][b] ==1 && p.w == 1) {				// 벽을 부술수 있으면 부수자
						int w = p.w-1;
						queue.offer(new Pair(a,b,w,p.c+1));
						visited[a][b][w] = true;						// 이미 부쉇으면 그상태로 bfs
					}
				}
			}
			
		}
		System.out.println(-1);
	}
	
	public static class Pair{
		int x;
		int y;
		int w;
		int c;
		public Pair(int x, int y, int w, int c) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.c = c;
		}
		
	}
}
