package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142_연구소3 {
	
	private static StringBuilder sb = new StringBuilder();
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int N, M;
	private static int[][] map;
	private static int[][] mapClone;
	private static List<Pair> list;
	private static int[] virus;
	private static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		// N 칸수 ,M 활성 바이러스 수
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 맵과 연습장용 clone맵
		map = new int[N][N];
		mapClone = new int[N][N];
		// 활성될 바이러스, 전체바이러스 , 답
		virus = new int[M];
		list = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				mapClone[r][c] = map[r][c];
				if(map[r][c] == 2) list.add(new Pair(r,c));
			}
		}
		// 우선 시작부터 바이러스가 없다면 답은 0, 아니면 nCr실행
		if(!check()) nCr(0,0);
		else ans=0;
		// 만약 한번도 빈칸0 을 없앤적이 없다면 -1로 출력
		System.out.println(ans == Integer.MAX_VALUE ? -1:ans);

	}
	private static void bfs() {
		Queue<Pair> queue = new LinkedList<>();
		// 3은 활성화 바이러스라고 임의로 정의한다
		for (int i = 0; i < virus.length; i++) {
			Pair p = list.get(virus[i]);
			queue.offer(p);
			mapClone[p.x][p.y] = 3;
		}
		
		int cnt =0;
		while(!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				Pair p = queue.poll();
				
				for (int j = 0; j < dir.length; j++) {
					int px = dir[j][0] + p.x;
					int py = dir[j][1] + p.y;
					// 비활성 바이러스거나 빈칸일 경우 퍼질수 있다
					if(isIn(px,py) && (mapClone[px][py] == 2 || mapClone[px][py] == 0)) {
						mapClone[px][py] = 3;
						queue.offer(new Pair(px,py));
					}
				}
			}
			cnt++;
		// 만약 빈칸이 없다면 끝낸다
		if(check()) break;
		}
		// 최소값은 답이된다
		if(check()) ans = Math.min(ans, cnt);
		// 연습용 map 초기화
		init();
	}

	// 초기화
	private static void init() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				mapClone[r][c] = map[r][c];
			}
		}
	}
	// 빈칸 체크
	private static boolean check() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(mapClone[r][c] ==0) return false;
			}
		}
		return true;
		
	}
	
	public static void nCr(int r, int k) {
		if(r == M) {
			bfs();
			return;
		}
		
		for (int i = k; i < list.size(); i++) {
			virus[r] = i;
			nCr(r+1,i+1);
		}
	}
	
	public static class Pair{
		int x,y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
