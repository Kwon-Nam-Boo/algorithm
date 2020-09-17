package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5643_D4_키_순서_플로이드 {
	
	private static int N,M;
	private static int INF=Integer.MAX_VALUE;
	private static int graph[][];
	private static int count[];
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			graph = new int[N+1][N+1];
			count = new int[N+1];
			
			for(int i = 0; i <=N; i++) {
				Arrays.fill(graph[i], INF);
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = 1 ;
			}
			/*for (int[] a : graph) {
				System.out.println(Arrays.toString(a));
			}*/
			
			// 플로이드 와샬
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if(r == c) continue;
					for (int i = 0; i < N; i++) {
						if(i == r || i == c) continue;
						if(graph[i][c] != INF && graph[r][i] !=INF &&(graph[r][c]> graph[i][c] + graph[r][i])) {
							graph[r][c] = graph[i][c] + graph[r][i];
						}
					}
				}
			}
			
			/*for(int i = 1; i <=N; i++) {
				for(int j = 1; j <=N; j++) {
					System.out.print(graph[i][j] + "\t");
				}
				System.out.println();
			}*/
			
			for(int i = 1; i <=N; i++) {
				for(int j = 1; j <=N; j++) {
					if(graph[i][j]!=INF) {
						count[i]++;
						count[j]++;
					}
				}
			}
			//System.out.println(Arrays.toString(count));
			
			int ans =0;
			for (int i = 1; i <=N; i++) {
				if(count[i] == N-1) ans++;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
		

}
