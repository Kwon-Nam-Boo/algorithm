package eday1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_PQ {
	static class Edge implements Comparable<Edge>{
		int v, weight;
		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
		@Override
		public String toString() {
			return "Edge [" + weight + "]";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		List<Edge>[] adj = new ArrayList[V];
		
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
		}
		
		//Dijkstra
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V];
		Edge[] D = new Edge[V];
		//0번에서 출발하는 걸로
		for (int i = 0; i < V; i++) {
			//원하는 출발지
			if( i == 0 ) {
				D[i] = new Edge(i,0);
			}else {
				D[i] = new Edge(i,Integer.MAX_VALUE);
			}
		}
		pq.add(D[0]);
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			//check[edge.v] = true;
			if(D[edge.v].weight != edge.weight) continue;
			
			for (Edge next : adj[edge.v]) {
				// check되지 않았으면서, D[next]가 D[edge.v] + next.weight보다 크다면 갱신
				if(!check[next.v] && D[next.v].weight > D[edge.v].weight + next.weight) {
					D[next.v].weight = D[edge.v].weight + next.weight;
					//decrease key
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
			
		}
		System.out.println(Arrays.toString(D));
	}
	//input
//	7 11
//	0 1 9
//	0 2 5
//	0 5 19
//	2 3 1
//	2 5 15
//	3 0 2
//	3 1 7
//	3 5 17
//	3 4 8
//	4 6 4
//	6 1 3
}
