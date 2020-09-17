package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,M,ans;
	private static int[][] map;
	private static List<Pair> virus;
	private static boolean[][] visited;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		virus = new ArrayList<>();	// 테스트할 바이러스
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) virus.add(new Pair(r,c));	// 테스트할 바이러스 모아두기
				
			}
		}
		ans=0;
		nCr(0,0);
		System.out.println(ans);
		
	}
	
	// (모든 0) c 3 의 nCr 연산으로 모든 map 벽의 경우를 시도한다
	private static void nCr(int d, int r) {
		
		if(d == 3) {
			ans = Math.max(ans, bfs());	// bfs로 확인한 안전영역과 비교
			return;
		}
		for (int i = r; i < N*M; i++) {
			int x = i / M;				// 현재 index의 x,y값 구하기
			int y = i % M;
			// 빈칸이라면 
			if(map[x][y] == 0) {
				map[x][y] = 1;
				nCr(d+1,i+1);
				map[x][y] = 0;
			}
		}
		
	}
	// 안전영역의 수 확인
	private static int bfs() {
		Queue<Pair> queue = new LinkedList<>();
		visited = new boolean[N][M];
		
		for (int i = 0; i < virus.size(); i++) {	// 초기 바이러스 값 큐에 다넣기
			Pair tmp = virus.get(i);
			queue.offer(tmp);
			visited[tmp.x][tmp.y] = true;;
		}
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int px = dir[i][0] + p.x;
				int py = dir[i][1] + p.y;
				
				if(isIn(px,py) && !visited[px][py] && map[px][py] == 0) {
					queue.offer(new Pair(px,py));	// map의 재활용을 위해 0을 2로 바꾸지않는다(visited로 구분이 가능하다)
					visited[px][py] = true;
				}
			}
		}
		// 개수 확인
		return check();
		
		
	}
	
	private static int check() {
		int cnt=0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				// 0 이면서 방문한적 없다 -> 안전영역
				if(map[r][c] == 0 && !visited[r][c]) ++cnt;
			}
		}
		return cnt;
		
	}

	public static class Pair{
		int x,y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
}
