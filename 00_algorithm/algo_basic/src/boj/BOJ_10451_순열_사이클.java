package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10451_순열_사이클 {

	private static int N;
	private static boolean[] visited;
	private static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); 
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < TC; i++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			visited = new boolean[N+1];
			graph = new ArrayList[N+1];						// 그래프 생성
			for (int j = 1; j <= N; j++) {
				graph[j] = new ArrayList<>();
				int a = Integer.parseInt(st.nextToken());
				graph[j].add(a);
			}
			int count=0;
			for (int j = 1; j <= N; j++) {
				if(!visited[j]) {
					dfs(j);
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int r) {
		visited[r] =true;
		int next =graph[r].get(0);
		if(!visited[next]) {
			dfs(next);
		}
	}
}
