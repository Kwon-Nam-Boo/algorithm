package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15591_MoonTube{

	private static int N,Q;
	private static List<Edge>[] adlist;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		adlist = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adlist[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int u = Integer.parseInt(st.nextToken());
			adlist[a].add(new Edge(b, u));
			adlist[b].add(new Edge(a, u));
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int s= Integer.parseInt(st.nextToken())-1;
			
			visited = new boolean[N];
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(s);
			visited[s] = true;
			
			int ans = 0;
			while(!queue.isEmpty()) {
				int q = queue.poll();
				for (int j = 0; j < adlist[q].size(); j++) {
					Edge next = adlist[q].get(j);
					if(!visited[next.x] && next.v >= u) {
						visited[next.x] = true;
						queue.offer(next.x);
						ans++;
					}
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
	
	public static class Edge{
		int x,v;

		public Edge(int x, int v) {
			super();
			this.x = x;
			this.v = v;
		}
		
	}
}
