package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {

	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};	// 상하좌우
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static Fish shark;
	private static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				// 상어라면 저장!
				if(map[r][c] == 9) {
					shark = new Fish(r,c,2,0);
				}
			}
		}
		
		// 상어의 이동길이
		result = 0;
		
		// bfs가 멈출때 까지 진행한다.
		while(bfs()) {
			// 방문초기화
			visited = new boolean[N][N];
		}
		
		System.out.println(result);
		
	}
	// shark(기준점)에서 shark보다 작은 물고기중 가장 가까운 곳으로 간다 true / 못가면 false 
	private static boolean bfs() {
		
		Queue<Fish> queue = new LinkedList<>();
		queue.offer(shark);
		// 방문 처리후 현재 위치를 빈칸으로
		visited[shark.x][shark.y] = true;
		map[shark.x][shark.y] = 0;
		
		// 움직인 칸수
		int cnt=1;
		while(!queue.isEmpty()) {
			// 현재 큐의 사이즈 만큰만 돌린다. --> 넓이 탐색을 한 타임 마다 체크한다(바이러스 처럼)
			int size = queue.size();
			// 해당 타임에서 가장 가까운 물고기를 앞으로 보내기 위한 pq 제작
			PriorityQueue<Fish> pq = new PriorityQueue<>();
			// 사이즈 만큼만 돌린다.
			for (int k = 0; k < size; k++) {
				Fish f = queue.poll();
				
				for (int i = 0; i < dir.length; i++) {
					int nx = dir[i][0] + f.x;
					int ny = dir[i][1] + f.y;
					
					// 범위 안에 있고 빈칸이거나 같은 크기의 물고기라면 그위치로 이동가능하다 -- > queue에 넣는다.
					if(isIn(nx,ny) && !visited[nx][ny] && (map[nx][ny] == 0 || map[nx][ny] == shark.w)) {
						queue.offer(new Fish(nx,ny,shark.w,shark.c));
						visited[nx][ny] = true;
					} // 범위 안에 있고 상어보다 작은 물고기라면 먹을수 있다 --> pq 에 넣는다.
					else if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny] != 0 && map[nx][ny] < shark.w) {
						int w = shark.w;
						int c = shark.c+1;
						// 만약 w 횟수만큼 먹었다면 w증가 c 초기화
						if(shark.w == c) {
							w++;
							c=0;
						}
						pq.offer(new Fish(nx,ny,w,c));
						visited[nx][ny] = true;
					}
				}
			}
			// 한 타임에서 pq가 나왓다면 맨앞의 값이 내가 원하는 물고기!! --> 해당값으로 상어 이동후 거리를 저장
			if(!pq.isEmpty()) {
				Fish f = pq.poll();
				shark.x = f.x;
				shark.y = f.y;
				shark.w = f.w;
				shark.c = f.c;
				result+=cnt;
				return true;
			}
			cnt++;
		}
	
		return false;
		
	}

	public static class Fish implements Comparable<Fish>{
		int x,y;
		// 크기와 카운트
		int w,c;
		public Fish(int x, int y, int w, int c) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
			this.c = c;
		}
		@Override
		public int compareTo(Fish o) {
			Integer x1 = this.x;
			Integer x2 = o.x;
			Integer y1 = this.y;
			Integer y2 = o.y;
			
			// 같은 길이라면 가장 위에 값, 그마저 같다면 왼쪽값의 물고기로 이동
			if(x1 == x2) {
				return y1.compareTo(y2);
			}
			return x1.compareTo(x2);
		}
		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", w=" + w + ", c=" + c + "]";
		}
		
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c >=0 && r< N && c< N;
	}
}
