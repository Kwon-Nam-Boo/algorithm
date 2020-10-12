package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {

	private static StringBuilder sb = new StringBuilder();
	private static int[][] dir = {{-1,0},{0,-1},{0,1},{1,0},};
	private static int N, ans;
	private static int[][] map;
	private static boolean[][] visited;
	private static Pair shark;
	private static int ex;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N의 크기
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
	
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				// 상어 위치 저장
				if(map[r][c] == 9) shark = new Pair(r,c,2);
			}
		}
		// 상어의 크기가 커지기 위해 남은 물고기
		ex = 2;
		ans = 0;
		while(true) {
			if(!bfs()) break;
		}
		System.out.println(ans);
		
	}
	

	public static boolean bfs() {
		Queue<Pair> queue = new LinkedList<>();
		visited = new boolean[N][N];
		queue.offer(shark);
		
		visited[shark.x][shark.y] = true;
		int cnt =0;
		List<Pair> fish = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int len = queue.size();
			cnt++;
			for (int l = 0; l < len; l++) {
				Pair p = queue.poll();
				for (int i = 0; i < dir.length; i++) {
					int px = dir[i][0] + p.x;
					int py = dir[i][1] + p.y;
					if(isIn(px, py) && shark.s >= map[px][py] && !visited[px][py]) {
						// 먹는 조건
						if(map[px][py]!=0 && shark.s > map[px][py]) {
							fish.add(new Pair(px,py,0));
						}
						// 지나간다면
						visited[px][py] = true;
						queue.offer(new Pair(px,py,0));
						
					}
				}
			}
			// 먹을 수 있는 생선 있다면, 가장 가까운(거리가 같으면 상,좌 순으로)
			if(!fish.isEmpty()){
				Collections.sort(fish);
				Pair p = fish.get(0);
				// 상어 위치를 옮겨주고 , 크기 변화, 거리를 측정한다
				map[shark.x][shark.y] = 0;
				map[p.x][p.y] = 9;
				shark.x =p.x;
				shark.y =p.y;
				ex--;
				if(ex ==0) {
					shark.s++;
					ex = shark.s;
				}
				ans+=cnt;
				return true;
			}
			
		}
		return false;
	}
	
	public static class Pair implements Comparable<Pair>{
		int x,y,s;

		public Pair(int x, int y, int s) {
			super();
			this.x = x;
			this.y = y;
			this.s = s;
		}
		
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + ", s=" + s + "]";
		}

		@Override
		public int compareTo(Pair o) {
			Integer x1 = this.x;
			Integer y1 = this.y;
			Integer x2 = o.x;
			Integer y2 = o.y;
			if(x1!=x2) {
				return x1.compareTo(x2);
			}
			else return y1.compareTo(y2);
			
		}
		
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
