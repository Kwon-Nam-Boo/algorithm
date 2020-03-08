package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_15900_나무탈출 {
	
	private static int N;
	private static int sum;
	private static List<Integer>[] graph;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		sum =0;
		dfs(1,0);
		//System.out.println(sum);
		if(sum%2 == 1) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		//System.out.println(Arrays.toString(graph));
	}
	public static void dfs(int idx,int r) {
		if(check(idx)) {
			sum+=r;
		}
		visited[idx] = true;
		for (int i = 0; i < graph[idx].size(); i++) {
			int child = graph[idx].get(i);
			if(!visited[child]) {
				dfs(child,r+1);
			}
		}
	}
	public static boolean check(int idx) {
		for (int i = 0; i < graph[idx].size(); i++) {
			if(!visited[graph[idx].get(i)]) {
				return false;
			}
		}
		return true;
	}

}
