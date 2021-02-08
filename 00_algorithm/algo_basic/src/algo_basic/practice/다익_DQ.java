package algo_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익_DQ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		// 점의 개수, 선의 개수
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		//
		List<Edge>[] adj = new ArrayList[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
	
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[a].add(new Edge(b, w));
			//양방향
			//adj[b].add(new Edge(a, w));
		}
//		for (int i = 0; i < adj.length; i++) {
//			System.out.println(adj[i]);
//		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Edge[] D = new Edge[V];
		for (int i = 0; i < D.length; i++) {
			//임의로 시작점을 0으로 지정했을 뿐이다
			if(i == 0) {
				D[i] = new Edge(i, 0);
			}else {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}
		}
		pq.add(D[0]);
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if(e.weight != D[e.v].weight) continue;
			
			for (Edge next : adj[e.v]) {
				if(D[next.v].weight > next.weight + D[e.v].weight) {
					D[next.v].weight = next.weight + D[e.v].weight;
					pq.remove(D[next.v]);
					pq.offer(D[next.v]);
				}
			}
		}
		System.out.println(Arrays.toString(D));
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
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static String src = "	7 11\r\n" + 
			"	0 1 9\r\n" + 
			"	0 2 5\r\n" + 
			"	0 5 19\r\n" + 
			"	2 3 1\r\n" + 
			"	2 5 15\r\n" + 
			"	3 0 2\r\n" + 
			"	3 1 7\r\n" + 
			"	3 5 17\r\n" + 
			"	3 4 8\r\n" + 
			"	4 6 4\r\n" + 
			"	6 1 3";
}
