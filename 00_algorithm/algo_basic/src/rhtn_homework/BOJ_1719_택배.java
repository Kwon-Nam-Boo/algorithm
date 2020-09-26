package rhtn_homework;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1719_택배 {

	private static StringBuilder sb = new StringBuilder();
	private static int INF = Integer.MAX_VALUE;
	
	private static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Edge>[] list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[s].add(new Edge(e, v));
			list[e].add(new Edge(s, v));
		}
		
		// 다익스트라를 각 시작위치로부터 N번 돌려야 겟죠?
		for (int s = 1; s <= N; s++) {
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			Edge[] D = new Edge[N+1];
			// 시작위치는 0, 나머지는 가중치 최고로
			for (int i = 1; i <= N; i++) {
				if(i == s) {
					D[i] = new Edge(i, 0);
				}else {
					D[i] = new Edge(i, INF);
				}
			}
			pq.add(D[s]);
			
			// 부모(직전)의 위치를 저장한다
			parents = new int[N+1];
			// makeSet
			for (int i = 0; i <= N; i++) {
				makeSet(i);
			}
			
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				// 방문 처리
				if(D[edge.v].weight != edge.weight) continue;
				// 흔한 다익스트라
				for (Edge next : list[edge.v]) {
					if(D[next.v].weight > D[edge.v].weight + next.weight) {
						// 경로 처리, 현재위치의 부모를 저장한다(s가 부모인곳은 그냥 자신이 일단 자기 자신이 부모일 것이다) 
						if(edge.v!=s) {
							parents[next.v] = edge.v;
						}
						D[next.v].weight = D[edge.v].weight + next.weight;
						pq.remove(D[next.v]);
						pq.add(D[next.v]);
					}
				}
			}
			// 부모의 부모의 부모를 찾는다(root, 정확히는 root 직전값)
			for (int i = 1; i <= N; i++) {
				if(i==s) {
					 sb.append("- ");
					 continue;
				}
				findSet(i);
				sb.append(parents[i] +" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

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
	
	// 세팅
	static void makeSet(int x) {
		parents[x] =x;
	}
	
	static int findSet(int x) {
		if(x == parents[x])	// 자기 자신이 부모라면 --> 본인이 팀의 식별자!
			return x;
		else {		// 그게 아니면  다시 탐색한다
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
}
