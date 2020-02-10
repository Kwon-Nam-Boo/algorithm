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

public class BOJ_2606_바이러스 {
	
	private static int C;
	private static List<Integer>[] list;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		C=0;
		bfs(1);
		sb.append(C);
		System.out.println(sb);
		//System.out.println(Arrays.toString(list));
		
	}
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start]=true;
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			List<Integer> childs= list[tmp];
			for (int i = 0; i < childs.size(); i++) {
				Integer child = childs.get(i);
				if(!visited[child]) {
					queue.offer(child);
					visited[child]=true;
					C++;
				}
			}
		}
	}
	

}
