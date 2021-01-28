package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1904_01타일 {

	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[10000001]; 
		DP[0] = 0;
		DP[1] = 1;
		DP[2] = 2;
		if(N > 2) {
			for (int i = 3; i < DP.length; i++) {
				DP[i] = (DP[i-1] + DP[i-2])% 15746;
			}	
		}	
		System.out.println(DP[N]);
		
	}
}
