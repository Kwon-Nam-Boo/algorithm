package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용_구하기 {

	private static StringBuilder sb = new StringBuilder();
	private static List<Edge>[] al; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		al = new ArrayList[N+1];
		for (int i = 1; i < al.length; i++) {
			al[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			al[start].add(new Edge(end, w));
		}

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Edge[] d = new Edge[N+1];
		
		for (int i = 1; i < d.length; i++) {
			if(i == A) d[i] = new Edge(i, 0);
			else d[i] = new Edge(i, Integer.MAX_VALUE);
		}
//		for (int i = 1; i < al.length; i++) {
//		System.out.println(al[i]);
//		}
//		System.out.println(Arrays.toString(d));
		pq.add(d[A]);
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(d[edge.v].weight != edge.weight) continue;
			
			for (Edge next : al[edge.v]) {
				if(next.weight + d[edge.v].weight < d[next.v].weight) {
					d[next.v].weight = next.weight + d[edge.v].weight;
					
					pq.remove(d[next.v]);
					pq.add(d[next.v]);
				}
					
			}
			
		}
		System.out.println(d[B].weight);
	}
	
	public static class Edge implements Comparable<Edge>{
		int v , weight;

		public Edge(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			Integer w1 = this.weight;
			Integer w2 = o.weight;
			return w1.compareTo(w2);
		}

		@Override
		public String toString() {
			return "Edge [v=" + v + ", weight=" + weight + "]";
		}
		
		
	}
}
