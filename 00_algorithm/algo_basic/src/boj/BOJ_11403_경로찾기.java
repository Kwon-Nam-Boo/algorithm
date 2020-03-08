package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {

	private static int N;	
	private static int[][] map;
	private static boolean[] visited;
	private static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		graph = new ArrayList[N];
		for (int j = 0; j < graph.length; j++) {
			graph[j] = new ArrayList<>(); 
		}
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] =Integer.parseInt(st.nextToken());
				if(map[r][c]==1) {
					graph[r].add(c);
				}
			}
		}
		//System.out.println(Arrays.toString(graph));
		
		visited = new boolean[N];
		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(visited, false);
			dfs(i,i);
		}
		
		for (int r = 0; r < N; r++) {
			 for (int c = 0; c < N; c++) {
				sb.append(map[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int index, int d) {
		List<Integer> childs = graph[d];
		for (int i = 0; i < childs.size(); i++) {
			int child = childs.get(i);
			if(!visited[child]) {
				visited[child] = true;
				map[index][child] = 1;
				dfs(index,child);
			}
		}
	}
}
