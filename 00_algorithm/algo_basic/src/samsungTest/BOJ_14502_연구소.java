package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_14502_연구소 {
	
	private static int N,M, walls,ans, safe;
	private static int[][] map;
	private static List<Pair> virus;
	private static boolean[][] visited;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = 0;
		map = new int[N][M];
		virus = new ArrayList<>();
		walls= 3;
		
		for (int r = 0; r < N ;r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) virus.add(new Pair(r,c));
				else if(map[r][c] == 1) walls++;
			}
		}
		safe = N*M-walls;
		
		nCr(0,0);
		System.out.println(ans);
		
		Integer.parseInt("FF", 16);
	}
	
	private static void nCr(int d, int k) {
		
		if(d ==3) {
			moveVirus();
			return;
		}
		
		for (int i = k; i < N*M; i++) {
			
			int r = i / M;
			int c = i % M;
			if(map[r][c] == 0) {
				map[r][c] = 1;
				nCr(d+1, i+1);
				map[r][c] = 0;
			}
		}
		
	}

	private static void moveVirus() {
		Queue<Pair> queue = new LinkedList<>();
		visited = new boolean[N][M];
		int virusCnt = 0;
		
		for (int i = 0; i < virus.size(); i++) {
			Pair tmp = virus.get(i);
			queue.offer(tmp);
			visited[tmp.r][tmp.c] = true;
			virusCnt++;
		}
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + p.r;
				int nc = dir[i][1] + p.c;
				if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 0) {
					queue.offer(new Pair(nr, nc));
					visited[nr][nc] = true;
					virusCnt++;
				}
			}
		}
		ans = Math.max(ans, safe - virusCnt);
	}

	public static class Pair{
		int r,c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c< M;
	}

}
