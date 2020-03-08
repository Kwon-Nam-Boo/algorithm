package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14496_그대_그머가되어 {
	
	private static int a;
	private static int b;
	private static int N;
	private static int M;
	private static int ans;
	private static boolean[] visited;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);							// 설명은 없지만 양방향이었다고 합니다
		}
		ans =-1;
		bfs(a);
		System.out.println(ans);
		
	}
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] =true;
		int dis =0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int tmp = queue.poll();
				// 정담 조건
				if(tmp == b) {
					ans =dis;
					return;
				}
				List<Integer> childs = graph[tmp];
				for (int j = 0; j < childs.size(); j++) {
					int child = childs.get(j);
					if(!visited[child]) {
						queue.offer(child);
						visited[child] =true;
					}
				}
			}
			dis++;
		}
	}
}
