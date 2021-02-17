package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10159_저울 {

	private static int N,M;
	private static final int max = Integer.MAX_VALUE;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], max);
			map[i][i] = 0;
		}
				
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = 1;
		}

		// 플로이드 - 와샬
		for (int i = 0; i < N; i++) {	// 경유
			for (int r = 0; r < N; r++) {	// 출발
				// 경유지와 출발지가 같으면 무의미
				if(i == r) continue;	
				for (int c = 0; c < N; c++) {	// 도착
					// 세점중 같은게 있다면 무의미
					if(i == c || r == c) continue;
					if(map[r][i]!=max && map[i][c]!=max) {
						map[r][c] = 1;
					}
				}
			}
		}
		for (int r = 0; r < map.length; r++) {
			int cnt = 0;
			for (int c = 0; c < map.length; c++) {
				if(map[r][c]==max && map[c][r]==max) {
					cnt++;
				}
			}
			sb.append(cnt +"\n");
		}
		System.out.println(sb);
	}

}
