package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5643_D4_키_순서 {
	
	private static int N,M,cnt,ans;
	private static int[][] graph;
	private static int[] idxCnt;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			N =Integer.parseInt(br.readLine());
			M =Integer.parseInt(br.readLine());
			
			graph = new int[N+1][N+1];
			
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b]=1;
			}
			
			ans =0;
			for (int i = 1; i < N+1; i++) {
				cnt =0;
				visited = new boolean[N+1];
				smaller(i);
				visited = new boolean[N+1];
				taller(i);
				if(cnt == N-1) {
					ans++;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void smaller(int x) {
		// 종료
		visited[x] = true; 
		// 일반
		for (int i = 1; i < N+1; i++) {
			if(visited[i] || graph[x][i]!=1) continue;
			cnt++;
			smaller(i);
		}
		
		return;
	}
	private static void taller(int x) {
		// 종료
		visited[x] = true; 
		// 일반
		for (int i = 1; i < N+1; i++) {
			if(visited[i] || graph[i][x]!=1) continue;
			cnt++;
			taller(i);
		}	
		
	}

}
