package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class testing {
	
	private static List<Pair>[] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i <E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			Pair p1 = new Pair(b, w);
			Pair p2 = new Pair(a, w);
			
			graph[a].add(p1);
			graph[b].add(p2);
		}
		
		boolean[] visited= new boolean[V];
		int[] key = new int[V];
		int[] p = new int[V];
		
		Arrays.fill(key, Integer.MAX_VALUE);
		
		key[0] = 0;
		p[0] = -1;
		
		
		for (int i = 0; i < V-1; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			
			// 키가 최소인 인덱스와 키값 찾기
			for (int j = 0; j < V; j++) {
				if(!visited[j] && key[j] < min) {
					
					index = j;
					min = key[j];
				}
			}
			
			visited[index] = true;
			
			for (Pair p1: graph[index]) {
				int ca = p1.a;
				int cw = p1.w;
				
				if(!visited[ca] && cw <key[ca]) {
					p[ca] = index;
					key[ca] = cw;
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < V; i++) {
			result += key[i];
		}
		System.out.println(result);
		
	}
	
	public static class Pair{
		int a;
		int w;
		
		public Pair(int a, int w) {
			super();
			this.a = a;
			this.w = w;
		}
		
		@Override
		public String toString() {
			return "Pair [a=" + a + ", w=" + w + "]";
		}
	}
}
