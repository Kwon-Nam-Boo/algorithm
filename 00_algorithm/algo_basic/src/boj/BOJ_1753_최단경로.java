package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	
	public static List<Edge>[] graph; 
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine())-1;
		
		graph = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			Edge e = new Edge(v, w);
			graph[u].add(e);
			
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V];
		// 현재 위치까지의 가중치 넣는 배열
		Edge[] edge = new Edge[V];
		
		for (int i = 0; i < V; i++) {
			if(i == start) {
				edge[i] = new Edge(i, 0);
			}else {
				edge[i] = new Edge(i, Integer.MAX_VALUE);
			}
		}
		pq.add(edge[start]);
		
				
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if(e.weight == Integer.MAX_VALUE) {
				break;
			}
			
			for (Edge next : graph[e.v]) {
				if(!visited[next.v] && edge[next.v].weight > edge[e.v].weight + next.weight) {
					edge[next.v].weight = edge[e.v].weight + next.weight;
					//decrease key
					pq.remove(edge[next.v]);
					pq.add(edge[next.v]);
				}
			}
			visited[e.v] = true;
		}
		for (Edge re : edge) {
			System.out.println(re.weight == Integer.MAX_VALUE ? "INF": re.weight);
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int v,weight;

		public Edge(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
}
