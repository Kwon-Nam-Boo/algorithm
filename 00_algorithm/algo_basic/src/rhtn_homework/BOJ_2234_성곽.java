package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234_성곽 {

	private static int N, M, cnt, big;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] dir = {{-1,0}, {1,0}, {0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		cnt =0;
		big = 0;
		
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c]) {
					 bfs(r,c);
					 cnt++;
				}
			}
			
		}
		System.out.println(cnt);
		System.out.println(big);
		
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				for (int i = 1; i <= 8; i<<=1) {
					visited = new boolean[M][N];
					map[r][c]-=i;
					bfs(r,c);
					map[r][c]+=i;	
				}
			}
		}
		System.out.println(big);
	}
	
	private static void bfs(int r, int c) {
		int ans = 1;
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r,c));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + p.r;
				int nc = dir[i][1] + p.c;
				// 만약 벽이 없으면서 미방문 지역일 경우
				if(isIn(nr, nc) &&checkWall(i , map[p.r][p.c]) && !visited[nr][nc]) {
					queue.offer(new Pair(nr,nc));
					visited[nr][nc] = true;
					ans++;
				}
			}
		}
		big = Math.max(ans, big);
	}
	
	// 서:2^0  북:2^1  동:2^2 남2^3
	private static boolean checkWall(int i, int s) {
		switch(i) {
			// 북쪽
			case 0:
				if((s & 2) == 0) return true;
				else return false;
			// 남쪽
			case 1:
				if((s & 8) == 0) return true;
				else return false;
			// 서쪽
			case 2:
				if((s & 1) == 0) return true;
				else return false;
			// 동쪽
			case 3:
				if((s & 4) == 0) return true;
				else return false;
		}
		return false;
		
	}

	public static class Pair{
		int r,c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r <M && c< N;
	}

}
