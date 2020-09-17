package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,M,hc,cc;		// N: 도시정보  M:남아야하는 치킨집 개수  hc,cc: 집,치킨 개수
	private static int ans;
	private static int[][] map;		// map: 도시
	private static Pair[] house;		// house: 집
	private static Pair[] chicken;	// chicken: 치킨
	private static Pair[] result;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		house = new Pair[2*N];
		chicken = new Pair[13];
		result = new Pair[M];
		ans = Integer.MAX_VALUE;
		
		hc = 0;		// house cnt
		cc = 0;		// chicken cnt
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) {
					house[hc] = new Pair(r,c);
					hc++;
				}
				if(map[r][c] == 2) {
					chicken[cc] = new Pair(r,c);
					cc++;
				}
			}
		}
		nCr(0,0);
		System.out.println(ans);
	}
	private static void nCr(int r, int d) {
		if(r == M) {
			ans = Math.min(ans,checkStreet());
			return;
		}
		for (int i = d; i < cc; i++) {
			result[r] = chicken[i];
			nCr(r+1, i+1);
		}
		
	}
	
	private static int checkStreet() {
		int re =0;
		for (int i = 0; i < hc; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < result.length; j++) {
				min = Math.min(Math.abs(house[i].x - result[j].x) + Math.abs(house[i].y - result[j].y), min);
			}
			re+=min;
		}
		return re;
	}
	
	public static class Pair{
		
		int x,y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
			
	}
}
