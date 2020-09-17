package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한_최단_경로 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,E;
	private static int a,b,c,v1,v2;
	private static List<Edge>[] adj;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			adj[a].add(new Edge(b,c));
			adj[b].add(new Edge(a,c));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int  forword = 0, reverse = 0;
		
		
		forword = Route(v1,v2);
		reverse = Route(v2,v1);
		System.out.println(Math.min(forword, reverse));
	
		
	}
	
	public static int Route(int v1,int v2){
		int ra = 0, rb = 0, rc =0;
		ra = dijkstra(1,v1); 
		rb = dijkstra(v1,v2);
		rc = dijkstra(v2,N);
		//System.out.println(ra + ":" + rb + ":" + rc);
		if(ra <0 || rb <0|| rc<0) return -1;
		else return ra+rb+rc;
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		Edge[] D = new Edge[N+1];
		boolean[] check = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			//원하는 출발지
			if(i == start) {
				D[i] = new Edge(i,0);
			}else {
				D[i] = new Edge(i,Integer.MAX_VALUE);
			}
		}
		pq.add(D[start]);
		
		while(!pq.isEmpty()) {
			
			Edge e = pq.poll();
			check[e.v] = true;
			
			for (Edge next : adj[e.v]) {
				if(!check[next.v] && D[next.v].weight > D[e.v].weight + next.weight) {
					D[next.v].weight = D[e.v].weight + next.weight;
					//decrease key
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
		}
		if(D[end].weight == Integer.MAX_VALUE)
			return -1;
		else
			return D[end].weight;
	}



	public static class Edge implements Comparable<Edge>{
		int v, weight;

		public Edge(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [v=" + v + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			Integer w1 = this.weight;
			Integer w2 = o.weight;
			
			return w1.compareTo(w2);
		}
		
	}
}
