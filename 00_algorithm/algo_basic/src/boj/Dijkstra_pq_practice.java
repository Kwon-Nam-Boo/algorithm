package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_pq_practice {
	
	private static List<Pair>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V]; 
		Pair[] D = new Pair[V]; 
		
		for (int i = 0; i < V; i++) {
			if(i == 0) {
				D[i] = new Pair(i, 0);
			}else {
				D[i] = new Pair(i, Integer.MAX_VALUE);
			}
		}
		pq.add(D[0]);
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			int curr = p.v;
			
			for (Pair n : graph[curr]) {
				// 목표 위치
				int next = n.v;
				// 현재에서 목표 까지 의 weight
				int nextW = n.weight;
				if(!visited[next] && D[next].weight > D[curr].weight + nextW) {
					D[next].weight = D[curr].weight + nextW;
					//decrease key
					pq.remove(D[next]);
					pq.add(D[next]);
				}
				
			}
			visited[curr] = true;
		}
		System.out.println(Arrays.toString(D));
		
	}
	
	public static class Pair implements Comparable<Pair>{
		int v,weight;

		public Pair(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Pair [weight=" + weight + "]";
		}

		@Override
		public int compareTo(Pair o) {

			return Integer.compare(this.weight, o.weight);
		}
		
		
		
	}
}
