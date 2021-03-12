package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {

	private static int N;
	private static List<Edge>[] adlist;
	private static Point[] point;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		adlist = new ArrayList[N];
		point = new Point[N];
		
		for (int i = 0; i < N; i++) {
			adlist[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			point[i] = new Point(a, b);
			
			for (int j = 0; j < i; j++) {
				double length = Math.sqrt(Math.pow(point[i].x - point[j].x, 2)+Math.pow(point[i].y - point[j].y, 2));
				adlist[i].add(new Edge(j,length));
				adlist[j].add(new Edge(i,length));
			}
		}

		visited = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0,0));
		
		double ans = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			
			Edge e =pq.poll();
			// 방문 확인
			if(visited[e.x]) continue;
			
			visited[e.x] = true;
			ans+=e.w;
			cnt++;
			
			for (int i = 0; i < adlist[e.x].size(); i++) {
				Edge next = adlist[e.x].get(i);
				if(!visited[next.x]){
					pq.offer(next);
				}
			}
			
			if(cnt == N) break;
		}
		System.out.println((int)(ans*100)/100.0);
	}
	
	public static class Edge implements Comparable<Edge>{
		
		int x;
		double w;
		
		public Edge(int x, double w) {
			super();
			this.x = x;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
		
	}
	
	public static class Point{
		double x,y;

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
