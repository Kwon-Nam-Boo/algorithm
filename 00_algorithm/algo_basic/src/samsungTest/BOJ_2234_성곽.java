package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2234_성곽 {
	
	private static int N,M,max, room;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for (int r = 0; r < M ; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = 0;
		room = 0;
		visited = new boolean[M][N];
		// 1,2 방의개수, 가장 넓은 방
		largestRoom();
		System.out.println(room);
		System.out.println(max);
		// 3. 벽하나 제거 , 가장넓은 방 
		deleteLargestRoom();
		System.out.println(max);
	}

	private static void deleteLargestRoom() {
		max = 0;
		for (int r = 0; r < M ; r++) {
			for (int c = 0; c < N; c++) {
				for (int i = 0; i < dir.length; i++) {
					int nr = dir[i][0] + r;
					int nc = dir[i][1] + c;
					// 만약 벽이라면, 단 범위 밖은 아닌
					if(isIn(nr,nc) && (((1<<i) & map[r][c]) > 0)){
						map[r][c]-=(1<<i);
						visited = new boolean[M][N];
						largeBfs(r,c);
						map[r][c]+=(1<<i);
					}
				}
			}
		}
		//System.out.println(max);
		
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >=0 && r< M && c < N;
	}

	private static void largestRoom() {
		
		for (int r = 0; r < M ; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c]) {
					largeBfs(r,c);
				}
			}
		}
		//System.out.println(max);
		
	}

	private static void largeBfs(int r, int c) {
		
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r,c));
		visited[r][c] = true;
		
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			int x = map[p.r][p.c];
			
			for (int i = 0; i < dir.length; i++) {
				// 벽이없다면
				if(((1<<i) & x) <= 0){
					int nr = dir[i][0] + p.r;
					int nc = dir[i][1] + p.c;
					if(!visited[nr][nc]) {
						queue.offer(new Pair(nr,nc));
						visited[nr][nc] = true;
						cnt++;
					}
				}
			}
		}
		room++;
		max = Math.max(max, cnt);
		
	}

	
	public static class Pair{
		int r, c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
}
