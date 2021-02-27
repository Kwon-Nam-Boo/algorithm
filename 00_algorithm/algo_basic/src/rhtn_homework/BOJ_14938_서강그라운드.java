package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14938_서강그라운드 {

	private static int N,M,R ,ans;
	private static int[] item;
	private static boolean[] visited;
	private static Edge[] D;
	private static List<Edge>[] adlist;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		item = new int[N];
		for (int i = 0; i < N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		adlist = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			adlist[i] = new ArrayList<>();
		}
	
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int len = Integer.parseInt(st.nextToken());
			adlist[a].add(new Edge(b,len));
			adlist[b].add(new Edge(a,len));
		}
		ans = 0;
		for (int t = 0; t < N; t++) {
			D = new Edge[N];
			
			for (int i = 0; i < N; i++) {
				if(i == t) D[i] = new Edge(i, 0);
				else D[i] = new Edge(i,Integer.MAX_VALUE);
			}
			PriorityQueue<Edge> queue = new PriorityQueue<>();
			queue.offer(D[t]);
			int cnt = 0;
			
			visited = new boolean[N];
			
			while(!queue.isEmpty()) {
				Edge e = queue.poll();
				visited[e.x] = true;
				
				for (Edge next: adlist[e.x]) {
					// 방문하지 않았으면서,현재 길이하고 다음에서 갈수 있는 길이 합이 M을 안넘으면 해보자
					if(!visited[next.x] && e.len + next.len <= M) {
						D[next.x].len = e.len + next.len;
						queue.remove(D[next.x]);
						queue.offer(D[next.x]);
						// 주의파트(여기서 cnt를 구해주면 안됨)
					}
				}
				
			}
			// 주의: 나중에 한번에 모아서 item을 더해주자(해당 점에 도착하는 가중치가 낮아질수도 있기에 결과가 달라질수있다)
			for (int i = 0; i < N; i++) {
				if(visited[i]) cnt+=item[i];
			}
			ans = Math.max(ans, cnt);
			
		}
		System.out.println(ans);
		
		
	}
	
	public static class Edge implements Comparable<Edge>{
		int x,len;

		public Edge(int x, int len) {
			super();
			this.x = x;
			this.len = len;

		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.len, o.len);
		}
		
	}
}
