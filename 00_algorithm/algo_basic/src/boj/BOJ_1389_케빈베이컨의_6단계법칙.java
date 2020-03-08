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

public class BOJ_1389_케빈베이컨의_6단계법칙 {
	
	private static int N;
	private static int M;
	private static int min;
	private static int result;
	private static int ans;
	private static List<Integer>[] graph;
	private static int[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visited = new int[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		min = Integer.MAX_VALUE;
		ans = N;
		for (int i = 1; i <=N ; i++) {
			Arrays.fill(visited, 0);
			bfs(i);
			result = 0;
			for (int j = 0; j < visited.length; j++) {
				if(i == j) continue;
				result+= visited[j];
			}
			if(min >result) {
				min =result;
				ans = i;
			}
		}
		System.out.println(ans);
	}
	public static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i);
		visited[i]++;
		while(!queue.isEmpty()) {
			int a = queue.poll();
			List<Integer> childs = graph[a];
			for (int j = 0; j < childs.size(); j++) {
				int child = childs.get(j);
				if(visited[child] == 0) {
					queue.offer(child);
					if(a==i) {
						visited[child] =1;
					}else {
						visited[child] = visited[a]+1;
					}
				}
			}
		}
	}

}
