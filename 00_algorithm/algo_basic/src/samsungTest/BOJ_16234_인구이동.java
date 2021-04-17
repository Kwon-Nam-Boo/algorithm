package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16234_인구이동 {
	
	private static int N,L,R;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int[][] map;
	private static int[][] mapClone;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		mapClone = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		while(true) {
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(!visited[r][c]) bfs(new Pair(r,c));
				}
			}
			if(checkMove()) break;
			cnt++;
			reset();
		}
		System.out.println(cnt);
	}
	
	private static void reset() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = mapClone[r][c];
			}
		}
	}

	private static boolean checkMove() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] != mapClone[r][c]) return false;
			}
		}
		return true;
	}

	private static void bfs(Pair start) {
		Queue<Pair> queue = new LinkedList<>();
		List<Pair> union = new ArrayList<>();
		int sum = 0;
		queue.offer(start);
		union.add(start);
		sum+=map[start.r][start.c];
		visited[start.r][start.c] = true;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + p.r;
				int nc = dir[i][1] + p.c;
				if(!isIn(nr,nc)) continue;
				int dist = Math.abs(map[p.r][p.c] - map[nr][nc]);
				if(!visited[nr][nc] && dist >=L && dist <=R) {
					queue.offer(new Pair(nr,nc));
					union.add(new Pair(nr,nc));
					sum+=map[nr][nc];
					visited[nr][nc] = true;
				}
			}
		}
		sum/=union.size();
		for (int i = 0; i < union.size(); i++) {
			Pair tmp = union.get(i);
			mapClone[tmp.r][tmp.c] = sum;
		}
		
	}

	public static class Pair{
		int r, c;

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
		return r>=0 && c>=0 && r<N && c<N;
	}
	
}
