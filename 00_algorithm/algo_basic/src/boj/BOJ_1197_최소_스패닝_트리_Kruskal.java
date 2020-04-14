package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197_최소_스패닝_트리_Kruskal {
	
	// 해당 위치의 루트값
	private static int[] parents;
	// 트리 높이
	private static int[] rank;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Pair[] p = new Pair[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			p[i] = new Pair(a, b, w);
		}
		Arrays.sort(p);
		
		parents= new int[V+1];
		rank = new int[V+1];
		
		// Kruskal
		for (int i = 1; i <= V; i++) {
			makeSet(i);
		}
		int cnt = 0;
		int result = 0;
		for (int i = 0; i < E; i++) {
			int a = findSet(p[i].a);
			int b = findSet(p[i].b);
			
			if(a == b)
				continue;
			union(a,b);
			result += p[i].w;
			cnt++;
			if(cnt == V-1) break;
		}
		System.out.println(result);
	}
	
	
	// union-find: makeSet, findeSet, Union
	
	// 초기화
	public static void makeSet(int x){
		parents[x] = x;
	}
	
	// 루트 찾기
	public static int findSet(int x) {
		if(x == parents[x]) {
			return x;
		}else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(rank[px] < rank[py]) {
			parents[px] = py;
		}else {
			parents[py] = px;
			if(rank[px] == rank[py]) {
				rank[px]++;
			}
		}
	}
	
	public static class Pair implements Comparable<Pair>{
		int a;
		int b;
		int w;
		
		public Pair(int a, int b, int w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.w, o.w);
		}
		
		
	}

}
