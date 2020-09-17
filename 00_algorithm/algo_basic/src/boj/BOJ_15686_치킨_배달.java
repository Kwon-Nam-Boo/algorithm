package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨_배달 {
	private static int N;
	private static int M;
	private static int ans;
	private static int[][] map;
	private static Pair[] result;
	private static List<Pair> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		list = new ArrayList<>();
		result = new Pair[M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c]= Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) list.add(new Pair(r,c));
			}
		}
		ans = Integer.MAX_VALUE;
		nCr(0,0);
		System.out.println(ans);
		
	}
	
	public static void nCr(int r, int k) {
		if(r == M) {
			ans = Math.min(ans, check());
			return;
		}
		for (int i = k; i < list.size(); i++) {
			result[r] = list.get(i);
			nCr(r+1,i+1);
		}
	}
	
	
	private static int check() {
		int re=0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == 1) {
					int min = Integer.MAX_VALUE;
					for (int i = 0; i < result.length; i++) {
						min = Math.min(min, Math.abs(result[i].x - r) + Math.abs(result[i].y - c)); 
					}
					re+=min;
				}
			}
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
