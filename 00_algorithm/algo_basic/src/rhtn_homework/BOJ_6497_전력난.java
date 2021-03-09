package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6497_전력난 {

	private static int M,N;
	private static List<Edge>[] adlist;
	private static boolean[] visited;
	private static StringBuilder sb= new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(M == 0 && N ==0) break;
			
			adlist = new ArrayList[M];
			for (int i = 0; i < M; i++) {
				adlist[i] = new ArrayList<>();
			}
			int light = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				adlist[x].add(new Edge(y,z));
				adlist[y].add(new Edge(x,z));
				light+=z;
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			visited = new boolean[M];
			
			pq.add(new Edge(0,0));
			
			int ans = 0;
			int cnt = 0;
			// 프림
			while(!pq.isEmpty()) {
				Edge edge =pq.poll();
				// 방문 확인
				if(visited[edge.x]) continue;
				// 방문 처리
				ans+=edge.v;
				visited[edge.x] = true;
				
				for (Edge next : adlist[edge.x]) {
					if(!visited[next.x]) {
						pq.add(next);
					}
				}
				cnt++;
				if(cnt == M) break;
			}
			
			sb.append((light-ans)+"\n");
		}
		System.out.println(sb);
	}

	private static class Edge implements Comparable<Edge>{
		int x,v;

		public Edge(int x, int v) {
			super();
			this.x = x;
			this.v = v;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.v, o.v);
		}
		
	}
}
