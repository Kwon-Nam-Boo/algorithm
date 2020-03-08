package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2814_D3_최장경로 {
	
	private static int N;
	private static int M;
	private static int max;
	private static boolean[] visited;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			visited = new boolean[N+1];
			graph = new ArrayList[N+1];
			for (int j = 1; j < N+1; j++) {
				graph[j] = new ArrayList<>();
			}
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x].add(y);
				graph[y].add(x);
			}
			
			max = Integer.MIN_VALUE;
			for (int j = 1; j <= N; j++) {
				dfs(j,1);
				Arrays.fill(visited, false);
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);

	}
	public static void dfs(int x,int r) {
		max = Math.max(max, r);
		visited[x] =true;
		
		List<Integer> childs = graph[x];
		for (int i = 0; i < childs.size(); i++) {
			int child = childs.get(i);
			if(!visited[child]) {
				dfs(child,r+1);
				visited[child] =false;
			}
		}
	}
	
}
