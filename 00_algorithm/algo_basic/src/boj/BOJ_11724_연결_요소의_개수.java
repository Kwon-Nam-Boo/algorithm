package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_11724_연결_요소의_개수 {

	private static List<Integer>[] graph;
	private static boolean[] visited;
	private static int people;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		people=N;
		int count = 0;
		while(true) {
			int start= 0;
			for (int i = 1; i < N; i++) {
				if(!visited[i]) {
					start =i;
				}
			}
			bfs(start);
			count++;
			if(people ==0) {
				break;
			}
		}
		System.out.println(count);
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		people--;
		
		while(!queue.isEmpty()) {
			//int tmp = queue.poll();
			List<Integer> childs = graph[queue.poll()];
			for (int i = 0; i < childs.size(); i++) {
				int child = childs.get(i);
				if(!visited[child]) {
					queue.offer(child);
					visited[child]= true;
					people--;
				}
			}
		}
	}
}
