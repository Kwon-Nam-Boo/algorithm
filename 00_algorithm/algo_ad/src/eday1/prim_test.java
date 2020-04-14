package eday1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class prim_test {
	
	private static List<Pair>[] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[V];
		
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			Pair p1 = new Pair(b, w);
			Pair p2 = new Pair(a, w);
			
			graph[a].add(p1);
			graph[b].add(p2);
			
		}
		boolean[] visited = new boolean[V];
		int[] key = new int[V];
		int[] p = new int[V];
		
		Arrays.fill(key, Integer.MAX_VALUE);

		key[0] = 0;
		p[0] = -1;
		
		for (int i = 0; i < V-1; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > key[j]) {
					System.out.println("a");
					index = j;
					min = key[j];
				}
			}
			visited[index] = true;
			
			for (Pair n : graph[index]) {
				int next =n.v;
				int nextW = n.weight;
				if(!visited[next] && key[next] > nextW) {
					key[next] = nextW;
					p[next] = index;
				}
			}
			//System.out.println(Arrays.toString(key));
			
		}
		
		int result = 0;
		for (int i = 0; i < V; i++) {
			result+= key[i];
		}
		
		System.out.println(result);
		System.out.println(Arrays.toString(p));
	}
	
	public static class Pair {
		int v, weight;

		public Pair(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}
		
	}
		
		
}
