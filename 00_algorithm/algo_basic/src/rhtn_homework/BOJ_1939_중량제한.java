package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_1939_중량제한 {

	private static int N,M;
	private static List<Edge>[] AdList;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		AdList = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			AdList[i] = new ArrayList<>();
		}
		for  (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			AdList[a].add(new Edge(b, c));
			AdList[b].add(new Edge(a, c));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Edge[] D = new Edge[N+1];
		PriorityQueue<Edge> pq  = new PriorityQueue<>();
		boolean[] visit = new boolean[N+1];
		
		for (int i = 1; i < D.length; i++) {
			//임의로 시작점을 0으로 지정했을 뿐이다
			if(i == start) {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}else {
				D[i] = new Edge(i, 0);
			}
		}
		pq.add(D[start]);
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			// 방문 처리
			visit[e.x] = true;
			
			for (Edge next : AdList[e.x]) {
				// 방문 확인
				if(visit[next.x]) continue;
				// 우선 현재점까지 올수있는 최대 무게와 해당점에서 도착점까지의 최대 무게를 비교해서 작은걸 찾는다
				int tmp = Math.min(D[e.x].w , next.w);
				// 위에서 찾은 값을 현재까지의 최대무게와 비교해서 큰값을 넣는다
				D[next.x].w = Math.max(D[next.x].w, tmp);
				pq.remove(D[next.x]);
				pq.offer(D[next.x]);
				
			}
		}
		System.out.println(D[end].w);
	}
	
	
	public static class Edge implements Comparable<Edge>{
		int x, w;

		public Edge(int x, int w) {
			super();
			this.x = x;
			this.w = w;
		}
		// 오름차순
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(o.w,this.w);
		}

		@Override
		public String toString() {
			return "Edge [x=" + x + ", w=" + w + "]";
		}
		
	}

}
