package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1613_역사 {
	
	private static int N,K,S;
	private static int[][] adMap;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		adMap = new int[N][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			adMap[a][b] = 1;
		}
		
		S = Integer.parseInt(br.readLine());
		
		// 경유
		for (int k = 0; k < N; k++) {
			// 출발
			for (int r = 0; r < N; r++) {
				if(k == r) continue;
				//도착
				for (int c = 0; c < N; c++) {
					if(k == c || k ==r) continue;
					if(adMap[r][k] == 1 && adMap[k][c] == 1)
						adMap[r][c] =1;
				}
			}
		}
		
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(adMap[a][b] == 0 && adMap[b][a] == 0) sb.append(0 + "\n");
			else if(adMap[a][b] == 1) sb.append(-1 + "\n");
			else if(adMap[b][a] == 1) sb.append(1 + "\n");
		}
		System.out.println(sb);
	}

}
