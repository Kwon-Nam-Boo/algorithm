package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1197_최소_스패닝_트리_Prim {
	
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
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			Pair p1 = new Pair(a, c);
			Pair p2 = new Pair(b, c);
			
			graph[a].add(p2);
			graph[b].add(p1);
			
		}
		
		boolean[] check = new boolean[V];
		int[] key = new int[V];
		int[] p = new int[V];
		
		Arrays.fill(key, Integer.MAX_VALUE);
		
		p[0] = -1;
		key[0] = 0;
		
		for (int i = 0; i < V-1; i++) {
			int min = Integer.MAX_VALUE;
			
			int index = -1;
			
			for (int j = 0; j < V; j++) {
				// 가장 작은 키의 정점 index 찾기
				if(!check[j] && key[j] < min) {
					index = j;
					min = key[j];
				}
			}
			// 현재 위치 방문 체크
			check[index] = true;
			
			for (int j = 0; j < graph[index].size(); j++) {
				int ca = graph[index].get(j).a;
				int cw = graph[index].get(j).w;
				
				if(!check[ca] && cw< key[ca]) {
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
