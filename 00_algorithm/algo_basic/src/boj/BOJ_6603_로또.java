package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {
	
	private static int N;
	private static int R=6;
	private static int[] arr;
	private static int[] result;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			arr = new int[N];
			result = new int[R];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			nCr(0,0);
			sb.append("\n");
		}
		System.out.println(sb);

	}
	public static void nCr(int r, int k) {
		if(r == R) {
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = k; i < arr.length; i++) {
			result[r] = arr[i];
			nCr(r+1,i+1);
		}
	}
	

}
