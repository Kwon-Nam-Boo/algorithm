package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class kakao_4 {

	private static StringBuilder sb = new StringBuilder();
	private static Edge[] D;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n=6,s=4,a=6,b=2;
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		
		System.out.println(solution(n, s, a, b, fares));
	}
	
	public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int E = fares.length;
        int min = Integer.MAX_VALUE;
        
        List<Edge>[] adj = new ArrayList[n+1];
       
		for (int i = 1; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			adj[fares[i][0]].add(new Edge(fares[i][1], fares[i][2]));
			adj[fares[i][1]].add(new Edge(fares[i][0], fares[i][2]));
		}
		//Dijkstra
		//Dijkstra(n, s, adj);
		
		Edge[] tmpD = new Edge[n+1];
		

		for (int i = 1; i < adj.length; i++) {
			// 중간은 패스하기
			Dijkstra(n, i, adj);
			int tmp=(D[a].weight + D[b].weight + D[s].weight);
			min = Math.min(tmp, min);
		}
        return min;
    }
	
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
	
	public static void Dijkstra(int n, int s, List<Edge>[] adj) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[n+1];
		D = new Edge[n+1];
		//0번에서 출발하는 걸로
		for (int i = 1; i <= n; i++) {
			//원하는 출발지
			if( i == s ) {
				D[i] = new Edge(i,0);
			}else {
				D[i] = new Edge(i,Integer.MAX_VALUE);
			}
		}
		pq.add(D[s]);
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			check[edge.v] = true;
			
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
		//System.out.println(Arrays.toString(D));
	}
}
