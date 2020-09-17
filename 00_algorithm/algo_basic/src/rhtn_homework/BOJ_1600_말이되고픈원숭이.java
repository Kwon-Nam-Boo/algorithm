package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {

	private static StringBuilder sb = new StringBuilder();
	private static int K;	// K:말처럼 뛸수 있는 횟수
	private static int W,H;	// 가로, 세로
	private static int[][] map;
	private static boolean[][][] visited;
	
	private static int[][] dir_H = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}}; // 말의 이동 경우
	private static int[][] dir_M = {{-1,0},{1,0},{0,-1},{0,1}}; // 원숭이 이동 경우
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K =Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H =Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[H][W][K+1];				// 3차원 방문처리
		bfs(0,0,K,0);
		
		System.out.println(sb);
		
	}
	
	private static void bfs(int x, int y,int k,int cnt) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(x,y,k,cnt));
		visited[x][y][k] = true;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			if(p.x == H-1 && p.y == W-1) {			// 해당 위치 도착 cnt 출력
				sb.append(p.cnt);
				return;
			}
									
			for (int i = 0; i < dir_M.length; i++) {	// Monkey처럼 뛰기
				int mx = dir_M[i][0] + p.x;
				int my = dir_M[i][1] + p.y;
				if(isIn(mx,my) && map[mx][my]!=1 && !visited[mx][my][p.k]) {
					queue.offer(new Pair(mx,my,p.k,p.cnt+1));
					visited[mx][my][p.k] =true;
				}
			}
			if(p.k!=0) {							// k가 남아있다면 Horse 처럼 뛰기
				for (int i = 0; i < dir_H.length; i++) {
					int hx = dir_H[i][0] + p.x;
					int hy = dir_H[i][1] + p.y;
					if(isIn(hx,hy) && map[hx][hy]!=1 && !visited[hx][hy][p.k-1]) {
						queue.offer(new Pair(hx,hy,p.k-1,p.cnt+1));
						visited[hx][hy][p.k-1] =true;
					}
				}
			}
		}
		sb.append(-1);			// 아예 도착 못함 -1 리턴
		return;
		
	}

	private static class Pair{
		int x,y,k,cnt;			// cnt: 뛴 횟수

		public Pair(int x, int y, int k, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}
	
	private static boolean isIn(int r,int c) {
		return r>=0 && c>=0 && r<H && c<W;
	}
}
