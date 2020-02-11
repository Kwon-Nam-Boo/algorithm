package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {
	
	private static int c;
	private static int N;
	private static int result = -1;
	private static List<Integer>[] graph;
	private static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i]= new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		//System.out.println(Arrays.toString(graph));
		
		dfs(S,E);
		System.out.println(result);

	}
	public static void dfs(int d, int end) {
		visited[d] =true;
		if(d == end) {
			result = c;
			return;
		}
		
		List<Integer> childs = graph[d]; 
		for (int i = 0; i < childs.size(); i++) {
			Integer child = childs.get(i);
			if(!visited[child]) {
				c++;
				dfs(child, end);
				c--;
			}
		}
	}
}
