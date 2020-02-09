package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	
	private static int N;
	private static int line;
	private static int start;
	private static List<Integer>[] list;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		visited = new boolean[N+1];
		
		for (int i = 0; i < line; i++) {				// makeGraph 그래프 만들기
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);								// 양방향
			list[b].add(a);
		}
		
		for(int i = 1; i<=N; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(start);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs(start);
		System.out.println(sb);
	}
	
	public static void dfs(int d) {
		
		visited[d] =true;
		sb.append(d).append(" ");
		for (int i = 0; i < list[d].size(); i++) {
			int child = list[d].get(i);
			if(!visited[child]) {
				dfs(child);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] =true;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			sb.append(tmp).append(" ");
			List<Integer> childs = list[tmp];
			for (int i = 0; i < childs.size(); i++) {
				Integer child = childs.get(i);
				if(!visited[child]) {
					queue.offer(child);
					visited[child] =true;
				}
			}
		}
	}
	
	
}
