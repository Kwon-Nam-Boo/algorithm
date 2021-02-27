package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11052_카드구매하기 {

	private static int N;
	private static int[] pack, DP;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		pack = new int[N+1];
		DP = new int[N+1];
		DP[0] = 0;
		for (int i = 1; i < N+1; i++) {
			pack[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < DP.length; i++) {
			for (int j = 1; j < pack.length; j++) {
				if(i-j < 0) break;
				DP[i] = Math.max(DP[i], DP[i-j] + pack[j]);
			}
		}
		//System.out.println(Arrays.toString(DP));
		System.out.println(DP[N]);
	}

}
