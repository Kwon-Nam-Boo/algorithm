package eday1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kruskal_test {
	
	private static int[] parents;
	private static int[] rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		parents = new int[V];
		rank = new int[V];
		
		Pair[] p = new Pair[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			p[i] = new Pair(a, b, w);
		}
		Arrays.sort(p);
		
		int cnt= 0;
		int result = 0;
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}
		for (int i = 0; i < E; i++) {
			int pa = findSet(p[i].a);
			int pb = findSet(p[i].b);
			
			if(pa == pb) continue;
			union(pa,pb);
			result+= p[i].w;
			cnt++;
			if(cnt == V-1) break;
		}
		System.out.println(result);
	}
	
	public static class Pair implements Comparable<Pair>{
		int a, b, w;

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
	
	//union find
	public static void makeSet(int x) {
		parents[x] = x;
	}
	public static int findSet(int x) {
		if(x == parents[x]) {
			return x;
		}else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	public static void union(int x, int y) {
		int sx = findSet(x);
		int sy = findSet(y);
		
		if(rank[sx] > rank[sy]) {
			parents[sy] = sx; 
		}else {
			parents[sx] = sy;
			if(rank[sx] == rank[sy]) {
				rank[sy]++;
			}
		}
	}
}
