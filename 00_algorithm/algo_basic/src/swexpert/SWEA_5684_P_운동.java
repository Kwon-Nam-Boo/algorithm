package swexpert;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_5684_P_운동 {
	
	private static int N;
	private static int M;
	private static int ans;
	private static boolean[] visited;
	private static int[][] graph;

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int TC= sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			N = sc.nextInt();
			M = sc.nextInt();
			graph = new int[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				graph[a][b] = c;
			}
			
			ans = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				visited = new boolean[N+1];
				dfs(i,i,0);
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		
	}
	public static void dfs(int now, int start, int dis) {
		if(now == start && visited[now]) {			//  사이클로 돌아왓으면
			if(dis< ans) {
				ans = dis;
			}
			return;
		}
		if(visited[now]) {
			return;
		}
		if(dis>=ans) {
			return;
		}
		visited[now] = true;
		for (int i = 1; i <= N; i++) {
			if(graph[now][i]>0) {
				dfs(i,start,dis + graph[now][i]);
			}
		}
	}

}
