package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2293_동전1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] DP = new int[K+1];
		int[] coin = new int[N];
		
		for (int i = 0; i < coin.length; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		DP[0] = 1;
		
		for (int i = 0; i < coin.length; i++) {
			for (int j = coin[i]; j <= K; j++) {
				DP[j] = DP[j] + DP[j-coin[i]];
			}
		}

		System.out.println(DP[K]);
	}

}
