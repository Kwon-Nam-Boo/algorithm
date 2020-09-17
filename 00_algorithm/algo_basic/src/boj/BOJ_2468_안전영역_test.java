package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역_test {

	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] dir = {{-1,0} ,{1,0} ,{0,-1} ,{0,1}};
	private static int depth;
	private static int ans;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
//		for (int[] g : map) {
//			System.out.println(Arrays.toString(g));
//		}
		depth =0;
		ans = 0;
		
		while(true) {
			int cnt=0;
			visited = new boolean[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(depth<map[r][c] && !visited[r][c]) {
						bfs(new Pair(r,c));
						cnt++;
					}
				}
			}
			if(cnt ==0) break;
			ans = Math.max(ans, cnt);
			depth++;
		}
		System.out.println(ans);
		
	}
	private static void bfs(Pair p) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(p);
		visited[p.x][p.y] = true;
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int px = dir[i][0] + tmp.x;
				int py = dir[i][1] + tmp.y;
				if(isIn(px, py) && !visited[px][py] && map[px][py] > depth) {
					queue.offer(new Pair(px, py));
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
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r <N && c<N;
	}
	
}
