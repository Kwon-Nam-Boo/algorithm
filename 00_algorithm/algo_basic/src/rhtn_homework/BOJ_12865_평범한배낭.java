package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {

	private static int N,K;
	private static int[][] WV;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N =Integer.parseInt(st.nextToken());
		K =Integer.parseInt(st.nextToken());
		
		int[][] DP = new int[N+1][K+1];
		
		WV = new int[N+1][2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			WV[i][0] = w;
			WV[i][1] = v;
		}
		
		for (int r = 1; r <= N; r++) {	// 물건 
			int w = WV[r][0];
			int v = WV[r][1];
			for (int c = 1; c <= K; c++) {	//무게
				// 물건 무게가 가방보다 크다면
				if(w > c) {
					DP[r][c] = DP[r-1][c];
				}else {
					// 해당 물건을 넣는게 이득인지, 손해인지를 따져본다 
					DP[r][c] = Math.max(DP[r-1][c], DP[r-1][c-w] + v);
				}
			}
		}
		System.out.println(DP[N][K]);
	}

}
