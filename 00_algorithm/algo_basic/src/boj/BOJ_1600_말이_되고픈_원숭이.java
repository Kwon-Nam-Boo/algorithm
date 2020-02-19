package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이_되고픈_원숭이 {

	private static int K;
	private static int W;
	private static int H;
	private static int[][] map;
	private static boolean[][][] visited;
	private static StringBuilder sb = new StringBuilder();
	// 숭이: 상하좌우
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	// 말: 1시,2시 + 4시,5시 + 7시,8시+ 10시,11시
	private static int[][] dirH = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(new Pair(0,0,K,0));
		System.out.println(sb);
	}
	public static void bfs(Pair p) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(p);
		visited[p.x][p.y][p.k] = true;
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			int curk = tmp.k;
			int curc = tmp.cnt;
			if(tmp.x == H-1 && tmp.y == W -1) {				// 해당 도착점 도착
				//System.out.println(curc);
				sb.append(curc);
				return;
			}
			// 4 방향 원숭이
			for (int i = 0; i < dir.length; i++) {
				int a = tmp.x + dir[i][0];
				int b = tmp.y + dir[i][1];
				if(isIn(a,b) && !visited[a][b][curk] && map[a][b] == 0) {
					queue.offer(new Pair(a,b,curk,curc+1));
					visited[a][b][curk] = true;
				}
			}
			if(curk ==0) {
				continue;
			}
			// 8방향 말
			for (int i = 0; i < dirH.length; i++) {
				int a = tmp.x + dirH[i][0];
				int b = tmp.y + dirH[i][1];
				if(isIn(a,b) && !visited[a][b][curk-1] && map[a][b] == 0) {
					queue.offer(new Pair(a,b,curk-1,curc+1));
					visited[a][b][curk-1] = true;
				}
			}
		}
		//System.out.println(-1);
		sb.append(-1);
		return;
	}
	
	public static class Pair{      
		int x;
		int y;
		int k;
		int cnt;

		public Pair(int x, int y, int k, int cnt) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + ", k=" + k + ", cnt=" + cnt + "]";
		}

	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < H && c < W;
	}

}
