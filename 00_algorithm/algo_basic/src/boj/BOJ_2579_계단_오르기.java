package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2579_계단_오르기{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] D = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//System.out.println(Arrays.toString(arr));
		
		D[0] = 0;
		D[1] = arr[1];
		if(N!=1) {
			D[2] = arr[1] + arr[2];
		}
		for (int i = 3; i <= N; i++) {
			D[i] = Math.max(D[i-2], D[i-3]+ arr[i-1]) +arr[i];
		}
		//System.out.println(Arrays.toString(D));
		System.out.println(D[N]);
	}

}
