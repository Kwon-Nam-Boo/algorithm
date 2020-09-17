package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1932_정수_삼각형 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int[][] DP = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for (int[] is : arr) {
//			System.out.println(Arrays.toString(is));
//		}
		DP[0][0] = arr[0][0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i+1; j++) {
				if(j == 0) {
					DP[i][j] = DP[i-1][j] + arr[i][j]; 
					continue;
				}
				DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + arr[i][j];
			}
		}
//		for (int[] is : DP) {
//		System.out.println(Arrays.toString(is));
//		}
		int ans = DP[N-1][0];
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, DP[N-1][i]);
		}
		System.out.println(ans);
	}
}
