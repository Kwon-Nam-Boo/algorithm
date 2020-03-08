package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2617_구슬찾기 {

	private static int N;
	private static int M;
	private static int idx;
	private static int count;
	private static boolean[] visited;
	private static boolean[] v;
	private static List<Integer>[] graph;
	private static List<Integer>[] graph2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		v= new boolean[N+1];
		graph = new ArrayList[N+1];
		graph2 = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			graph2[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[b].add(a);
			graph2[a].add(b);
		}
		
		for (int i = 1; i <= N; i++) {
			Arrays.fill(visited, false);
			idx = 0;
			dfs(i,graph);						// 정방향 그래프
			if(idx == ((N+1)/2)) {				
				v[i] =true;
			
			}
			Arrays.fill(visited, false);
			idx = 0;
			dfs(i,graph2);						// 역방향 그래프
			if(idx == ((N+1)/2)) {
				v[i] =true;
	
			}
		}
		int count=0;
		for (int i = 0; i < v.length; i++) {
			if(v[i]) count++;
		}
		System.out.println(count);
	}
	public static void dfs(int r,List<Integer>[] g) {
		if(idx == ((N+1)/2)) {							// 중간값을 넘으면 더이상 할 필요가없다
			return;
		}
		visited[r] = true;
		for (int i = 0; i < g[r].size(); i++) {
			int child = g[r].get(i);
			if(!visited[child]) {
				idx++;
				dfs(child,g);
				if(idx == ((N+1)/2)) {					// 중간값을 넘으면 더이상 할 필요가없다
					return;
				}
			}
		}
		
	}

}
