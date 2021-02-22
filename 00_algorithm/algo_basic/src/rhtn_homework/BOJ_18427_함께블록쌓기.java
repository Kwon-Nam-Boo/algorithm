package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18427_함께블록쌓기 {

	private static int N,M,H;
	private static int[][] block, DP;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		block = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			while(st.hasMoreTokens()) {
				block[i][cnt] = Integer.parseInt(st.nextToken());
				cnt++;
			}
		}

		DP = new int[N][H+1];
		
		// 초기화:첫줄은 블록만큼 카운트
		for (int i = 0; i < M; i++) {
			DP[0][block[0][i]]++;
		}
		// 0일경우는 1로 초기화
		for (int i = 0; i < N; i++) {
			DP[i][0] = 1;
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= H; j++) {
				// 블럭을 추가하기 전까지는 가능한개수가 같을 것이다.
				DP[i][j] = DP[i-1][j];
				DP[i][j]%=10007;
				// 추가할 블럭과 대응하는 DP의 개수는 곧 가능한 개수가 된다
				for (int k = 0; k < M; k++) {
					if(block[i][k] > j || block[i][k] == 0) break;
					DP[i][j]+=DP[i-1][j-block[i][k]];
					DP[i][j]%=10007;
				}
			}
		}
		System.out.println(DP[N-1][H]);
	}

}
