package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1798_범준이의_제주도_여행_계획 {

	private static int N;
	private static int M;
	private static int[][] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 무향 그래프
			graph = new int[N][N];
			for (int i = 0; i < N-1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = i+1; j < N; j++) {
					graph[i][j] = graph[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			/*for (int[] a : graph) {
				System.out.println(Arrays.toString(a));
			}*/
		}

	}
	public static class Pair {
		char type;
		
	}
}
