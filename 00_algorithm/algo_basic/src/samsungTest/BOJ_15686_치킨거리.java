package samsungTest;

import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_15686_치킨거리 {

	private static int N,M ,ans;
	private static int[][] map;
	private static List<Pair> chicken;
	private static List<Pair> house;
	private static int[] result;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) house.add(new Pair(r,c));
				else if(map[r][c] == 2) chicken.add(new Pair(r,c));
			}
		}
		result = new int[M];
		nCr(0,0);
		System.out.println(ans);
	}
	
	private static void nCr(int d, int k) {
		if(d == M) {
			findChickenDist();
			return;
		}
		for (int i = k; i < chicken.size(); i++) {
			result[d] = i;
			nCr(d+1,i+1);
		}
		
	}

	private static void findChickenDist() {
		
		int chickDist = 0;
		
		for (int i = 0; i < house.size(); i++) {
			Pair ho = house.get(i);
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				Pair ch = chicken.get(result[j]);
				int dist = Math.abs(ho.r - ch.r) + Math.abs(ho.c - ch.c);
				if(min > dist){
					min = dist;
				}
			}
			chickDist+=min;
		}
		ans = Math.min(ans, chickDist);
		return;
	}

	public static class Pair{
		int r,c;

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

}
