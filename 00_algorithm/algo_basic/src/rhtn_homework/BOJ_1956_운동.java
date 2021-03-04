package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1956_운동 {
	
	private static int V,E,ans;
	private static List<Edge>[] adlist;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adlist = new ArrayList[V];
		for (int i = 0; i < V ; i++) {
			adlist[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken());
			adlist[a].add(new Edge(b, v));
		}

		// 각 점에서의 최소 사이클 찾기
		findCycle();
		System.out.println(ans== Integer.MAX_VALUE ? -1:ans);
	}
	
	// 다익스트라를 이용
	private static void findCycle() {
		
		PriorityQueue<Edge> queue;
		Edge[] D = new Edge[V];
		
		// 정답은 일단 최대값
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < V; i++) {
			
			for (int j = 0; j < D.length; j++) {
				
				if(j == i) {
					D[j] = new Edge(j, 0);
				}else {
					D[j] = new Edge(j, Integer.MAX_VALUE);
				}
			}
			
			visited = new boolean[V];
			// 가중치가 낮은 순으로 돌아가는 pq
			queue = new PriorityQueue<>();
			queue.offer(D[i]);
			
			while(!queue.isEmpty()) {
				
				Edge e = queue.poll();
				// 시작점을 제외하고 방문처리를 해주자
				if(e.x != i)
					visited[e.x] = true; 

				for (int j = 0; j < adlist[e.x].size(); j++) {
					Edge next = adlist[e.x].get(j);
					
					// 만약 다음 갈곳이 사이클 이라면 ..? 현재점에서 가중치가 제일 적은지 확인하고 넣어주자
					if(next.x == i) {
						ans = Math.min(ans, next.v + D[e.x].v);
						continue;
					}
					// 가중치가 더 낮다면 해당 점으로 이동..
					if(!visited[next.x] && D[next.x].v > next.v + D[e.x].v) {
						D[next.x].v = next.v + D[e.x].v;
						queue.remove(D[next.x]);
						queue.offer(D[next.x]);
					}
				}
			}
		}
		
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

		@Override
		public String toString() {
			return "Edge [x=" + x + ", v=" + v + "]";
		}
		
		
		
	}

}
