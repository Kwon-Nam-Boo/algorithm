package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_2636_치즈 {

	StringBuilder sb = new StringBuilder();
	private static int R,C, cheezeCnt;
	private static int[][] map;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static Queue<Pair> cheeze = new LinkedList<>();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 정답
		int cnt =0;
		while(true) {
			if(!Reset()) break;	// 진공으로 초기화 --> 공기를 한번에 찾기 위해서
			findAir(); 					// 공기 찾기 --> 공기는 2. 진공은 0. 치즈 1 치즈가 없다면 break
			melt();						// 치즈 녹이기
			cnt++;
		}
		
		System.out.println(cnt);
		System.out.println(cheezeCnt);
	}

	private static boolean Reset() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 2) map[r][c] = 0;
				else if(map[r][c] == 1) cheeze.offer(new Pair(r,c));
			}
		}
		if(cheeze.isEmpty()) {			// 큐가 비었다면 더이상 할 필요없다
			return false;
		}else {
			cheezeCnt = cheeze.size();	// 현재 큐의사이즈가 현재의 치즈 양이다
			return true;
		}
	}

	private static void findAir() {
	
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(0,0));
		map[0][0] = 2;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + p.x;
				int nc = dir[i][1] + p.y;
				if(isIn(nr,nc) && map[nr][nc] == 0) {
					map[nr][nc] = 2;
					queue.offer(new Pair(nr,nc));
				}
			}
		}
	}
	
	private static void melt() {
		
		while(!cheeze.isEmpty()) {
			Pair p = cheeze.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + p.x;
				int nc = dir[i][1] + p.y;
				if(map[nr][nc] == 2) {
					map[p.x][p.y] = 0;
					break;
				}
			}
		}
		
	}
	
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r< R && c< C; 
	}
	
	public static class Pair{
		int x,y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
