package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294_동전2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k+1];
		int[] coin = new int[n];
		
		// 초기화
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE-1;
		}
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(coin);
		
		for (int i = 0; i < coin.length; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j -coin[i]]+1, dp[j]);
			}
			//System.out.println(Arrays.toString(dp));
		}
		
		
		System.out.println((dp[k] != Integer.MAX_VALUE-1) ? dp[k]: -1);
	}
}
