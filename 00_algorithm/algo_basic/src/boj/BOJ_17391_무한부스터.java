package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17391_무한부스터 {
	
	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] dir= {{1,0},{0,1}};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
	}
	public static void bfs() {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(0,0));
		visited[0][0] = true;
		
		int dis =0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				Pair tmp = queue.poll();
				// 도착 경우
				if(tmp.x == N-1 && tmp.y == M-1) {
					System.out.println(dis);
					return;
				}
				for (int k = 1; k <= map[tmp.x][tmp.y]; k++) {
					for (int j = 0; j < dir.length; j++) {
						int a = tmp.x + k*dir[j][0];			// 곱만큼도 확인해야한다.
						int b = tmp.y + k*dir[j][1];
						if(isIn(a,b) && !visited[a][b]){
							queue.offer(new Pair(a,b));
							visited[a][b] = true;
						}
					}
				}
				
			}
			dis++;
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
		return r<N && c<M;
	}
}
