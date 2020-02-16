package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	
	private static int R;
	private static int C;
	private static int[][] map;									// 토마토 맵
	private static boolean[][] visited;							// 방문기록
	private static int[][] dir= {{-1,0},{1,0},{0,-1},{0,1}};	// 4방향
	private static Queue<Pair> queue = new LinkedList<>();		// 하루 마다 bfs를 돌리기 위해 큐를 뺴줌
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		
		
		for (int r = 0; r < R; r++) {								// 맵 저장 및 초기값 설정
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==1){
					visited[r][c]=true;								// 익은 토마토
					queue.offer(new Pair(r,c));						// 첫날 토마토를 큐에 넣어둔다
				}
			}
		}
		
		int day = 0;												// 시간
		while(true) {												// 다익을 때까지 반복한다.
			if(check()) {											// 0 즉 안익은 게 없으면, 끝
				break;
			}
			if(queue.size() == 0) {									// 더이상 queue에 익게 만들 토마토가 없다면
				day = -1;											// 모든 토마토를 익게 만들지 못했다. (익었으면 위에서 끝)
				break;											
			}
			bfs();													// 하루치 bfs를 돌린다.
			day++;
		}
		System.out.println(day);
		
	}
	public static void bfs() {
		int qs = queue.size();
		
		for (int i = 0; i < qs; i++) {
			Pair p = queue.poll();
			for (int j = 0; j < dir.length; j++) {
				int a = p.x + dir[j][0];
				int b = p.y + dir[j][1];
				if(isIn(a,b) && !visited[a][b] && map[a][b] == 0) {
					map[a][b] =1;
					visited[a][b] =true;
					queue.offer(new Pair(a,b));
				}
			}
		}
	}
	
	
	
	public static class Pair{
		int x;
		int y;
		
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < R && c < C; 
	}
	
	public static boolean check(){									// 안익은 토마토가 없으면 true
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 0) return false;
			}
		}
		return true;
	}

}
