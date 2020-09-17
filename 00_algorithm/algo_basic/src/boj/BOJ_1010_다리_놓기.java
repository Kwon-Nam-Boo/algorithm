package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.omg.Messaging.SyncScopeHelper;

public class BOJ_1010_다리_놓기 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] DP = new int[31][31];
			
			for (int j = 1; j <= m; j++) {
				DP[j][1] = j;
			}
//			for (int[] is : DP) {
//				System.out.println(Arrays.toString(is));
//				}
//			System.out.println();
			for (int i = 2; i <= n; i++) {
				for (int j = 2; j <= m; j++) {
					DP[j][i] = DP[j-1][i-1] + DP[j-1][i];
				}
			}
			sb.append(DP[m][n] + "\n");
//			for (int[] is : DP) {
//			System.out.println(Arrays.toString(is));
//			}
		}
		System.out.println(sb);
	}
}
