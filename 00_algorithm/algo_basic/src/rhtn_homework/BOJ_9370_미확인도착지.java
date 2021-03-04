package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_9370_미확인도착지 {
	
	private static int T,n,m,t,s,g,h;
	private static List<Edge>[] adlist;
	private static boolean[] check;
	private static List<Integer> tlist;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int te = 0; te < T; te++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			
			adlist = new ArrayList[n];
			for (int i = 0; i < adlist.length; i++) {
				adlist[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken())-1;
			g = Integer.parseInt(st.nextToken())-1;
			h = Integer.parseInt(st.nextToken())-1;
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				// D 는 2배 한다. 냄새나는 구간이면 -1해주자(작게 만들어주기위함. 같은길이의 경우 먼저 실행되게)
				int d = Integer.parseInt(st.nextToken())*2;
				if((b == g && a == h)|| (a == g && b == h)){
					d-=1;
				}
				adlist[a].add(new Edge(b,d,0));
				adlist[b].add(new Edge(a,d,0));
			}
			tlist = new ArrayList<>();
			for (int i = 0; i < t; i++) {
				tlist.add(Integer.parseInt(br.readLine())-1);
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			Edge D[] = new Edge[n];
			for (int i = 0; i < D.length; i++) {
				if(i == s)
					D[i] = new Edge(i, 0, 0);
				else
					D[i] = new Edge(i, Integer.MAX_VALUE,0);
			}
			pq.offer(D[s]);
			check = new boolean[n];
			
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				
				if(e.w != D[e.x].w) continue;
				
				if(tlist.contains(e.x) && e.visit ==1) {
					check[e.x] = true;
				}
				
				for (Edge next : adlist[e.x]) {
					if(D[next.x].w > D[e.x].w + next.w) {
						D[next.x].w = D[e.x].w + next.w;
						// 만약 해당 부분이 냄새나는 구간일 경우 체크 처리
						if((e.x == g && next.x == h)|| (e.x == h && next.x == g)){
							D[next.x].visit = 1;
						}else {
						// 아니라면 이전 점에서의 체크위치를 가져온다(어차피 냄새나는구간은 1줄였기에,동등한 길이여도 가장 체크를 지나는 경우만 나올것이다)
							D[next.x].visit = D[e.x].visit;
						}
						pq.remove(D[next.x]);
						pq.offer(D[next.x]);
					}
				}
			}
			for (int i = 0; i < D.length; i++) {
				if(check[i])
					sb.append((i+1) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static class Edge implements Comparable<Edge>{
		int x,w,visit;

		public Edge(int x, int w, int visit) {
			super();
			this.x = x;
			this.w = w;
			this.visit = visit;
		}

		
		@Override
		public String toString() {
			return "Edge [x=" + x + ", w=" + w + ", visit=" + visit + "]";
		}


		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}

}
