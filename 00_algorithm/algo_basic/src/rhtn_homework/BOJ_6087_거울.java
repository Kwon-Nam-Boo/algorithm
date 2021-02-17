package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6087_거울 {
	
	private static int H, W;
	private static char[][] map;
	private static Pair c1,c2;
	private static boolean arrive;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		
		for (int r = 0; r < H; r++) {
			map[r] = br.readLine().toCharArray();
			for (int c = 0; c < W; c++) {
				if(map[r][c] == 'C' && !arrive) {
					c1 = new Pair(r,c, 0,0);
					arrive = true;
				}else if(map[r][c] == 'C' && arrive) {
					c2 = new Pair(r,c,0,0);
				}
			}
		}
		
		visited = new boolean[4][H][W];
		System.out.println(bfs());
	}
	
	private static int bfs() {
		// 우선순위 큐로 거울이 적은거부터 하다보면 최종적으로 가장 먼저 도착하는 
		// 경우는 최소 거울사용횟수를 가진다
		PriorityQueue<Pair> queue = new PriorityQueue<>();
		
		// 시작점에서의 4방향 거울을 넣어주고 시작(안그러면 같은뱡향이 +1 된상태로 출발)
		for (int i = 0; i < dir.length; i++) {
			int nr = dir[i][0] + c1.r;
			int nc = dir[i][1] + c1.c;
			if(isIn(nr,nc) && map[nr][nc] != '*'){
				queue.offer(new Pair(nr,nc,i,0));
			}
		}
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			if(p.r == c2.r && p.c == c2.c)
				return p.cnt;
			visited[p.d][p.r][p.c] = true;
			
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + p.r;
				int nc = dir[i][1] + p.c;
				if(isIn(nr,nc) && map[nr][nc] != '*' && !visited[i][nr][nc]){
					if(i == p.d) {
						queue.offer(new Pair(nr,nc,i,p.cnt));
					}else {
						queue.offer(new Pair(nr,nc,i,p.cnt+1));
					}
				}
			}
		}
		return 0;
	}
	
	public static boolean isIn(int r, int c) {
		return r >=0  && c>=0 && r < H && c<W;
	}

	public static class Pair implements Comparable<Pair>{
		int r, c , d, cnt;

		public Pair(int r, int c, int d, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + ", d=" + d + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.cnt, o.cnt);
		}
		
	}
}
